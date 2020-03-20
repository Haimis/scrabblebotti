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
    public void openFile() throws FileNotFoundException {
        br = new BufferedReader(new FileReader("sanalista.txt"));  
    }
    
    /**
     * Reads the designated source file, adds every word from it to a list object.
     * @return return List with words written from source file.
     * @throws IOException 
     */
    public List<String> readFile() throws IOException {
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;


    }
    
    /**
     * Closes the BufferedReader.
     * @throws IOException 
     */
    public void closeFile() throws IOException {
        br.close();
    }

}
