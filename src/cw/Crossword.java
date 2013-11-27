/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;
import board.Board;
import dictionary.*;
import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Krzysiek
 */
public class Crossword{
    private LinkedList<CwEntry> entries;
    private Board b;
    private InteliCwDB cwdb;
    private final long ID = -1;
    
    public Crossword(int width, int height, String db){
        entries = new LinkedList<>();
        b = new Board(width, height);
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
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
//        CwDB db = new CwDB("C:\\Users\\Krzysztof\\Documents\\NetBeansProjects\\CW\\src\\cwdb.txt");
//        Entry e = db.get("BAJT");
//        System.out.println(e.getClue());
        
        Strategy s = new CwStrategy();
        
        Crossword cw = new Crossword(10,5,"C:\\Users\\Krzysztof\\Documents\\NetBeansProjects\\CW\\src\\cwdb.txt");
        cw.generate(s);
        cw.getBoardCopy().printBoard();
    }
}
