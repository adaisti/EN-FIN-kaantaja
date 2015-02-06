/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

/**
 *
 * @author adahyvarinen
 */
public class Lauseke {
    
    String lekseemi;
    String teksti;
    
    public Lauseke(String teksti) {
        this.teksti = teksti;
        this.lekseemi = "";
    }
    
    public String[] jaaSanoiksi() {
        String[] osat = this.teksti.split(" ");
        return osat;
    }
    
    public void asetaLekseemi() {
        this.lekseemi = this.jaaSanoiksi()[this.jaaSanoiksi().length - 1];
        if (onMonikko()) {
            this.lekseemi = this.lekseemi.substring(0, this.lekseemi.length() - 1);
        } 
    }
    
    public boolean onMonikko() {
        if (this.teksti.charAt(this.teksti.length() - 1) == 's') {
            // pitää tarkistaa onko myös substantiivi
            // ja löytyykö ylipäätään sanakirjasta
            return true;
        }
        return false;
    }
    
    
    
    
}
