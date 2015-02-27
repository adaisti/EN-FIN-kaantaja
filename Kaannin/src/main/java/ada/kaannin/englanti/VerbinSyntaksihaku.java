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
    
    /**
     * Tutkitaan lausekkeen modusta
     * @return modus
     */
    
    public Modus modus() {
        return Modus.IMPERATIIVI;
    }
    
    /**
     * Tutkitaan lausekkeen aikamuotoa
     * 
     * @return aikamuoto
     */
    
    public Aikamuoto aikamuoto() {
        return Aikamuoto.PREESENS;
    }
    
    /**
     * Tutkitaan lausekkeen persoonaa
     * 
     * @return persoona
     */
    
    public Persoona persoona() {
        return Persoona.YKS2;
    }
    
    
}
