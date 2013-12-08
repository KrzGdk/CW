package cw;

import board.Board;
import dictionary.*;
import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Crossword is a class representing single crossword.
 * @author Krzysztof Gądek
 */
public class Crossword implements Serializable{
    private LinkedList<CwEntry> entries;
    private Board b;
    private InteliCwDB cwdb;
    private long id;
    
    
    /**
     * Constructs the crossword with empty board
     * 
     * @see Board
     * @see InteliCwDB
     * @param height height of the board
     * @param width  width of the board
     * @param db     path to database to pick entries from
     */
    public Crossword(int height, int width, String db) throws IOException{
        entries = new LinkedList<>();
        b = new Board(height, width);
        cwdb = new InteliCwDB(db);
    }
    
    /**
     * Returns a read only iterator to list of used entries
     * 
     * @return read only iterator of entries
     */
    public Iterator<CwEntry> getROEntryIter(){
        return Collections.unmodifiableList(this.entries).iterator();
    }
    
    /**
     * Checks if there are any entries in crossword
     * 
     * @return <code>true</code> if there are no entries, <code>false</code> otherwise
     */
    public boolean isEmpty(){
        if(entries.size() == 0) return true;
        else return false;
    }
    
    /**
     * Checks if the crossword is fulfilled
     *
     * @return <code>true</code> if all needed entries have been found, <code>false</code> otherwise
     */
    public boolean isFull(){
        if(entries.size() == entries.element().getWord().length()+1) return true;
        else return false;
    }
    
    /**
     * Method checking the number of entries
     *
     * @return number of entries
     */
    public int numOfEntries(){
        return entries.size();
    }
    
    /**
     * Returns a copy of the board of crossword
     *
     * @see Board
     * @return copy of the crossword's board
     */
    public Board getBoardCopy(){
        return b.copyBoard();
    }
    /**
     * Returns a database of the entries to choose from
     *
     * @see InteliCwDB
     * @return database of entries
     */
    public InteliCwDB getCwDB(){
        return cwdb;
    }
    
    /**
     * Returns the list of yet used entries
     *
     * @return list of entries
     */
    public LinkedList<CwEntry> getEntries(){
        return entries;
    }
    
    /**
     * Sets the database to choose entries from
     *
     * @see InteliCwDB
     * @param cwdb database of entries
     */
    public void setCwDB(InteliCwDB cwdb){
        this.cwdb = cwdb;
    }
    
    /**
     * Checks if current entries list contains given word
     *
     * @param word word to find in the list of entries
     * @return <code>true</code> if the list contains the word, <code>false</code> otherwise
     */
    public boolean contains(String word){
        for(CwEntry i : entries){
            if(i.getWord().equals(word)) return true;
        }
        return false;
    }
    
    /**
     * Adds the entry to the database according to given strategy
     *
     * @see CwEntry
     * @see Strategy
     * @param cwe entry to add to crossword
     * @param s strategy used to add entry
     */
    public final void addCwEntry(CwEntry cwe, Strategy s){
        entries.add(cwe);
        s.updateBoard(b,cwe);
    }
    /**
     * Fills all the crossword's board with the entries found by given strategy
     *
     * @see Strategy
     * @param s strategy used to add entries
     */
    public final void generate(Strategy s){
        CwEntry e = null;
        while((e = s.findEntry(this)) != null){
            addCwEntry(e,s);
        }
    }
    
    /**
    * Returns the unique ID of the crossword
    * 
    * @return the id
    */
    public long getId(){
        return id;
    }

    /**
     * Sets the unique ID of the crossword
     * 
     * @param id the id to set
     */
    public void setId(long id){
        this.id = id;
    }
}
