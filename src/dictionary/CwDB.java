/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.LinkedList;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 *
 * @author Krzysiek
 */
public class CwDB implements Serializable{
    protected LinkedList<Entry> db;
    
    public CwDB(String filename) throws IOException{
        createDB(filename);
    }
    public void add(String word, String clue){
        db.add(new Entry(word,clue));
    }
    public Entry get(String word){
        for(Entry e : db){
            if(word.equals(e.getWord())) return e;
        }
        return null;
    }
    public void remove(String word){
        db.remove(get(word));
    }
    public void saveDB(String filename){
        // TODO
    }
    public int getSize(){
        return db.size();
    }
    protected void createDB(String filename) throws IOException{
        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get("cwdb.txt"), StandardCharsets.UTF_8);
            String word;
            String clue;
            while ((word = reader.readLine()) != null) {
                clue = reader.readLine();
                this.add(word,clue);
            }   
        }
        catch(Exception e){
        }
    }
}
