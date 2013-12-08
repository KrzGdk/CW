package board;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Board is a class representing crossword's board
 *
 * @author Krzysztof Gądek
 */
public class Board implements Serializable{
    private BoardCell[][] board;
    private int width, height;
    
    
    /**
     * Constructor setting the width and height of the board.
     *
     * @param height
     * @param width
     */
    public Board(int height, int width){
        this.width = width;
        this.height = height;
        board = new BoardCell[height][width];
    }
    /**
     * Prints the whole board to standard input (useful when debugging)
     *
     */
    public void printBoard(){
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                if(board[i][j] == null) System.out.print(".");
                else System.out.print(board[i][j].getContent());
            }
            System.out.print("\n");
        }
    }
    
    /**
     * Makes a copy of the crossword's board
     *
     * @return copy of itselfs
     */
    public Board copyBoard(){
        Board copy = new Board(this.height, this.width);
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                copy.setCell(i, j, this.board[i][j]);
//                System.out.println(this.board[j][i]);
            }
        }
        return copy;
    }

    /**
     * Gets the width of the board
     * 
     * @return the width
     */
    public int getWidth(){
        return width;
    }

    /**
     * Gets the height of the board
     * 
     * @return the height
     */
    public int getHeight(){
        return height;
    }
    
    /**
     * Gets the cell at given coordinates
     *
     * @see BoardCell
     * @param vert  vertical coordinate
     * @param horiz horizontal coordinates
     * @return cell at given coordinates
     */
    public BoardCell getCell(int vert, int horiz){
        return board[vert][horiz];
    }
    
    /**
     * Sets the cell at given coordinates
     *
     * @see BoardCell
     * @param vert  vertia coordinate
     * @param horiz horizontal coordinate
     * @param cell  cell to set
     */
    public void setCell(int vert, int horiz, BoardCell cell){
        board[vert][horiz] = cell;
    }
    
    /**
     * Returns the list of cells where the entry can start
     *
     * @return list of entries where words can start
     */
    public LinkedList<BoardCell> getStartCells(){
        LinkedList<BoardCell> cells = new LinkedList<>();
        for(BoardCell[] b : board){
            for(BoardCell i : b){
                if(i.canStart()) cells.add(i);
            }
        }
        return cells;
    }
    
    /**
     * Creates a regular expression which matches the line between
     * fromx and tox or fromy and toy
     *
     * @param fromx x cooridinate to start the pattern
     * @param fromy y cooridinate to start the pattern
     * @param tox   x cooridinate to end the pattern
     * @param toy   y cooridinate to end the pattern
     * @return
     */
    public String createPattern(int fromx, int fromy, int tox, int toy){
        String pattern = "";
        if(fromx == tox){
            for(int i=fromy;i<=toy;i++){
                if(board[fromx][i].getContent() == null){
                    pattern += ".";
                }
                else{
                    pattern += board[fromx][i].getContent();
                }
            }
        }
        else{
            for(int i=fromx;i<=tox;i++){
                if(board[fromy][i].getContent() == null){
                    pattern += ".";
                }
                else{
                    pattern += board[fromy][i].getContent();
                }
            }
        }
        return pattern;
    }
    /**
     * Creates a regular expression for a horizontal word that crosses the 
     * solution 
     * 
     * @param row number of row where word should fit
     * @return regular expression pattern which matches the row
     */
    public String createHorizMixedLengthPattern(int row){
        String pattern = ".{0," + width/2 + "}";
        for(int i=0;i<width;i++){
            if(board[row][i] != null){
                pattern += board[row][i].getContent();
            }
        }
        if(width%2 == 1) pattern += ".{0," + width/2 + "}";
        else pattern += ".{0," + ((width/2)-1) + "}";
        return pattern;
    }
}
