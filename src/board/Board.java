/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import java.util.LinkedList;

/**
 *
 * @author Krzysiek
 */
public class Board{
    private BoardCell[][] board;
    private int width, height;
    public Board(int width, int height){
        this.width = width;
        this.height = height;
        board = new BoardCell[width][height];
    }
    public static void main(String[] args){
        Board b = new Board(5,5);
        b.setCell(2, 2, new BoardCell("a"));
        System.out.println(b.getCell(2, 3)); 
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
    
    public BoardCell getCell(int x, int y){
        return board[x][y];
    }
    public void setCell(int x, int y, BoardCell cell){
        board[x][y] = cell;
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
}
