/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin;

import ada.kaannin.englanti.*;
import ada.kaannin.kayttoliittyma.Kayttoliittyma;
import ada.kaannin.kayttoliittyma.Teksti;
import ada.kaannin.suomi.*;
import java.io.FileNotFoundException;

/**
 *
 * Pääohjelmaluokka
 * 
 * @author adahyvarinen
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Kayttoliittyma kl = new Kayttoliittyma();
        kl.run();
        
    }
}
