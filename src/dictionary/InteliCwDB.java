/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Krzysiek
 */
public class InteliCwDB extends CwDB{
    public InteliCwDB(String filename) throws IOException{
        super(filename);
    }
    public LinkedList<Entry> findAll(String pattern){
        LinkedList<Entry> result = new LinkedList<>();
        for(Entry i : db){
            if(i.getWord().matches(pattern)){
                result.add(i);
            }
        }
        return result; 
    }
    public Entry getRandom(){
        Random gen = new Random();
        return db.get(gen.nextInt(db.size()));
    }
    public Entry getRandom(int length){
        Random gen = new Random();
        LinkedList<Entry> matching = findAll("/^[a-zA-Z0-9]{" + length + "}$/");
        return matching.get(gen.nextInt(db.size()));
    }
    public Entry getRandom(String pattern){
        Random gen = new Random();
        LinkedList<Entry> matching = findAll(pattern);
        return matching.get(gen.nextInt(db.size()));
    }
    
    @Override
    public void add(String word, String clue){
        int i;
        for(i = 0;i<db.size();i++){
            if(word.toUpperCase().compareTo(db.get(i).getWord()) < 0) break;
        }
        db.add(i, new Entry(word,clue));
    }
}
