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
 * Class which can read a crossword from file
 *
 * @author Krzysztof Gądek
 */
public class CwReader{
    private String dir;
    
    /**
     * Constructor that sets the path to directory where crosswords will be loaded from
     *
     * @param dir path to directory where crossword will be loaded from
     */
    public CwReader(String dir){
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
     * Reads all the crosswords from the directory given in the <code>dir</code> variable
     * and saves them to LinkedList
     *
     * @see Crossword
     * @return list of readen crosswords
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
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
    
    
    /**
     * Reads the crossword with given id from directory <code>dir</code> 
     *
     * @see Crossword
     * @param id unique id of the crossword to read
     * @return readen crossword
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Crossword getCw(long id) throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File(dir + File.separator + id + ".cw");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Crossword cw = (Crossword) in.readObject();
        return cw;
    }
    
    /**
     * Reads the crossword with given file name from directory <code>dir</code> 
     *
     * @see Crossword
     * @param file name of the file to read the crossword from
     * @return readen crossword
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Crossword getCw(String file) throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File(file);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Crossword cw = (Crossword) in.readObject();
        return cw;
    }
}
