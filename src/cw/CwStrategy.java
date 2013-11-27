/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;

import board.Board;
import board.BoardCell;
import dictionary.CwEntry;
import dictionary.Direction;
import dictionary.Entry;

/**
 *
 * @author Krzysiek
 */
public class CwStrategy extends Strategy{
    
    @Override
    public CwEntry findEntry(Crossword cw){
        if (cw.isEmpty()) {
            Entry solution = cw.getCwDB().getRandom(cw.getBoardCopy().getHeight());
            return new CwEntry(solution, (cw.getBoardCopy().getWidth() / 2), 0, Direction.VERT);
//        } else if (!cw.isFull()) {
//            Entry horizWord = cw.getCwDB().getRandom(cw.getBoardCopy().createHorizMixedLengthPattern(cw.numOfEntries()));
//            return new CwEntry(horizWord,(cw.getBoardCopy().getWidth() / 2)-horizWord.getWord().indexOf(cw.getBoardCopy().getCell((cw.getBoardCopy().getWidth() / 2), cw.numOfEntries()).getContent()) ,cw.numOfEntries(), Direction.HORIZ);
        } else {
            return null;
        }
    }
    
    @Override
    public void updateBoard(Board b, CwEntry e){
        if(e.getDir() == Direction.VERT){
            for(int i=e.getY(); i<e.getWord().length(); i++){
                b.setCell(e.getX(), i, new BoardCell(Character.toString(e.getWord().charAt(i-e.getY()))));
                System.out.println(Character.toString(e.getWord().charAt(i-e.getY())));
            }
        }
    }
}
