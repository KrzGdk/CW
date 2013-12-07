package cw;
import dictionary.CwEntry;
import board.Board;

/**
 * Strategy is an abstract class representing a way of filling the board
 * with entries
 *
 * @author Krzysztof Gądek
 */
public abstract class Strategy{
    
    /**
     * Finds an entry that fits on the board
     *
     * @see Crossword
     * @param cw crossword to add entry to
     * @return found entry
     */
    abstract public CwEntry findEntry(Crossword cw);
    /**
     * Adds entry to the board
     *
     * @see Board
     * @see CwEntry
     * @param b board to add entry to
     * @param e entry to add
     */
    abstract public void updateBoard(Board b, CwEntry e);
}
