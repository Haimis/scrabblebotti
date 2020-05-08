
package scrabblebotti.view;

import java.io.FileNotFoundException;

/**
 * Abstract Class <code>CLI</code> handles communication with user.
 * 
 * 
 * 
 */
public class CLI {
    private IO io;

    public CLI(IO io) {
        this.io = io;
    }

    /**
     * Receives path to word list source file as user input.
     * @param defaultWordList default path to source file which will be used if no user input.
     * @return user input.
     */
    public String getWordListPath(String defaultWordList) {
        io.print("Oletussanalista \"" + defaultWordList + "\" sijaitsee projektin\n"
                + "juuressa. Mikäli haluat käyttää oletussanalistaa paina Enter.\n"
                + "Mikäli haluat käyttää omaa sanalistaa, syötä polku sanalistaan.");
        return io.nextString();
    }

    /**
     * Receives path to point table source file as user input.
     * @param defaultPointTable default path to source file which will be used if no user input.
     * @return user input.
     */
    public String getPointTablePath(String defaultPointTable) {
        io.print("Oletuspistetaulu \"" + defaultPointTable + "\" sijaitsee projektin\n"
                + "juuressa. Mikäli haluat käyttää oletuspistetaulua paina Enter.\n"
                + "Mikäli haluat käyttää omaa pistetaulua, syötä polku pistetauluun.");
        return io.nextString();
    }

    /**
     * Pints the opening view for the software.
     */    
    public void printHelloMessage() {
        io.print("///////////////////////////////////////////\n"
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
        io.print("This feature is under construction");
    }

    /**
     * Receives letters that are used to form words.
     * @return user input.
     */
    public String getTiles() {
        io.print("Syötä kirjaimet, jotka sinulla on käytössä\n"
                + "muodossa \"jdasiks\". Järjestyksellä ei ole väliä.\n"
                + "Voit sulkea ohjelman painamalla Enter");
        return io.nextString();
    }
}
