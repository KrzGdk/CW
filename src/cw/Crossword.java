/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cw;
import dictionary.*;
import java.io.*;

/**
 *
 * @author Krzysiek
 */
public class Crossword{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        CwDB db = new CwDB("C:\\Users\\Krzysztof\\Documents\\NetBeansProjects\\CW\\src\\cwdb.txt");
        Entry e = db.get("babiarz");
        System.out.println(e.getClue());
    }
}
