/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabblebotti.view;

import java.util.Scanner;

/**
 *
 * @author mikkohai
 */
public class CLI_IO implements IO {
    private Scanner lukija;

    public CLI_IO() {
        lukija = new Scanner(System.in);
    }
    
    public String nextString() {
            return lukija.nextLine();
    }


    public void print(String s) {
            System.out.println(s);

    }   
}
