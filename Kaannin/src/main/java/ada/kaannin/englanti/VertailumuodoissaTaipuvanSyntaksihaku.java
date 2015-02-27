/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.Vertailumuoto;

/**
 *
 * Luokka tutkii vertailumuodoissa taipuvien sanojen syntaksia
 * 
 * @author adahyvarinen
 */
public class VertailumuodoissaTaipuvanSyntaksihaku {
    
    private SyntaksiSanakirja ss;
    
    public VertailumuodoissaTaipuvanSyntaksihaku(SyntaksiSanakirja ss, String lauseke) {
        this.ss = ss;
    }
    
    /**
     * Metodi tutkii adjektiivilausekkeen vertailumuotoa
     * 
     * @return 
     */
    
    public Vertailumuoto vertailumuoto() {
        return Vertailumuoto.POSITIIVI;
    }
}
