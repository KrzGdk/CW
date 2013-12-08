package browser;

import cw.Crossword;

/**
 * Interface providing a possibility of saving the crossword
 *
 * @author Krzysztof Gądek
 */
public interface Writer{
    /**
     * Writes the crossword to file
     *
     * @see Crossword
     * @param cw crossword to be saved
     */
    public void write(Crossword cw);
}
