/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package browser;

import cw.Crossword;
import cw.CwStrategy;
import cw.Strategy;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Krzysiek
 */
public class CwBrowser{
    private CwReader reader;
    private CwWriter writer;
    private String dir;
    
    public CwBrowser(String dir){
        this.reader = new CwReader(dir);
        this.writer = new CwWriter(dir);
        this.dir = dir;
    }

    /**
     * @return the dir
     */
    public String getDir(){
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(String dir){
        reader.setDir(dir);
        writer.setDir(dir);
        this.dir = dir;
    }
    
    public Crossword generate(int height, int width, String db){
        Strategy s = new CwStrategy();
        Crossword cw = new Crossword(height,width,db);
        cw.generate(s);
        return cw;
    }
    public void save(Crossword cw){
        writer.write(cw);
    }
    public Crossword load(long id) throws FileNotFoundException, IOException, ClassNotFoundException{
        return reader.getCw(id);
    }
    public Crossword load(String file) throws FileNotFoundException, IOException, ClassNotFoundException{
        return reader.getCw(file);
    }
    public LinkedList<Crossword> loadAll() throws FileNotFoundException, IOException, ClassNotFoundException{
        return reader.getAllCws();
    }
}
