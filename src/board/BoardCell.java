/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Krzysiek
 */
public class BoardCell implements Serializable{
    public Boolean[][] can = new Boolean[2][3]; // HORIZ/VERT x Start/End/Inner
    private String content;
    public BoardCell(){
        for(Boolean[] b : can)
            Arrays.fill(b, false);
        content = null;
    }
    public BoardCell(String con){
        for(Boolean[] b : can)
            Arrays.fill(b, false);
        content = con;
    }
    
    public boolean canStart(){
        return can[0][0] || can[0][1];
    }
    public void disableHorizStart(){
        this.can[0][0] = false;
    }
    public void disableHorizEnd(){
        this.can[0][1] = false;
    }
    public void disableHorizInner(){
        this.can[0][2] = false;
    }
    public void enableHorizStart(){
        this.can[0][0] = true;
    }
    public void enableHorizEnd(){
        this.can[0][1] = true;
    }
    public void enableHorizInner(){
        this.can[0][2] = true;
    }
    
    public void disableVertStart(){
        this.can[1][0] = false;
    }
    public void disableVertEnd(){
        this.can[1][1] = false;
    }
    public void disableVertInner(){
        this.can[1][2] = false;
    }
    public void enableVertStart(){
        this.can[1][0] = true;
    }
    public void enableVertEnd(){
        this.can[1][1] = true;
    }
    public void enableVertInner(){
        this.can[1][2] = true;
    }
            
    
    public static void main(String[] args){
        BoardCell b = new BoardCell();
        for(Boolean[] i : b.can)
            for(Boolean j : i)
                System.out.println(j);
    }

    /**
     * @return the content
     */
    public String getContent(){
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content){
        this.content = content;
    }
}
