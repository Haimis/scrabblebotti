
package scrabblebotti.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import scrabblebotti.model.*;
import scrabblebotti.view.CLI;

/**
 * Class <code>Logic</code> orchestrates the whole application.
 * 
 * 
 * 
 */
public class Logic {
    CLI cli;
    WordLoader wl;
    Letter l;
    PointTable pt;

    public Logic(CLI cli, WordLoader wl) {
        this.cli = cli;
        this.wl = wl;
        this.l = new Letter(null, false);
        this.pt = new PointTable();
    }

    /**
    * Calls methods to initialize data structures needed to use application.
    * @throws FileNotFoundException
    * @throws IOException 
    */    
    public void build() throws FileNotFoundException, IOException {
        cli.printHelloMessage();
        
        // konffaa sanalista ja rakenna sanapuu
        String defaultWordList = "sanalista2.txt";
        l.build(cli, defaultWordList, wl);
        
        //konffaa pistetaulu ja rakenna pistetaulu
        String defaultPointTable = "sanapisteet.csv";
        pt.build(cli, defaultPointTable, wl);
        
    }

    /**
    * Uses UI to acquire user input and calls method with that input to find matching words.
    */        
    public void start() {
        while (true) {
            String tiles = cli.getTiles();
            if (tiles.isEmpty()) {
                cli.printErrorMessage(null);
                break;
            }
            formWords(tiles);
            
        }
    }

    /**
    * Receives user input and finds appropriate beginning letter for words.
    * @param tiles user input.
    */      
    public void formWords(String tiles) {
        String searchHand = "";
        for (Letter a : l.getNext()) {
            if (a != null && tiles.contains(a.getLetter())) {
                for (int i = 0; i < tiles.length(); i++) {
                    if (tiles.substring(i, i+1).equals(a.getLetter())) {
                        searchHand = tiles.substring(0, i)+tiles.substring(i+1, tiles.length());
                        break;
                    }
                }
                rekursio("", a, searchHand, 0);
            }
        }
    }

    /**
    * Recursively searches via all possible words that can be formed with user input.
    * @param s Body of the word under construction.
    * @param l Letter entity which is being processed.
    * @param hand Available letters which are left from user input.
    * @param points Cumulative points for the word under construction.
    */      
    public void rekursio(String s, Letter l, String hand, int points) {
        points+=pt.getPoints(l.getLetter());
        if (l.isLast()) {
            System.out.println(points + ", " + s+l.getLetter());

        }
        if (!hand.isEmpty()) {
            for (Letter a : l.getNext()) {
                if (a != null && hand.contains(a.getLetter())) {
                    String subHand = "";
                    for (int i = 0; i < hand.length(); i++) {
                        if (hand.substring(i, i+1).equals(a.getLetter())) {
                            subHand = hand.substring(0, i)+hand.substring(i+1, hand.length());
                            break;
                        }
                    }
                    rekursio(s+l.getLetter(), a, subHand, points);
                }
            }    
        }
        
    }
    
}
