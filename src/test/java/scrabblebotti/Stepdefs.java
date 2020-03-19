package scrabblebotti;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

public class Stepdefs {
    Dictionary dictionary;
    WordLoader wordLoader;
    List l;
    
    // adding_word.feature
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
    
    // word_loading.feature
    @Given("word loader is initialized")
    public void wordLoaderIsInitialized() throws FileNotFoundException {
        wordLoader = new WordLoader();
    }

    @When("user opens file")
    public void userOpensFile() throws FileNotFoundException {
        wordLoader.openFile();
    }

    @Then("there should be no exception")
    public void thereShouldBeNoException() {
    }

    @When("file user reads file")
    public void fileUserReadsFile() throws IOException {
        l = wordLoader.readFile();
    }

    @Then("something should be returned")
    public void somethingShouldBeReturned() {
        boolean b = l.isEmpty();
        assertEquals(b, false);
    }
    
    @When("user closes the word loader")
    public void userClosesTheWordLoader() throws IOException {
        wordLoader.closeFile();
    }
}