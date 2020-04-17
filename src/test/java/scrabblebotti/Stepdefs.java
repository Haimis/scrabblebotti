package scrabblebotti;

import scrabblebotti.controller.WordLoader;
import scrabblebotti.model.Letter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

public class Stepdefs {
    
    @Given("everything is initialized")
    public void everythingIsInitialized() {
        System.out.println("Perustetaan");
    }

    @When("file is read")
    public void fileIsRead() {
        System.out.println("Luetaan");
    }

    @Then("there should be no exception")
    public void thereShouldBeNoException() {
        System.out.println("Kaikki ok");
    }

}