/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import scrabblebotti.WordLoader;
import scrabblebotti.*;

/**
 *
 * @author mikkohai
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        WordLoader w = new WordLoader();
        w.openFile();
        w.readFile();
        w.closeFile();
        Dictionary d = new Dictionary();
        d.addWord("koira");
        int l = d.getSanat().size();
        System.out.println("sanoja: " + l);
    }
    
}
