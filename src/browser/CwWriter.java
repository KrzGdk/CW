package browser;

import cw.Crossword;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;

/**
 * Class which save the crossword to directory given in constructor,
 * the name of the crossword is the current time in miliseconds with .cw extension.
 *
 * @author Krzysztof Gądek
 */
public class CwWriter implements Writer{
    private String dir;
    
    
    /**
     * Constructor that sets the path to directory where crossword will be written
     *
     * @param dir path to directory where crossword will be written
     */
    public CwWriter(String dir){
        this.dir = dir;
    }

    /**
     * Gets the current directory
     * 
     * @return the dir
     */
    public String getDir(){
        return dir;
    }

    /**
     * Sets the directory
     * 
     * @param dir the path to set working directory
     */
    public void setDir(String dir){
        this.dir = dir;
    }
    
    /**
     * Private method that gets the unique ID of the crossword.
     * ID is represented as current time in miliseconds.
     */
    private long getUniqueID(){
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }
    /**
     * Writes the crossword to file in the directory <code>dir</code>,
     * the name of the file is the crossword's unique id with the extension .cw
     *
     * @see Crossword
     * @param cw crossword to be saved
     */
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
