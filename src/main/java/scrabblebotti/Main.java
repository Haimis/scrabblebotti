/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabblebotti;

/**
 *
 * @author mikkohai
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        d.addWord("koira");
        int l = d.getSanat().size();
        System.out.println("sanoja: " + l);
    }
    
}
