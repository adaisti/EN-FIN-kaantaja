/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.kayttoliittyma;

import ada.kaannin.englanti.Hakemistonhallinta;
import ada.kaannin.englanti.Lause;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * Käsittelee ohjelmalle annettua tekstiä ja jakaa sen lauseiksi
 * 
 * @author adahyvarinen
 */
public class Teksti {
    
    private String teksti;
    private ArrayList<Lause> lauseet;
    private Hakemistonhallinta hh;
    
    public Teksti (String teksti) throws FileNotFoundException {
        this.teksti = teksti;
        this.lauseet = new ArrayList<>();
        this.hh = new Hakemistonhallinta();
    }
    
    /**
     * Metodi kääntää Lause kerrallaan Tekstin tekstin
     * 
     * @return käännetty teksti
     */
    
    public String kaanna() {
        
        jaaLauseiksi();
        String kaannettyTeksti = "";
       
        for (Lause lause : lauseet) {
            if (!onValimerkkiLause(lause)) {
                lause.kaanna();
                kaannettyTeksti += lause.toString();
            } else {
                kaannettyTeksti += lause.toString();
            }
        }
        
        return kaannettyTeksti;
    }
    
    /**
     * Metodi jakaa tekstin Lauseiksi ja lisää ne lauseet-listaan
     */
    
    public void jaaLauseiksi() {
        String uusilause = "";
        for (int i = 0; i < this.teksti.length(); i++) {
            if ((this.teksti.charAt(i) == '.' && (i > 0 && !hh.ss().numerot().keySet().contains(Character.toString(this.teksti.charAt(i - 1)))))|| this.teksti.charAt(i) == ',' || this.teksti.charAt(i) == '!') {
                Lause lause = new Lause(hh.ss(), hh.s(), uusilause);
                if(!uusilause.isEmpty()) {
                    lauseet.add(lause);
                    uusilause = "";
                }
                Lause valimerkkilause = new Lause(hh.ss(), hh.s(), Character.toString(this.teksti.charAt(i)));
                lauseet.add(valimerkkilause);
            } else {
                uusilause += Character.toString(this.teksti.charAt(i));
            }
        }
        
        if (!uusilause.isEmpty()) {
            Lause lause = new Lause(hh.ss(), hh.s(), uusilause);
            lauseet.add(lause);
        }
    }
    
    /**
     * Metodi tutkii onko jokin lause pelkkä välimerkki
     * 
     * @param lause
     * @return true, jos lause on vain välimerkki
     */
    
    public boolean onValimerkkiLause(Lause lause) {
        // onko tämä tarkistus hyvä näin päin?
        // vai pitäisikö se tehdä jossain muualla?
        if (lause.toString().isEmpty()) {
            return true;
        }
        
        return lause.toString().charAt(0) == '.' || lause.toString().charAt(0) == ',' || lause.toString().charAt(0) == '!';
    }
    
    
    
    public ArrayList<Lause> lauseet() {
        return this.lauseet;
    }
}
