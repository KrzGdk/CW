package browser;

import cw.Crossword;
import java.util.LinkedList;

/**
 * Interface providing a possibility of loading all the crossword
 *
 * @author Krzysiek
 */
public interface Reader{
    /**
     * Reads all saved crosswords
     *
     * @see Crossword
     * @see Writer
     * @return list of loaded crosswords
     */
    LinkedList<Crossword> getAllCws();
}
