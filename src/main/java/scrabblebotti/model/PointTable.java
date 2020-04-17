
package scrabblebotti.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import scrabblebotti.controller.WordLoader;
import scrabblebotti.view.CLI;

/**
 * Class <code>PointTable</code> is the data structure where points for different letters are stored.
 * 
 * 
 * 
 */
public class PointTable extends DataStructure {
    int[] points;

    public PointTable() {
        this.points = new int[250];
    }
    
    public void setPointsForLetter(String letter, int point) {
        points[letter.hashCode()] = point;
    }
    
    public int getPoints(String letter) {
        return points[letter.hashCode()];
    }

    /**
     * Calls readPointList method to process point table source file to data structure. 
     * @param wl WordLoader that will handle data read from source file.
     */
    @Override
    public void read(WordLoader wl) {
        try {
            wl.readPointList(this);
        } catch (IOException ex) {
            Logger.getLogger(PointTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
    * Uses UI to receive path to point table source file.
    * @param cli Command line interface to communicate with user
    * @param defaultPath default path to source file which will be used if no user input.
    */
    @Override
    public String getPath(CLI cli, String defaultPath) {
        return cli.getPointTablePath(defaultPath);
    }
    
    
}
