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
        
        Sanakirja s = new Sanakirja();
        SyntaksiSanakirja ss = new SyntaksiSanakirja();
        ss.alustaKaikki();
        
        Lause lause = new Lause(ss, s, "create 42 sts on two needles");
        lause.jaaLausekkeiksi();
        System.out.println(lause.lausekkeet());
        
    }
}
