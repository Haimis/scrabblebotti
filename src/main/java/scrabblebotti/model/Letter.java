
package scrabblebotti.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import scrabblebotti.controller.WordLoader;
import scrabblebotti.view.CLI;

/**
 * Class <code>Letter</code> is the data structure where dictionary is stored.
 * 
 * 
 * 
 */
public class Letter extends DataStructure {
    public String letter;
    public Letter[] next;
    public boolean last;

    public Letter(String letter, boolean last) {
        this.letter = letter;
        this.next = new Letter[250];
        this.last = last;
    }

    public String getLetter() {
        return letter;
    }

    public Letter[] getNext() {
        return next;
    }

    public boolean isLast() {
        return last;
    }    
    
    /**
     * Calls readWordList method to process word list source file to data structure. 
     * @param wl WordLoader that will handle data read from source file.
     */
    @Override
    public void read(WordLoader wl) {
        try {
            wl.readWordList(this);
        } catch (IOException ex) {
            Logger.getLogger(Letter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
    * Uses UI to receive path to word list source file.
    * @param cli Command line interface to communicate with user
    * @param defaultPath default path to source file which will be used if no user input.
    */
    @Override
    public String getPath(CLI cli, String defaultPath) {
        return cli.getWordListPath(defaultPath);
    }
    

}

