/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.Aikamuoto;
import ada.kaannin.suomi.Modus;
import ada.kaannin.suomi.NomininLuku;
import ada.kaannin.suomi.Persoona;
import ada.kaannin.suomi.Sijamuoto;
import ada.kaannin.suomi.SuomiLauseke;
import ada.kaannin.suomi.Vertailumuoto;
import java.util.ArrayList;
import java.util.HashMap;

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
    
    private boolean monikkoisuus;
    
    public Lauseke(String teksti, Sanakirja s, SyntaksiSanakirja ss) {
        this.teksti = teksti;
        this.lekseemi = "";
        this.s = s;
        this.ss = ss;
        this.monikkoisuus = false;
    }
    
    /**
     * Metodi etsii lekseemin, hakee sille sanakirjasta käännöksen ja
     * asettaa käännöksen suomi-paketin kautta oikeaan sananmuotoon
     */
    
    public void kaanna() {
        
        String kaannettyTeksti = "";
        
        if (etsiNumeronKaannos() != null) {
            kaannettyTeksti += etsiNumeronKaannos();
            kaannettyTeksti += " ";
        }
        
        asetaLekseemi();
                
        HashMap<String, Sanaluokka> kaannos = s.haeKaannos(lekseemi);
        
        if (kaannos == null) {
            System.out.println("oli null");
            return;
        }
        
        if (s.haeKaannoksenSanaluokka(lekseemi).get(0).equals(Sanaluokka.EISANALUOKKAA)) {
            for (String englantiIsoillaKirjaimilla : kaannos.keySet()) {
                kaannettyTeksti = englantiIsoillaKirjaimilla;
            }
        } else {
            SuomiLauseke suomilauseke = null;
            for (String suomi : kaannos.keySet()) {
                suomilauseke = luoSuomilauseke(suomi);
                break;
            }
            
            kaannettyTeksti = suomilauseke.taivuta();
        }
        this.teksti = kaannettyTeksti;
    }
    
    
    public String etsiNumeronKaannos() {
        if (etsiNumeroita() == null) return null;
        for (String suomi : s.haeKaannos(etsiNumeroita()).keySet()) {
            if (s.haeKaannoksenSanaluokka(etsiNumeroita()).equals(Sanaluokka.NUMERAALI)) {
                return suomi;
            }
        }
        return null;
    }
    
    
    public String etsiNumeroita() {

        for (int i = 0; i < jaaSanoiksi().length; i++) {
            if (s.onNumeraali(jaaSanoiksi()[i])) {
                return jaaSanoiksi()[i];
            }
        }
        return null;
    }
    
    
    
    /**
     * Metodi luo uuden suomi-paketin lausekkeen sanaluokan 
        ja sanaluokan mukaisesti syntaksien haun avulla
     * @param suomi sanakirjan mukainen ensimmäinen käännös
     * @return suomi-paketin mukainen lauseke
     */
    public SuomiLauseke luoSuomilauseke(String suomi) {
        
        NomininSyntaksihaku nsh = new NomininSyntaksihaku(ss, this.teksti);
        VertailumuodoissaTaipuvanSyntaksihaku vtsh = new VertailumuodoissaTaipuvanSyntaksihaku(ss, this.teksti);
        VerbinSyntaksihaku vsh = new VerbinSyntaksihaku(ss, this.teksti);
        
        Sijamuoto sijamuoto = nsh.sijamuoto();
        NomininLuku luku = nsh.luku(monikkoisuus);
        Vertailumuoto vertailumuoto = vtsh.vertailumuoto();
        Persoona persoona = vsh.persoona();
        Aikamuoto aikamuoto = vsh.aikamuoto();
        Modus modus = vsh.modus();
        
        final Sanaluokka luokka = s.haeKaannoksenSanaluokka(lekseemi).get(0);
        
        if (luokka.equals(Sanaluokka.SUBSTANTIIVI)) {
            return new SuomiLauseke(luokka, suomi, luku, sijamuoto);
        } else if (luokka.equals(Sanaluokka.ADJEKTIIVI)) {
            return new SuomiLauseke(luokka, suomi, luku, sijamuoto, vertailumuoto);
        } else if (luokka.equals(Sanaluokka.PRONOMINI)) {
            return new SuomiLauseke(luokka, suomi, luku, sijamuoto);
        } else if (luokka.equals(Sanaluokka.NUMERAALI)) {
            return new SuomiLauseke(luokka, suomi, luku, sijamuoto);
        } else if (luokka.equals(Sanaluokka.VERBI)) {
            return new SuomiLauseke(luokka, suomi, persoona, modus, aikamuoto);
        } else if (luokka.equals(Sanaluokka.PARTIKKELI)) {
            if (s.onAdverbi(teksti)) {
                return new SuomiLauseke(luokka, suomi, vertailumuoto);
            }
        }
        
        return new SuomiLauseke(luokka, suomi);
        
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
        
        if(onVerbimuoto(mahdollinenLekseemi)) {
            //muunnetaan infinitiiviksi
        }
        this.lekseemi = mahdollinenLekseemi;
    }
    
    /**
     * Tutkii, onko jokin sana monikossa, esim "holders"
     * 
     * @param mahdollinenLekseemi
     * @return true, jos sana on monikkomuoto
     */
    
    public boolean onMonikko(String mahdollinenLekseemi) {
        
        if(mahdollinenLekseemi.isEmpty()) {
            return false;
        }
        
        if (mahdollinenLekseemi.charAt(mahdollinenLekseemi.length() - 1) == 's') {
            mahdollinenLekseemi = mahdollinenLekseemi.substring(0, mahdollinenLekseemi.length() - 1);
            if (s.sisaltaaSanan(mahdollinenLekseemi) && s.onSubstantiivi(mahdollinenLekseemi)) {
                this.monikkoisuus = true;
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
