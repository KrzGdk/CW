/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package browser;

import cw.Crossword;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Krzysiek
 */
public class CwWriter implements Writer{
    private String dir;
    public CwWriter(String dir){
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
    private long getUniqueID(){
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }
    @Override
    public void write(Crossword cw){
        cw.setId(getUniqueID());
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dir + File.separator +cw.getId() + ".cw"))) {
            out.writeObject(cw);
        }
        catch(IOException e){
            e.printStackTrace(System.out);
        }
    }
    
}
