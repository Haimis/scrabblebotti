
package main;

import java.io.IOException;
import java.util.List;
import scrabblebotti.WordLoader;
import scrabblebotti.*;

public class Main {

    public static void main(String[] args) throws IOException {
        WordLoader w = new WordLoader();
        w.openFile();
        List<String> l = w.readFile();
        w.closeFile();
        Dictionary d = new Dictionary();
        d.addWord("koira");
        int i = d.getSanat().size();
        System.out.println("sanoja: " + i);
    }
    
}
