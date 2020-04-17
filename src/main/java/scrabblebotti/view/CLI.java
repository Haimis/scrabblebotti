
package scrabblebotti.view;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Abstract Class <code>CLI</code> handles communication with user.
 * 
 * 
 * 
 */
public class CLI {
    Scanner scanner;

    public CLI() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Receives path to word list source file as user input.
     * @param defaultWordList default path to source file which will be used if no user input.
     * @return user input.
     */
    public String getWordListPath(String defaultWordList) {
        System.out.println("Oletussanalista \"" + defaultWordList + "\" sijaitsee projektin\n"
                + "juuressa. Mikäli haluat käyttää oletussanalistaa paina Enter.\n"
                + "Mikäli haluat käyttää omaa sanalistaa, syötä polku sanalistaan.");
        return scanner.nextLine();
    }

    /**
     * Receives path to point table source file as user input.
     * @param defaultPointTable default path to source file which will be used if no user input.
     * @return user input.
     */
    public String getPointTablePath(String defaultPointTable) {
        System.out.println("Oletuspistetaulu \"" + defaultPointTable + "\" sijaitsee projektin\n"
                + "juuressa. Mikäli haluat käyttää oletuspistetaulua paina Enter.\n"
                + "Mikäli haluat käyttää omaa pistetaulua, syötä polku pistetauluun.");
        return scanner.nextLine();
    }

    /**
     * Pints the opening view for the software.
     */    
    public void printHelloMessage() {
        System.out.println("///////////////////////////////////////////\n"
                + "// Tervetuloa käyttämään scrabblebottia! //\n"
                + "///////////////////////////////////////////\n"
                + "\n"
                + "Ohjelma hakee kirjaimiisi sopivat sanat.\n"
                + "Voit valita itse käyttämäsi sanalistan \n"
                + "ja kirjainpisteytykset.\n");
    }

    /**
     * Handles error messages.  
     * @param e error message.
     */
    public void printErrorMessage(FileNotFoundException e) {
        System.out.println("This feature is under construction");
    }

    /**
     * Receives letters that are used to form words.
     * @return user input.
     */
    public String getTiles() {
        System.out.println("Syötä kirjaimet, jotka sinulla on käytössä\n"
                + "muodossa \"jdasiks\". Järjestyksellä ei ole väliä.\n"
                + "Voit sulkea ohjelman painamalla Enter");
        return scanner.nextLine();
    }
}
