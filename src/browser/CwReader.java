/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package browser;

import cw.Crossword;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

/**
 *
 * @author Krzysiek
 */
public class CwReader{
    private String dir;
    
    public CwReader(String dir){
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
        this.dir = dir;
    }
    
    public LinkedList<Crossword> getAllCws() throws FileNotFoundException, IOException, ClassNotFoundException{
        LinkedList<Crossword> cws = new LinkedList<>();
        FilenameFilter cwNameFilter = new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                    return name.endsWith(".cw");
                }
            };
        File directory = new File(dir);
        
        File[] files = directory.listFiles(cwNameFilter);
        
        for(File f : files){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            Crossword cw = (Crossword) in.readObject();
            cws.add(cw);
        }
        return cws;
    }
    
    public Crossword getCw(long id) throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File(dir + File.separator + id + ".cw");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Crossword cw = (Crossword) in.readObject();
        return cw;
    }
    public Crossword getCw(String file) throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File(file);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Crossword cw = (Crossword) in.readObject();
        return cw;
    }
}
