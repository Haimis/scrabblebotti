
package main;

import scrabblebotti.controller.WordLoader;
import java.io.IOException;
import scrabblebotti.controller.Logic;
import scrabblebotti.view.CLI;
import scrabblebotti.view.CLI_IO;

public class Main {

    public static void main(String[] args) throws IOException {
        Logic logic = new Logic(new CLI(new CLI_IO()), new WordLoader());
        logic.build();
        logic.start();
    }
}