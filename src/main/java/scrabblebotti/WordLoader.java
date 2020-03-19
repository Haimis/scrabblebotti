package scrabblebotti;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mikkohai
 */
public class WordLoader {
    BufferedReader br;
    
    public void openFile() {
        try {
            br = new BufferedReader(new FileReader("sanalista.txt"));
        } catch (IOException e) {
            System.out.println("nope");
        }
        
        
        
    }
    
    public void readFile() throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
    
    public void closeFile() throws IOException {
        br.close();
    }

}
