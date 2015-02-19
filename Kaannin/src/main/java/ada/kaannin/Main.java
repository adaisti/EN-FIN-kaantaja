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

/**
 *
 * @author adahyvarinen
 */
public class Main {
    public static void main(String[] args) {
        
        Teksti teksti = new Teksti("Turn work, create 24 sts, turn work again");
        teksti.jaaLauseiksi();
        System.out.println(teksti.lauseet());
//
//        System.out.println(teksti.kaanna());
        
//        Kayttoliittyma kl = new Kayttoliittyma();
//        kl.run();
        
        Sanakirja s = new Sanakirja();
        SyntaksiSanakirja ss = new SyntaksiSanakirja();
//        
        Lause lause = new Lause(ss, s, " create 24 sts");    
        lause.kaanna();
        System.out.println(lause);
        
    }
}
