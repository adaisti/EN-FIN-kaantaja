/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

/**
 *
 * Luokka operoi lausekkeita, eli yksiköitä, joissa voi olla useita sanoja, mutta
 * joissa sanat muodostavat kieliopillisesti kiinteän ja yhtenäisen kokonaisuuden
 * 
 * @author adahyvarinen
 */
public class Lauseke {
    
    private String lekseemi;
    private String teksti;
    private Sanakirja s;
    private SyntaksiSanakirja ss;
    
    public Lauseke(String teksti, Sanakirja s, SyntaksiSanakirja ss) {
        this.teksti = teksti;
        this.lekseemi = "";
        this.s = s;
        this.ss = ss;
    }
    
    /**
     * Jaetaan lausekkeen teksti sanoiksi
     * 
     * @return välilyönnein erotellut sanat
     */
    
    public String[] jaaSanoiksi() {
        String[] osat = this.teksti.split(" ");
        return osat;
    }
    
    /**
     * Tutkii, mikä sanoista on lekseemi, eli lausekkeen pohja, johon muut sanat viittaavat
     */
    
    public void asetaLekseemi() {
        String mahdollinenLekseemi = this.jaaSanoiksi()[this.jaaSanoiksi().length - 1];
        if (onMonikko(mahdollinenLekseemi)) {
            mahdollinenLekseemi = mahdollinenLekseemi.substring(0, mahdollinenLekseemi.length() - 1);
        }
        // tarkistetaan onko verbipääte
        // tarkistetaanko myös onko edes Sanakirjassa?
        this.lekseemi = mahdollinenLekseemi;
    }
    
    /**
     * Tutkii, onko jokin sana monikossa, esim "holders"
     * 
     * @param mahdollinenLekseemi
     * @return true, jos sana on monikkomuoto
     */
    
    public boolean onMonikko(String mahdollinenLekseemi) {
        if (mahdollinenLekseemi.charAt(mahdollinenLekseemi.length() - 1) == 's') {
            mahdollinenLekseemi = mahdollinenLekseemi.substring(0, mahdollinenLekseemi.length() - 1);
            if (s.sisaltaaSanan(mahdollinenLekseemi) && s.onSubstantiivi(mahdollinenLekseemi)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Tutkii, onko jokin sana verbimuoto, esim "knits"
     * 
     * @param mahdollinenLekseemi
     * @return 
     */
    
    public boolean onVerbimuoto(String mahdollinenLekseemi) {
        if (s.onVerbi(mahdollinenLekseemi)) {
            return true;
        } else if (voiOllaVerbi(mahdollinenLekseemi)) {
            if (etsiVerbipaate(mahdollinenLekseemi) != null) {
                // lisaa verbipaate johonkin fiksuun kohtaan
                // sinne minne tulee syntaksihakuun syötettävää infoa
                return true;
            }
        }
        return false;
    }
    
    /**
     * Tutkii, voiko joku sana olla verbi
     * 
     * @param mahdollinenLekseemi
     * @return true, jos sanaan sisältyy joku verbinä sanakirjaan tallennettu yksikkö
     */
    
    public boolean voiOllaVerbi(String mahdollinenLekseemi) {
        for (int i = 0; i <= mahdollinenLekseemi.length(); i++) {
            if (s.onVerbi(mahdollinenLekseemi.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Tutkii, mikä osuus sanasta on verbipääte
     * 
     * @param mahdollinenLekseemi
     * @return verbipääte
     */
    
    public String etsiVerbipaate(String mahdollinenLekseemi) {
        for (String paate : ss.verbipaatteet().keySet()) {
            if (mahdollinenLekseemi.contains(paate)) {
                if (s.onVerbi(mahdollinenLekseemi.substring(0, mahdollinenLekseemi.length() - paate.length()))
                        || (s.onVerbi(mahdollinenLekseemi.substring(0, mahdollinenLekseemi.length() - paate.length() - 1))
                        && mahdollinenLekseemi.charAt(mahdollinenLekseemi.length() - paate.length()) == mahdollinenLekseemi.charAt(mahdollinenLekseemi.length() - paate.length() - 1))) {
                    return paate;
                }
            }
        }
        return null;
    }
    
    public String lekseemi() {
        return this.lekseemi;
    }
    
    
    
    @Override
    public String toString() {
        return this.teksti;
    }
    
    
    
}
