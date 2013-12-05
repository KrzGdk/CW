/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.Serializable;

/**
 *
 * @author Krzysiek
 */
public class Entry implements Comparable<Entry>, Serializable{
    private String word;
    private String clue;
    
    public Entry(String word, String clue){
        this.word = word.toUpperCase();
        this.clue = clue;
    }
    public String getWord(){
        return this.word;
    }
    public String getClue(){
        return this.clue;
    }
    
    @Override
    public int compareTo(Entry other){
        return this.word.compareTo(other.getWord());
    }
}
