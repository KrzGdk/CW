/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author Krzysiek
 */
public class CwEntry extends Entry{
    public enum Direction {HORIZ, VERT};
    
    private int x;
    private int y;
    private Direction d;
    
    public CwEntry(String word, String clue, int x, int y, Direction d){
        super(word,clue);
        this.x = x;
        this.y = y;
        this.d = d;
    }
    public CwEntry(Entry e, int x, int y, Direction d){
        this(e.getWord(),e.getClue(),x,y,d);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Direction getDir(){
        return d;
    }
}
