/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import java.util.ArrayList;

/**
 *
 * @author adahyvarinen
 */
public class Lause {
    
    String teksti;
    ArrayList<Lauseke> lausekkeet;
    SyntaksiSanakirja ss;
    Sanakirja s;
    
    public Lause(SyntaksiSanakirja syntaksisanakirja, Sanakirja sanakirja, String teksti) {
        this.ss = syntaksisanakirja;
        this.s = sanakirja;
        this.teksti = teksti;
        this.lausekkeet = new ArrayList<Lauseke>();
    }
    
    /**
     * Metodi jakaa luokalle konstruktorissa annetun
     * tekstin lausekkeiksi
     */

    public void jaaLausekkeiksi() {

        String[] osat = this.jaaSanoiksi();
        String lausekkeenTeksti = "";
        int i = 0;
        
        while (i < osat.length) {
            
            while (!onLausekkeenLoppu(osat[i])) {
                lausekkeenTeksti += osat[i];
                lausekkeenTeksti += " ";
                i++;
            }
            
            Lauseke lauseke = new Lauseke(lausekkeenTeksti, s, ss);
            lausekkeet.add(lauseke);
            teksti = "";
        }
        
    }
    
    
    public ArrayList<Lauseke> lausekkeet() {
        return this.lausekkeet;
    }
    
    public String[] jaaSanoiksi() {
        String[] osat = this.teksti.split(" ");
        return osat;
    }
    
    /**
     * Metodi tutkii voiko annettu sana olla lausekkeen loppu
     *
     * @param   sana   Lausekkeessa esiintyvä sana
     * 
     * @return  false, jos annettu sana ei lopeta lauseketta, muuten true 
    */
    
    public boolean onLausekkeenLoppu(String sana) {
        if (onPrepositio(sana) || onNumero(sana) || onArtikkeli(sana) || s.onAdjektiivi(sana) || s.onPronomini(sana)) {
            return false;
        }
        return true;
    }
    
    
    public boolean onPrepositio(String sana) {
        if (ss.prepositiot().keySet().contains(sana)) {
            return true;
        }
        return false;
    }
    
    public boolean onNumero(String sana) {
        if (ss.numerot().keySet().contains(sana)){
            return true;
        }
        return false;
    }
    
    public boolean onArtikkeli(String sana) {
        if (ss.artikkelit().contains(sana)) {
            return true;
        }
        return false;
    }
    
    
    
    
    
}
