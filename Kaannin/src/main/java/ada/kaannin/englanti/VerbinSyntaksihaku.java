/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.Aikamuoto;
import ada.kaannin.suomi.Modus;
import ada.kaannin.suomi.Persoona;

/**
 *
 * Luokka tutkii verbien syntaksia
 * 
 * @author adahyvarinen
 */
public class VerbinSyntaksihaku {
    
    private SyntaksiSanakirja ss;
    
    public VerbinSyntaksihaku(SyntaksiSanakirja ss, String lauseke) {
        this.ss = ss;
    }
    
    public Modus modus() {
        return Modus.IMPERATIIVI;
    }
    
    public Aikamuoto aikamuoto() {
        return Aikamuoto.PREESENS;
    }
    
     public Persoona persoona() {
         return Persoona.YKS2;
     }
    
    
}
