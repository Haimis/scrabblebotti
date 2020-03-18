package scrabblebotti;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class Stepdefs {
    Dictionary dictionary;
    
    
    @Given("dictionary is initialized")
    public void dictionaryIsInitialized() {
        dictionary = new Dictionary();
    }


    @When("new word {string} is added")
    public void newWordIsAdded(String newWord) {
        dictionary.addWord(newWord);
    }
    
    @Then("there should be  {int} words in dictionary")
    public void thereShouldBeWordsInDictionary(Integer wordCount) {
        assertEquals(wordCount.intValue(), dictionary.getSanat().size());
    }
    
    @Then("{string} should be the first word in dictionary")
    public void shouldBeTheFirstWordInDictionary(String word) {
        assertEquals(word, dictionary.getSanat().get(0));
    }

}