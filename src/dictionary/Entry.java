package dictionary;

import java.io.Serializable;

/**
 * Class representing an entry for the crossword: the pair of the word and clue
 *
 * @author Krzysztof Gądek
 */
public class Entry implements Comparable<Entry>, Serializable{
    private String word;
    private String clue;
    
    /**
     * Constructs the entry of given word and clue
     *
     * @param word word of the entry
     * @param clue clue for the word
     */
    public Entry(String word, String clue){
        this.word = word.toUpperCase();
        this.clue = clue;
    }
    /**
     * Gets the word of the entry
     *
     * @return word of the entry
     */
    public String getWord(){
        return this.word;
    }
    /**
     * Gets the clue of the entry
     *
     * @return clue of the entry
     */
    public String getClue(){
        return this.clue;
    }
    /**
     * Compares two entries according to word
     *
     * @return {@inheritDoc}
     */
    @Override
    public int compareTo(Entry other){
        return this.word.compareTo(other.getWord());
    }
}
