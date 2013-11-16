/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import java.util.Arrays;

/**
 *
 * @author Krzysiek
 */
public class BoardCell{
    public Boolean[][] can = new Boolean[2][3]; // HORIZ/VERT x Start/End/Inner
    public BoardCell(){
        for(Boolean[] b : can)
            Arrays.fill(b, false);
    }
    public static void main(String[] args){
        BoardCell b = new BoardCell();
        for(Boolean[] i : b.can)
            for(Boolean j : i)
                System.out.println(j);
    }
}
