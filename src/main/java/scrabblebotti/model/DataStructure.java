
package scrabblebotti.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import scrabblebotti.controller.WordLoader;
import scrabblebotti.view.CLI;

/**
 * Abstract Class <code>DataStructure</code> host common methods for different data structures.
 * 
 * 
 * 
 */
public abstract class DataStructure {
    
    /**
     * Orchestrates methods to build data structure from user designated source file. 
     * @param cli Command line interface to communicate with user
     * @param defaultPath default path to source file which will be used if no user input.
     * @param wl WordLoader that will handle data read from source file.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void build(CLI cli, String defaultPath, WordLoader wl) throws FileNotFoundException, IOException {
        
        String path = getPath(cli, defaultPath);
        if (path.isEmpty()) {
          wl.openFile(defaultPath);  
        } else {
            wl.openFile(path);
        }
        
        read(wl);
        
        wl.closeFile();
    }
    
    /**
     * Abstract method, @see Letter and PointTable classes. 
     * @param cli Command line interface to communicate with user
     * @param defaultPath default path to source file which will be used if no user input.
     * @return returns defaultPath or path received from user.
     */
    public abstract String getPath(CLI cli, String defaultPath);

    /**
     * Abstract method, @see Letter and PointTable classes. 
     * @param wl WordLoader that will handle data read from source file.
     */    
    public abstract void read(WordLoader wl);
}
