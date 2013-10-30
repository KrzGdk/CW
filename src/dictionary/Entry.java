/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author Krzysiek
 */
public class Entry{
    private String word;
    private String clue;
    
    public Entry(String word, String clue){
        this.word = word;
        this.clue = clue;
    }
    public String getWord(){
        return this.word;
    }
    public String getClue(){
        return this.clue;
    }
}
