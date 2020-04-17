package scrabblebotti.controller;

import scrabblebotti.model.Letter;
import scrabblebotti.model.PointTable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class <code>WordLoader</code> allows user to read file with word list.
 * 
 * 
 * 
 */
public class WordLoader {
    BufferedReader br;
    
    /**
     * Creates a new BufferedReader with a new FileReader.
     * @param filename 
     * @throws FileNotFoundException 
     */
    public void openFile(String filename) throws FileNotFoundException {
        try {
            br = new BufferedReader(new FileReader(filename));  
        } catch (FileNotFoundException e) {
            System.out.println("Epäkelpo tiedostonimi!\n"
                    + "Näkemiin!");
        }
        
    }
    
    /**
     * Reads the designated word list source file and calls method to split word to letter entities.
     * @param l single root node.
     * @return returns the root node for data structure with all read words.
     * @throws IOException 
     */
    public Letter readWordList(Letter l) throws IOException {
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains("-") && !line.contains("å") && !line.contains("š") && !line.contains("ž") && !line.contains("û") && line.length() < 8) {
                    splitWord(line, l);
                }

            }          
        } catch (IOException e) {
            System.out.println("Lukeminen epäonnistui!");
        }
        return l;  
    }

    /**
     * Reads the designated point table source file and initializes data structure for points.
     * @param pt empty point table entity.
     * @return returns PointTable entity with letter point information.
     * @throws IOException 
     */    
    public PointTable readPointList(PointTable pt) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                pt.setPointsForLetter(data[0], Integer.parseInt(data[2]));
                
            }
        return pt;            
    }
    
    /**
     * Closes the BufferedReader.
     * @throws IOException 
     */
    public void closeFile() throws IOException {
        br.close();
    }

    /**
     * Splits words to letters and links them together to form a tree structure. 
     * @param word a singe word or sub-word to be processed.
     * @param l Letter entity where the first letter from processed word should me linked.
     */    
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
