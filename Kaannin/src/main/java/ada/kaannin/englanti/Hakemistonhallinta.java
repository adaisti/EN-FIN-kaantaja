/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

/**
 *
 * Luokan tarkoituksena on kontrolloida sanakirjoja ja muuta hakemistoa
 * 
 * @author adahyvarinen
 */
public class Hakemistonhallinta {
    
    Sanakirja s;
    SyntaksiSanakirja ss;
    
    public Hakemistonhallinta() {
        this.s = new Sanakirja();
        this.ss = new SyntaksiSanakirja();
        alustaSanakirjat();
    }
    
    
    public void alustaSanakirja() {
        // tee jotain
    }
    
    public void alustaSanakirjat() {
        ss.alustaKaikki();
        alustaSanakirja();
    }
    
    public Sanakirja s() {
        return this.s;
    }
    
    public SyntaksiSanakirja ss() {
        return this.ss;
    }
}
