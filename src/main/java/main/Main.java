
package main;

import java.io.IOException;
import java.util.List;
import scrabblebotti.*;

public class Main {

    public static void main(String[] args) throws IOException {
        WordLoader w = new WordLoader();
        w.openFile();
        Letter l = w.readFile();
        w.closeFile();
        System.out.println(l.getNext()[97].getNext()[97].getNext()[116].getNext()[101].isLast());
        for (Letter a : l.getNext()) {
            if (a != null) {
                rekursio("", a);
            }
        }
    }
    
    
    public static void rekursio(String s, Letter l) {
        if (l.isLast()) {
            System.out.println(s+l.getLetter());
        } else {
            for (Letter a : l.getNext()) {
            if (a != null) {
                rekursio(s+l.getLetter(), a);
            }                
            }
        }
    }
}
