/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import java.util.ArrayList;

/**
 * Luokka jakaa annetun lauseen lausekkeiksi
 * ja huolehtii siitä, että lauseita aletaan käsitellä
 * 
 * 
 * @author adahyvarinen
 */
public class Lause {
    
    private String teksti;
    private ArrayList<Lauseke> lausekkeet;
    private SyntaksiSanakirja ss;
    private Sanakirja s;
    
    public Lause(SyntaksiSanakirja syntaksisanakirja, Sanakirja sanakirja, String teksti) {
        this.ss = syntaksisanakirja;
        this.s = sanakirja;
        this.teksti = teksti;
        this.lausekkeet = new ArrayList<>();
    }
    
    
    /**
     * Metodi kääntää lauseen tekstin lauseke kerrallaan
     */
    
    public void kaanna() {
        jaaLausekkeiksi();
        this.teksti = "";
        for (Lauseke lauseke : lausekkeet) {
            lauseke.kaanna();
            this.teksti += lauseke.toString();
            this.teksti += " ";
        }
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
                
                if (i > osat.length - 2) {
                    break;
                }
                i++;
            }
            
            lausekkeenTeksti += osat[i];
            
            Lauseke lauseke = new Lauseke(lausekkeenTeksti, s, ss);
            lausekkeet.add(lauseke);
            lausekkeenTeksti = "";
            i++;
        }
        
    }
    
    
    public ArrayList<Lauseke> lausekkeet() {
        return this.lausekkeet;
    }
    
    /**
     * 
     * Metodi erottaa välilyönnein erotellut sanat
     * 
     * @return lauseen sanat
     */
    
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
    
    /**
     * Metodi tutkii, onko sana prepositio
     * 
     * @param sana
     * @return true, jos sana on prepositio
     */
    
    public boolean onPrepositio(String sana) {
        if (ss.prepositiot().keySet().contains(sana)) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tutkii, onko sana numero
     * 
     * @param sana
     * @return true, jos sana on numero
     */
    
    public boolean onNumero(String sana) {
        if (ss.numerot().keySet().contains(sana)){
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tutkii, onko sana artikkeli
     * 
     * @param sana
     * @return true, jos sana on artikkeli
     */
    
    public boolean onArtikkeli(String sana) {
        if (ss.artikkelit().contains(sana)) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return this.teksti;
    }
}
