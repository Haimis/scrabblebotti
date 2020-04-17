
package main;

import scrabblebotti.controller.WordLoader;
import scrabblebotti.model.Letter;
import scrabblebotti.model.PointTable;
import scrabblebotti.view.CLI;
import java.io.IOException;
import java.util.Scanner;
import scrabblebotti.controller.Logic;

public class Main {

    public static void main(String[] args) throws IOException {
        Logic logic = new Logic(new CLI(), new WordLoader());
        logic.build();
        logic.start();
    }
}