package dictionary;

import java.util.LinkedList;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Class that represents the database of the entries
 *
 * @author Krzysztof Gądek
 */
public class CwDB implements Serializable{
    private static final long serialVersionUID = 3429466297L;
    protected LinkedList<Entry> db;
    
    /**
     * Constructor which creates the database form given file
     *
     * @param filename file to read the database from
     * @throws IOException
     */
    public CwDB(String filename) throws IOException{
        db = new LinkedList<>();
        createDB(filename);
    }
    /**
     * Adds entry to the end of the database
     *
     * @see Entry
     * @param word word to be added
     * @param clue clue for the word
     */
    public void add(String word, String clue){
        db.add(new Entry(word,clue));
    }
    /**
     * Returns the Entry object for given word
     *
     * @see Entry
     * @param word word to find
     * @return Entry object of given word, <code>null</code> if there is no entry for the word
     */
    public Entry get(String word){
        for(Entry e : db){
            if(word.toUpperCase().equals(e.getWord())) return e;
        }
        return null;
    }
    /**
     * Removes from the database the Entry for the given word
     *
     * @see Entry
     * @param word word of the entry to be deleted
     */
    public void remove(String word){
        db.remove(get(word));
    }
    /**
     * Serializes the database to a file
     *
     * @param filename name of the file to save the crossword
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void saveDB(String filename) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream  oos = new ObjectOutputStream(fos); 
        oos.writeObject(this);
    }
    
    /**
     * Retruns the size of the database
     *
     * @return size of the database
     */
    public int getSize(){
        return db.size();
    }
    /**
     * Method used in constructor to create a database
     *
     * @throws IOException
     * @param filename name of the file to read database from
     */
    private void createDB(String filename) throws IOException{
        BufferedReader reader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
        String word;
        String clue;
        while ((word = reader.readLine()) != null) {
            clue = reader.readLine();
            this.add(word,clue);
        }   
    }
}
