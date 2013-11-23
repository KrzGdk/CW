/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;
import dictionary.CwEntry;
import board.Board;

/**
 *
 * @author Krzysiek
 */
public abstract class Strategy{
    abstract public CwEntry findEntry(Crossword cw);
    abstract public void updateBoard(Board b, CwEntry e);
}
