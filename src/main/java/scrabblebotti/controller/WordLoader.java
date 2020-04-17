package scrabblebotti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class <code>WordLoader</code> allows user to read file with word list.
 * 
 * 
 * 
 */
public class WordLoader {
    BufferedReader br;
    
    /**
     * Creates a new BufferedReader with a new FileReader with.
     *  automatically designated source file.
     * @throws FileNotFoundException 
     */
    public void openFile(String filename) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(filename));  
    }
    
    /**
     * Reads the designated source file, adds every word from it to a list object.
     * @return return List with words written from source file.
     * @throws IOException 
     */
    public Letter readWordList() throws IOException {
        Letter l = new Letter("", false);
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.contains("-") && !line.contains("å") && !line.contains("š") && !line.contains("ž") && !line.contains("û") && line.length() < 8) {
                splitWord(line, l);
            }
            
        }
        return l;


    }
    
    /**
     * Closes the BufferedReader.
     * @throws IOException 
     */
    public void closeFile() throws IOException {
        br.close();
    }
    
    public void splitWord(String word, Letter l) {
        if (word.length() == 1) {
            // last letter in word
            if (l.next[word.hashCode()] == null) {
                l.next[word.hashCode()] = new Letter (word, true);
            } else {
                l.next[word.hashCode()].last = true;
            }
        } else {
            if (l.next[word.substring(0, 1).hashCode()] == null) {
                Letter nl = new Letter (word.substring(0, 1), false);
                l.next[word.substring(0, 1).hashCode()] = nl;
                splitWord(word.substring(1, word.length()), nl);
            } else {
                splitWord(word.substring(1, word.length()), l.next[word.substring(0, 1).hashCode()]);
            }
        }
    }
    
}
