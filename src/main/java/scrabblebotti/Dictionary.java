/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabblebotti;

import java.util.*;

/**
 *
 * @author mikkohai
 */
public class Dictionary {
    private ArrayList<String> sanat;

    public Dictionary() {
        this.sanat = new ArrayList<>();
    }
    
    public void addWord(String s) {
        sanat.add(s);
    }
    

    public ArrayList<String> getSanat() {
        return sanat;
    }
    
    
    
}
