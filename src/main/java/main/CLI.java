
package main;

import java.util.Scanner;
import scrabblebotti.Letter;
import scrabblebotti.WordLoader;

public class CLI {
    WordLoader wl;
    Scanner scanner;
    Letter l;

    public CLI(WordLoader wl, Letter l) {
        this.wl = wl;
        this.scanner = new Scanner(System.in);
        this.l = l;
    }
    
    public void run() {
        System.out.println("Tervetuloa käyttämään scrabblebottia");
        while (true) {
            System.out.println("Syötä käytössäsi olevat kirjaimet");
            String letters = scanner.nextLine();
            if (letters.isEmpty()) {
                break;
            } else {
                String searchHand = "";
                for (Letter a : l.getNext()) {
                    if (a != null && letters.contains(a.getLetter())) {
                        for (int i = 0; i < letters.length(); i++) {
                            if (letters.substring(i, i+1).equals(a.getLetter())) {
                                searchHand = letters.substring(0, i)+letters.substring(i+1, letters.length());
                                break;
                            }
                        }
                        rekursio("", a, searchHand);
                    }
                }
            }
        }
    }
    
    public static void rekursio(String s, Letter l, String hand) {
        if (l.isLast()) {
            System.out.println(s+l.getLetter());

        }
        //if (!hand.isEmpty()) {
            for (Letter a : l.getNext()) {
                if (a != null && hand.contains(a.getLetter())) {
                    String subHand = "";
                    for (int i = 0; i < hand.length(); i++) {
                        if (hand.substring(i, i+1).equals(a.getLetter())) {
                            subHand = hand.substring(0, i)+hand.substring(i+1, hand.length());
                            break;
                        }
                    }
                    rekursio(s+l.getLetter(), a, subHand);
                }
            }    
        //}
        
    }
}
