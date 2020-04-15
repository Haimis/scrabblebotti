
package main;

import java.io.IOException;
import java.util.Scanner;
import scrabblebotti.*;

public class Main {

    public static void main(String[] args) throws IOException {
        WordLoader wl = new WordLoader();
        wl.openFile("sanalista2.txt");
        Letter l = wl.readWordList();
        wl.closeFile();
        CLI cli = new CLI(wl, l);
        cli.run();
    }
}