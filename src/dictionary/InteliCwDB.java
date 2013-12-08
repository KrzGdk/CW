package dictionary;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

/**
 * Improved class for representing database of entries with methods to get the random words etc.
 *
 * @author Krzysztof Gądek
 */
public class InteliCwDB extends CwDB{
    /**
     * {@inheritDoc}
     * 
     * @param {@inheritDoc}
     * @throws IOException
     */
    public InteliCwDB(String filename) throws IOException{
        super(filename);
    }
    /**
     * Finds all the entries which matches the given regular expression pattern
     *
     * @see Entry
     * @param pattern regular expression for matching words
     * @return LinkedList of found entries
     */
    public LinkedList<Entry> findAll(String pattern){
        LinkedList<Entry> result = new LinkedList<>();
        for(Entry i : db){
            if(i.getWord().matches(pattern)){
                result.add(i);
            }
        }
        return result; 
    }
    /**
     * Gets the completely random word
     *
     * @see Entry
     * @return random entry
     */
    public Entry getRandom(){
        Random gen = new Random();
        return db.get(gen.nextInt(db.size()));
    }
    /**
     * Gets the random word of given length
     *
     * @see Entry
     * @param length length of the word
     * @return random entry
     */
    public Entry getRandom(int length){
        Random gen = new Random();
        LinkedList<Entry> matching = findAll(".{" + length + "}");
        return matching.get(gen.nextInt(matching.size()));
    }
    /**
     * Gets the random word which matches the given regular expression pattern
     *
     * @see Entry
     * @param pattern regular expression for matching the word
     * @return random entry
     */
    public Entry getRandom(String pattern){
        Random gen = new Random();
        LinkedList<Entry> matching = findAll(pattern);
        return matching.get(gen.nextInt(matching.size()));
    }
    
    /**
     * Adds entry to the end of the database in alphabetical order
     *
     * @see Entry
     * @param word word to be added
     * @param clue clue for the word
     */
    @Override
    public void add(String word, String clue){
        int i;
        for(i = 0;i<db.size();i++){
            if(word.toUpperCase().compareTo(db.get(i).getWord()) < 0) break;
        }
        db.add(i, new Entry(word,clue));
    }
}
