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
        } else if (!cw.isFull()) {
            Entry horizWord = cw.getCwDB().getRandom(cw.getBoardCopy().createHorizMixedLengthPattern(cw.numOfEntries()-1));
            return new CwEntry(horizWord,(cw.getBoardCopy().getWidth() / 2)-horizWord.getWord().indexOf(cw.getBoardCopy().getCell(cw.numOfEntries()-1, (cw.getBoardCopy().getWidth() / 2)).getContent()) ,cw.numOfEntries()-1, Direction.HORIZ);
        } else {
            return null;
        }
    }
    
    @Override
    public void updateBoard(Board b, CwEntry e){
        if(e.getDir() == Direction.VERT){
            for(int i=e.getY(); i<e.getWord().length(); i++){
                b.setCell(i, e.getX(), new BoardCell(Character.toString(e.getWord().charAt(i-e.getY()))));
            }
            b.printBoard();
            System.out.println("-----------");
        }
        else{
            for(int i=e.getX(); i<e.getWord().length()+e.getX()-1; i++){
                System.out.println(i + " " + (i-e.getX()) + "/" + (e.getWord().length()-1) + e.getWord() + e.getClue());
                //b.printBoard();
                //System.out.println("-----------");
                b.setCell(e.getY(), i, new BoardCell(Character.toString(e.getWord().charAt(i-e.getX()))));
            }
            b.setCell(e.getY(), e.getWord().length()+e.getX()-1, 
                    new BoardCell(Character.toString(e.getWord().charAt(e.getWord().length()-1))));
            System.out.println("--NASTĘPNE!--");
        }
    }
}
