
package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import scrabblebotti.controller.WordLoader;
import scrabblebotti.model.Letter;
import scrabblebotti.model.PointTable;
import scrabblebotti.view.CLI;


public class WordLoaderTest {
    
    @Test
    public void openFileWorksWithCorrectInput() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("sanalista.txt"));  
        assertTrue(br.ready());
    }
    
    @Test
    public void openFileFailsWithIncorrectInput() {
        String str = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("sanat.txt"));  
        } catch (FileNotFoundException ex) {
            str = ex.getMessage();
        }
        assertEquals("sanat.txt (No such file or directory)", str);
    }
    
    @Test
    public void readWordListWorks() throws IOException {
        WordLoader wl = new WordLoader();
        
        wl.openFile("sanalista.txt");
        Letter l = new Letter("", false);
        wl.readWordList(l);
        boolean b = false;
        for (Letter letter : l.next) {
            if (letter != null) {
                b = true;
            }
        }
        assertEquals(true, b);
    }
    
    @Test
    public void readPointTableWorks() throws IOException {
        WordLoader wl = new WordLoader();
        
        wl.openFile("sanapisteet.csv");
        PointTable pt = new PointTable();
        wl.readPointList(pt);
        boolean b = false;
        for (int points : pt.points) {
            if (points != 0) {
                b = true;
            }
        }
        assertEquals(true, b);
    }
    
    @Test
    public void splitsWords() {
        WordLoader wl = new WordLoader();
        Letter l = new Letter("", false);
        wl.splitWord("aab", l);
        assertEquals("a", l.next[97].getLetter());
        assertEquals("a", l.next[97].next[97].getLetter());
        assertEquals("b", l.next[97].next[97].next[98].getLetter());
        assertTrue(l.next[97].next[97].next[98].isLast());
    }
}
