package dictionary;

import java.io.Serializable;

/**
 * Extended class to represent the entry, adds the coordinates and the direction of the word in crossword
 *
 * @author Krzysztof Gądek
 */
public class CwEntry extends Entry implements Serializable{
    
    private int x;
    private int y;
    private Direction d;
    
    /**
     * Constructs an entry with given word, clue, coordinates and direction
     *
     * @see Entry
     * @see Direction
     * @param word word of the entry
     * @param clue clue for the word
     * @param x horizontal coordinate where entry starts
     * @param y vertical coordinate where entry starts
     * @param d direction of the entry
     */
    public CwEntry(String word, String clue, int x, int y, Direction d){
        super(word,clue);
        this.x = x;
        this.y = y;
        this.d = d;
    }
    /**
     * Constructs an extended entry with given Entry object, coordinates and direction
     *
     * @see Entry
     * @see Direction
     * @param e Entry object
     * @param x horizontal coordinate where entry starts
     * @param y vertical coordinate where entry starts
     * @param d direction of the entry
     */
    public CwEntry(Entry e, int x, int y, Direction d){
        this(e.getWord(),e.getClue(),x,y,d);
    }
    /**
     * Gets the horizontal coordinate where the word starts
     *
     * @return horizontal coordinate
     */
    public int getX(){
        return x;
    }
    /**
     * Gets the vertical coordinate where the word starts
     *
     * @return vertical coordinate
     */
    public int getY(){
        return y;
    }
    /**
     * Gets the direction of the word
     *
     * @return direction of the word
     */
    public Direction getDir(){
        return d;
    }
}
