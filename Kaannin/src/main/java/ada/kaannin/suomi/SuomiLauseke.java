/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.suomi;

import ada.kaannin.englanti.Sanaluokka;

/**
 *
 * Luokka hyödyntää kaikkien muiden paketin luokkien ominaisuuksia ja luo
 * niihin sopivia lausekkeita
 * 
 * @author adahyvarinen
 */
public class SuomiLauseke {
    
    private Sanaluokka sanaluokka;
    private String lekseemi;
    private Vertailumuoto vertailumuoto;
    private NomininLuku luku;
    private Sijamuoto sijamuoto;
    private Modus modus;
    private Persoona persoona;
    private Aikamuoto aikamuoto;
    
    public SuomiLauseke (Sanaluokka sanaluokka, String lekseemi) {
        this.lekseemi = lekseemi;
        this.sanaluokka = sanaluokka;
    }
    
    public SuomiLauseke (Sanaluokka sanaluokka, String lekseemi, Vertailumuoto vertailumuoto) {
        this.lekseemi = lekseemi;
        this.vertailumuoto = vertailumuoto;
        this.sanaluokka = sanaluokka;
    }
    
    public SuomiLauseke (Sanaluokka sanaluokka, String lekseemi, NomininLuku luku, Sijamuoto sijamuoto) {
        this.lekseemi = lekseemi;
        this.luku = luku;
        this.sijamuoto = sijamuoto;
        this.sanaluokka = sanaluokka;
    }
    
    public SuomiLauseke (Sanaluokka sanaluokka, String lekseemi, NomininLuku luku, Sijamuoto sijamuoto, Vertailumuoto vertailumuoto) {
        this.lekseemi = lekseemi;
        this.vertailumuoto = vertailumuoto;
        this.luku = luku;
        this.sijamuoto = sijamuoto;
        this.sanaluokka = sanaluokka;
    }
    
    public SuomiLauseke(Sanaluokka sanaluokka, String lekseemi, Persoona persoona, Modus modus, Aikamuoto aikamuoto) {
        this.lekseemi = lekseemi;
        this.persoona = persoona;
        this.modus = modus;
        this.aikamuoto = aikamuoto;
        this.sanaluokka = sanaluokka;
    }
    
    /**
     * Asettaa sanan oikeaan sananmuotoon
     * @return taivutusten mukainen sananmuoto
     */
    
    public String taivuta() {
        if (this.sanaluokka.equals(Sanaluokka.ADJEKTIIVI)) {
            Adjektiivi sana = new Adjektiivi(lekseemi, luku, sijamuoto, vertailumuoto);
            return sana.sananmuoto();
        } else if (this.sanaluokka.equals(Sanaluokka.SUBSTANTIIVI)) {
            Substantiivi sana = new Substantiivi(lekseemi, luku, sijamuoto);
            return sana.sananmuoto();
        } else if (this.sanaluokka.equals(Sanaluokka.NUMERAALI)) {
            Numeraali sana = new Numeraali(lekseemi, luku, sijamuoto);
            return sana.sananmuoto();
        } else if (this.sanaluokka.equals(Sanaluokka.PARTIKKELI)) {
            if (this.vertailumuoto == null) {
                Partikkeli sana = new Partikkeli(lekseemi);
                return sana.sananmuoto();
            } else {
                Partikkeli sana = new Partikkeli(lekseemi,vertailumuoto);
                return sana.sananmuoto();
            }
        } else if (this.sanaluokka.equals(Sanaluokka.PRONOMINI)) {
            Pronomini sana = new Pronomini(lekseemi, luku, sijamuoto);
            return sana.sananmuoto();
        } else if (this.sanaluokka.equals(Sanaluokka.VERBI)) {
            Verbi sana = new Verbi(lekseemi, persoona, modus, aikamuoto);
            return sana.sananmuoto();
        } else {
            return this.lekseemi;
        }
    }
            
            
}
