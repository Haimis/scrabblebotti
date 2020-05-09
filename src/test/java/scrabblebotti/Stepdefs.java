package scrabblebotti;

import io.cucumber.java.Before;
import scrabblebotti.controller.WordLoader;
import scrabblebotti.model.Letter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import scrabblebotti.controller.Logic;
import scrabblebotti.view.CLI;
import scrabblebotti.view.CLI_IO;
import scrabblebotti.view.IO;

public class Stepdefs {
    WordLoader wl;
    IOStub io;
    long duration;
    
    
    @Before
    public void setUp() {
        wl = new WordLoader();
        long duration;
    }
    
    @When("letters {string} are entered")
    public void lettersAreEntered(String string) throws IOException {
        io = new IOStub("", "", string, "");
        Logic l = new Logic(new CLI(io), wl);
        l.build();
        long startTime = System.nanoTime();
        l.start();
        long endTime = System.nanoTime();
        duration = (endTime - startTime);
    }

    @Then("it should not take longer than {int} second to form words")
    public void itShouldNotTakeLongerThanSecondToFormWords(Integer int1) {
        boolean b = false;
        if (duration/1000000000 < int1) {
            b = true;
        }
        assertTrue(b);
    }
    
    @When("all alphabets are entered {int} times")
    public void allAlphabetsAreEnteredTimes(Integer int1) throws IOException {
        String string = "";
        for (int i = 0; i < int1; i++) {
            string = string + "abcdefghijklmnoprstuvwyäö";
        }
        io = new IOStub("", "", string, "");
        Logic l = new Logic(new CLI(io), wl);
        l.build();
        long startTime = System.nanoTime();
        l.start();
        long endTime = System.nanoTime();
        duration = (endTime - startTime);        
    }


}

class IOStub implements IO {

    String[] inputs;
    int mones;
    ArrayList<String> outputs;

    public IOStub(String... inputs) {
        this.inputs = inputs;
        this.outputs = new ArrayList<String>();
    }

    public String nextString() {
        return inputs[mones++];
    }

    public void print(String m) {
        outputs.add(m);
    }
}