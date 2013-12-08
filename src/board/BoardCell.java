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
    /**
     * Double dimensional array showing if the cell can start/end or be the part
     * of horizontal/vertical word in the board
     */
    public Boolean[][] can = new Boolean[2][3]; // HORIZ/VERT x Start/End/Inner
    private String content;
    /**
     * Constructtor that sets all the values in <code>can</code> to <code>false</code>
     * and content to <code>null</code>
     */
    public BoardCell(){
        for(Boolean[] b : can)
            Arrays.fill(b, false);
        content = null;
    }
    /**
     * Constructtor that sets all the values in <code>can</code> to <code>false</code>
     * and content to <code>con</code>
     * 
     * @param con content to be set
     */
    public BoardCell(String con){
        for(Boolean[] b : can)
            Arrays.fill(b, false);
        content = con;
    }
    
    /**
     * Returns if the cell can start the word
     *
     * @return <code>true</code> if the cell can start the word, <code>false</code> otherwise
     */
    public boolean canStart(){
        return can[0][0] || can[0][1];
    }
    /**
     * Sets that the cell cannot start a horizontal word
     */
    public void disableHorizStart(){
        this.can[0][0] = false;
    }
    /**
     * Sets that the cell cannot end a horizontal word
     */
    public void disableHorizEnd(){
        this.can[0][1] = false;
    }
    /**
     * Sets that the cell cannot be the part of a horizontal word
     */
    public void disableHorizInner(){
        this.can[0][2] = false;
    }
    /**
     * Sets that the cell can start a horizontal word
     */
    public void enableHorizStart(){
        this.can[0][0] = true;
    }
    /**
     * Sets that the cell can end a horizontal word
     */
    public void enableHorizEnd(){
        this.can[0][1] = true;
    }
    /**
     * Sets that the cell can be the part of a horizontal word
     */
    public void enableHorizInner(){
        this.can[0][2] = true;
    }
    /**
     * Sets that the cell cannot start a vertical word
     */
    public void disableVertStart(){
        this.can[1][0] = false;
    }
    /**
     * Sets that the cell cannot end a vertical word
     */
    public void disableVertEnd(){
        this.can[1][1] = false;
    }
    /**
     * Sets that the cell cannot be the part of a vertical word
     */
    public void disableVertInner(){
        this.can[1][2] = false;
    }
    /**
     * Sets that the cell can start a vertical word
     */
    public void enableVertStart(){
        this.can[1][0] = true;
    }
    /**
     * Sets that the cell can end a vertical word
     */
    public void enableVertEnd(){
        this.can[1][1] = true;
    }
    /**
     * Sets that the cell can be part of a vertical word
     */
    public void enableVertInner(){
        this.can[1][2] = true;
    }

    /**
     * Gets the content of the cell
     * 
     * @return the content
     */
    public String getContent(){
        return content;
    }

    /**
     * Sets the content of the cell
     * 
     * @param content the content to set
     */
    public void setContent(String content){
        this.content = content;
    }
}
