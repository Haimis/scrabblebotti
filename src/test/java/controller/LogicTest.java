package controller;

import java.io.IOException;
import static org.junit.Assert.assertEquals;
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
    Logic logic;
    String defaultWordList;
    String defaultPointTable;
    DataStructure ds;
    
    @Before
    public void init() {
        cli = mock(CLI.class);
        wl = mock(WordLoader.class);
        l = mock(Letter.class);
        pt = mock(PointTable.class);
        logic = new Logic(cli, wl);
        defaultWordList = "sanalista2.txt";
        defaultPointTable = "sanapisteet.csv";

        
        
        when(cli.getPointTablePath(defaultPointTable))
            .thenReturn("");

        when(cli.getWordListPath(defaultWordList))
            .thenReturn("");
        
        when(cli.getTiles())
            .thenReturn("jeejee")
            .thenReturn("");

    }
    
    @Test
    public void buildCallsAllMethdos() throws IOException {
        logic.build();
        verify(cli, times(1)).printHelloMessage();
        // TÄSSÄ PITÄISI TESTATA MYÖS, ETTÄ TIETORAKENTEIDEN BUILDEJA KUTSUTAAN!
    }
    
    @Test
    public void startCallsCorrectMethod() {
        logic.start();
        verify(cli, times(2)).getTiles();
    }
}
