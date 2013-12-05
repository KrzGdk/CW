/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Krzysiek
 */
public class Board implements Serializable{
    private BoardCell[][] board;
    private int width, height;
    public Board(int height, int width){
        this.width = width;
        this.height = height;
        board = new BoardCell[height][width];
    }
    public void printBoard(){
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                if(board[i][j] == null) System.out.print(".");
                else System.out.print(board[i][j].getContent());
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args){
        Board b = new Board(5,5);
        b.setCell(2, 2, new BoardCell("a"));
        System.out.println(b.getCell(2, 3)); 
    }
    
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
     * @return the width
     */
    public int getWidth(){
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight(){
        return height;
    }
    
    public BoardCell getCell(int vert, int horiz){
        return board[vert][horiz];
    }
    public void setCell(int vert, int horiz, BoardCell cell){
        board[vert][horiz] = cell;
    }
    
    public LinkedList<BoardCell> getStartCells(){
        LinkedList<BoardCell> cells = new LinkedList<>();
        for(BoardCell[] b : board){
            for(BoardCell i : b){
                if(i.canStart()) cells.add(i);
            }
        }
        return cells;
    }
    
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
     *
     * @param fromx
     * @param fromy
     * @param tox
     * @param toy
     * @return
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
