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
import scrabblebotti.view.CLI;

public class LetterTest {
    WordLoader wl;
    CLI cli;
    
    @Before
    public void init() throws IOException {
        wl = mock(WordLoader.class);
        cli = mock(CLI.class);
        
        when(cli.getWordListPath("foo"))
            .thenReturn("foo");
        
        
    }
    
    @Test
    public void constructorWorksAndCreatesEmptyTable() {
        Letter l = new Letter("a", true);
        assertEquals("a", l.letter);
        assertEquals(true, l.last);
        boolean b = false;
        for (Letter letter : l.next) {
            if (letter != null) {
                b = true;
            }
        }
        assertEquals(false, b);
    }
    
    @Test
    public void readerWorks() throws IOException {
        Letter l = new Letter("a", true);
        l.read(wl);
        verify(wl, times(1)).readWordList(l);
    }
    
    @Test
    public void getPathWorks() {
        Letter l = new Letter("a", true);
        String defaultPath = "foo";
        String str = l.getPath(cli, defaultPath);
        assertEquals("foo", str);
    }
}
