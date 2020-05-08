
package model;

import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import scrabblebotti.controller.WordLoader;
import scrabblebotti.model.Letter;
import scrabblebotti.model.PointTable;
import scrabblebotti.view.CLI;

public class PointTableTest {
    WordLoader wl;
    CLI cli;
    
    @Before
    public void init() throws IOException {
        wl = mock(WordLoader.class);
        cli = mock(CLI.class);
        
        when(cli.getPointTablePath("foo"))
            .thenReturn("foo");
        
        
    }
    
    @Test
    public void constructorWorksAndCreatesEmptyTable() {
        PointTable pt = new PointTable();
        boolean b = false;
        for (int points : pt.points) {
            if (points != 0) {
                b = true;
            }
        }
        assertEquals(false, b);
    }
    
    @Test
    public void readerWorks() throws IOException {
        PointTable pt = new PointTable();
        pt.read(wl);
        verify(wl, times(1)).readPointList(pt);
    }
    
    @Test
    public void getPathWorks() {
        PointTable pt = new PointTable();
        String defaultPath = "foo";
        String str = pt.getPath(cli, defaultPath);
        assertEquals("foo", str);
    }
}
