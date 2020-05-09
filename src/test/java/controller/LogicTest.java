package controller;

import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import scrabblebotti.controller.Logic;
import scrabblebotti.controller.WordLoader;
import scrabblebotti.model.DataStructure;
import scrabblebotti.model.Letter;
import scrabblebotti.model.PointTable;
import scrabblebotti.view.CLI;

public class LogicTest {
    CLI cli;
    WordLoader wl;
    Letter l;
    PointTable pt;
    
    @Before
    public void init() throws IOException {
        cli = mock(CLI.class);
        wl = mock(WordLoader.class);
        l = mock(Letter.class);
        pt = mock(PointTable.class);
        doNothing().when(cli).printHelloMessage();
        doNothing().when(l).build(cli, "sanalista2.txt", wl);
        doNothing().when(pt).build(cli, "sanapisteet.csv", wl);
        when(cli.getTiles()).thenReturn("jeejee");
    }
    
    @Test
    public void constructorCreatesLetterAndPointTable() {
        Logic logic = new Logic(cli, wl);
        boolean b = true;
        for (Letter letter : logic.l.getNext()) {
            if (letter != null) {
                b = false;
            }
        }
        boolean c = true;
        for (int points : logic.pt.points) {
            if (points != 0) {
                b = false;
            }
        }
        assertTrue(b);
        assertTrue(c);
    }
    
    @Test
    public void buildCallsCorrectMethods() throws IOException {
        Logic logic = new Logic(cli, wl);
        logic.l = l;
        logic.pt = pt;
        logic.build();
        verify(cli, times(1)).printHelloMessage();
        verify(logic.l, times(1)).build(cli, "sanalista2.txt", wl);
        verify(logic.pt, times(1)).build(cli, "sanapisteet.csv", wl);
    }
}
