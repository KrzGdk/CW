/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;
import board.Board;
import dictionary.*;
import browser.*;
import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krzysiek
 */
public class Crossword implements Serializable{
    private LinkedList<CwEntry> entries;
    private Board b;  // !!
    private InteliCwDB cwdb;
    private long id;
    
    public Crossword(int height, int width, String db){
        entries = new LinkedList<>();
        b = new Board(height, width);
        cwdb = new InteliCwDB(db);
    }
    
    public Iterator<CwEntry> getROEntryIter(){
        return Collections.unmodifiableList(this.entries).iterator();
    }
    public boolean isEmpty(){
        if(entries.size() == 0) return true;
        else return false;
    }
    public boolean isFull(){
        if(entries.size() == entries.element().getWord().length()+1) return true;
        else return false;
    }
    public int numOfEntries(){
        return entries.size();
    }
    public Board getBoardCopy(){
        return b.copyBoard();
    }
    public InteliCwDB getCwDB(){
        return cwdb;
    }
    public LinkedList<CwEntry> getEntries(){
        return entries;
    }
    public void setCwDB(InteliCwDB cwdb){
        this.cwdb = cwdb;
    }
    public boolean contains(String word){
        for(CwEntry i : entries){
            if(i.getWord().equals(word)) return true;
        }
        return false;
    }
    public final void addCwEntry(CwEntry cwe, Strategy s){
        entries.add(cwe);
        s.updateBoard(b,cwe);
    }
    public final void generate(Strategy s){
        CwEntry e = null;
        while((e = s.findEntry(this)) != null){
            addCwEntry(e,s);
        }
    }
        /**
     * @return the id
     */
    public long getId(){
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id){
        this.id = id;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{        
        Strategy s = new CwStrategy();
        
//        Crossword cw = new Crossword(10,15,"C:\\Users\\Krzysztof\\Documents\\NetBeansProjects\\CW\\src\\cwdb.txt");
//        cw.generate(s);
//        cw.getBoardCopy().printBoard();
        CwBrowser b = new CwBrowser(".");
        try {
            for(Crossword c : b.loadAll()){
                c.getBoardCopy().printBoard();
                System.out.println("\n");
            }
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(Crossword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
