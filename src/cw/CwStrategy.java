package cw;

import board.Board;
import board.BoardCell;
import dictionary.CwEntry;
import dictionary.Direction;
import dictionary.Entry;
import java.util.Iterator;

/**
 * Specified class for strategy
 *
 * @author Krzysiek
 */
public class CwStrategy extends Strategy{
    
    @Override
    public CwEntry findEntry(Crossword cw){
        if (cw.isEmpty()) {
            Entry solution;
            solution = cw.getCwDB().getRandom(cw.getBoardCopy().getHeight());
            
            
            return new CwEntry(solution, (cw.getBoardCopy().getWidth() / 2), 0,  Direction.VERT);
        } else if (!cw.isFull()) {
            Entry horizWord = null;
            Iterator<CwEntry> it = cw.getROEntryIter();
            while(true){
                boolean end = true;
                horizWord = cw.getCwDB().getRandom(cw.getBoardCopy().createHorizMixedLengthPattern(cw.numOfEntries()-1));
                while(it.hasNext()){
                    if(it.next().compareTo(horizWord) == 0) end = false;
                    else end = true;
                }
                if(horizWord == null) return null;
                if(end) break;
            }
            String keyCellContent = cw.getBoardCopy().getCell( cw.numOfEntries()-1, (cw.getBoardCopy().getWidth() / 2)).getContent();
            int delta;
            if(cw.getBoardCopy().getWidth() % 2 == 1){
                delta = (cw.getBoardCopy().getWidth() / 2)-horizWord.getWord().indexOf(keyCellContent, (horizWord.getWord().length() - cw.getBoardCopy().getWidth() / 2)-1);
            }
            else{
                delta = (cw.getBoardCopy().getWidth() / 2)-horizWord.getWord().indexOf(keyCellContent, (horizWord.getWord().length() - cw.getBoardCopy().getWidth() / 2));
            }
            return new CwEntry(horizWord, delta, cw.numOfEntries()-1, Direction.HORIZ);
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
        }
        else{
            for(int i=e.getX(); i<=e.getWord().length()+e.getX()-1; i++){
                b.setCell(e.getY(), i, new BoardCell(Character.toString(e.getWord().charAt(i-e.getX()))));
                System.out.println(e.getX() + e.getWord());
            }
        }
    }
}
