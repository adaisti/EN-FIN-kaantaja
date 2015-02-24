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
 * @author adahyvarinen
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
        
        Kayttoliittyma kl = new Kayttoliittyma();
        kl.run();
        
//        Verbi siirtaa = new Verbi("siirtää", Persoona.YKS2, Modus.IMPERATIIVI, Aikamuoto.PREESENS);
//        System.out.println(siirtaa.sananmuoto());
//        Teksti teksti = new Teksti("Then move sts on needles, turn work.");
//
//        System.out.println(teksti.kaanna());
//        teksti.jaaLauseiksi();
//        Lause move = teksti.lauseet().get(0);
//        move.jaaLausekkeiksi();
//        Lauseke move2 = move.lausekkeet().get(0);
//        move2.kaanna();
//        System.out.println(move2);
//       
//        Sanakirja s = new Sanakirja();
//        SyntaksiSanakirja ss = new SyntaksiSanakirja();
//        
//        Lause lause = new Lause(ss, s, " create 24 sts");   
//        System.out.println(lause);
//        lause.kaanna();
//        System.out.println(lause);
//        
//        Lauseke lauseke = new Lauseke("24 sts", s, ss);
//        lauseke.kaanna();
//        System.out.println(lauseke);
//        
//        Hakemistonhallinta h = new Hakemistonhallinta();
//        
//        System.out.println(h.s().haeKaannos("alternatively"));
//        
//        Lauseke lauseke = new Lauseke("alternatively", h.s(), h.ss());
//        System.out.println(lauseke);
//        lauseke.kaanna();
//        System.out.println(lauseke);
    }
}
