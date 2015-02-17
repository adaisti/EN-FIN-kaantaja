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
        
    }
    
    public Sanakirja s() {
        return this.s;
    }
    
    public SyntaksiSanakirja ss() {
        return this.ss;
    }
        
    // tämä Hakemistonhallintaan
//    public void lisaaPrepositio(String englanti, Sijamuoto sijamuoto) {
//        this.prepositiot.put(englanti, sijamuoto);
//    }
}
