/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.suomi;


import java.util.HashMap;

/**
 *
 * @author adahyvarinen
 * 
 * 
 * Luokka tekee kaikille nomineille yhteiset operaatiot,
 * lähinnä asettaa ne oikeaan sijamuotoon
 */


public abstract class Nomini extends Taipuva {
    
    protected NomininLuku luku;
    protected Sijamuoto sijamuoto;
    protected Vokaali vokaali;
    
    public Nomini(String lekseemi) {
        super(lekseemi);
        this.luku = NomininLuku.YKSIKKO;
        this.sijamuoto = Sijamuoto.NOMINATIIVI;
    }

    public Nomini(String lekseemi, NomininLuku luku, Sijamuoto sijamuoto) {
        super(lekseemi);
        this.luku = luku;
        this.sijamuoto = sijamuoto;
    }
    
    /**
     * asettaa sanan oikeaan sijamuotoon ja palauttaa sen
     * @return taivutettu sana
     */
    
    public String sananmuoto() {
        this.asetaSijamuoto();
        return this.sananmuoto;
    }
 
    /**
     * Luokan tärkein kattometodi
     * Asettaa sananmuodon oikeaan sijamuotoon
     * Hyödyntää muita luokan metodeja
     */
    
    
    public void asetaSijamuoto() {
        if (this.luku.equals(NomininLuku.YKSIKKO)) {
            asetaYksikonSijamuoto();
        } else {
            asetaMonikonSijamuoto();
        }
    }
    
    /**
     * Asettaa yksikölle oikean sijamuodon
     * Hyödyntää apumetodeja
     */
    
    public void asetaYksikonSijamuoto() {
        
        if (this.sijamuoto.equals(Sijamuoto.GENETIIVI)) {
            this.yksikonGenetiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.PARTITIIVI)) {
            this.yksikonPartitiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ESSIIVI)) { 
            this.yksikonEssiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.TRANSLATIIVI)) {
            this.yksikonTranslatiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.INESSIIVI)) {
            this.yksikonInessiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ELATIIVI)) {
            this.yksikonElatiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ILLATIIVI)) {
            this.yksikonIllatiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ADESSIIVI)) {
            this.yksikonAdessiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ABLATIIVI)) {
            this.yksikonAblatiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ALLATIIVI)) {
            this.yksikonAllatiivi();
        }
    }
    
    /**
     * Asettaa monikolle oikean sijamuodon
     * Hyödyntää apumetodeja
     */
    
    public void asetaMonikonSijamuoto() {

        if (this.sijamuoto.equals(Sijamuoto.NOMINATIIVI)) {
            this.monikonNominatiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.GENETIIVI)) {
            this.monikonGenetiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.PARTITIIVI)) {
            this.monikonPartitiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ESSIIVI)) { 
            this.monikonEssiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.TRANSLATIIVI)) {
            this.monikonTranslatiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.INESSIIVI)) {
            this.monikonInessiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ELATIIVI)) {
            this.monikonElatiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ILLATIIVI)) {
            this.monikonIllatiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ADESSIIVI)) {
            this.monikonAdessiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ABLATIIVI)) {
            this.monikonAblatiivi();
        } else if (this.sijamuoto.equals(Sijamuoto.ALLATIIVI)) {
            this.monikonAllatiivi();
        }
    }
   
    
    /**
     * Asettaa sanan yksikön genetiiviin
     */
    
    public void yksikonGenetiivi() {
        super.heikkoAste();
        this.sananmuoto += "n";
    }
    
    /**
     * Asettaa sanan yksikön partitiiviin
     */
    
    public void yksikonPartitiivi() {
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan yksikön essiiviin
     */
    
    public void yksikonEssiivi() {
        this.sananmuoto += "n";
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan yksikön translatiiviin
     */
    
    public void yksikonTranslatiivi() {
        super.heikkoAste();
        this.sananmuoto += "ksi";
    }
    
    /**
     * Asettaa sanan yksikön inessiiviin
     */
    
    public void yksikonInessiivi() {
        super.heikkoAste();
        this.sananmuoto += "ss";
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan yksikön elaiiviin
     */
    
    public void yksikonElatiivi() {
        super.heikkoAste();
        this.sananmuoto += "st";
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan yksikön illatiiviin
     */
    
    public void yksikonIllatiivi() {
        String vikaKirjain = Character.toString(this.sananmuoto.charAt(this.sananmuoto.length() - 1));
            
        if (onVokaali(vikaKirjain)) {
            this.sananmuoto += vikaKirjain;
        } else {
            this.sananmuoto += "ee"; //tätä täytyy vielä miettiä 
        }

        this.sananmuoto += "n";
    }
    
    /**
     * Asettaa sanan yksikön adessiiviin
     */
    
    public void yksikonAdessiivi() {
        super.heikkoAste();
        this.sananmuoto += "ll";
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan yksikön ablatiiviin
     */
    
    public void yksikonAblatiivi() {
        super.heikkoAste();
        this.sananmuoto += "lt";
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan yksikön allatiiviin
     */
    
    public void yksikonAllatiivi() {
        super.heikkoAste();
        this.sananmuoto += "lle";
    }
    
    /**
     * Asettaa sanan monikon nominatiiviin
     */
    
    public void monikonNominatiivi() {
        super.heikkoAste();
        this.sananmuoto += "t";
    }
    
    /**
     * Asettaa sanan monikon genetiiviin
     */
    
    public void monikonGenetiivi() {
        this.sananmuoto += "jen";
    }
    
    /**
     * Asettaa sanan monikon partitiiviin
     */
    
    public void monikonPartitiivi() {
        this.sananmuoto += "j";
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan monikon essiiviin
     */
    
    public void monikonEssiivi() {
        this.sananmuoto += "in";
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan monikon translatiiviin
     */
    
    public void monikonTranslatiivi() {
        super.heikkoAste();
        this.sananmuoto += "iksi";
    }
    
    /**
     * Asettaa sanan monikon inessiiviin
     */
    
    public void monikonInessiivi() {
        super.heikkoAste();
        this.sananmuoto += "iss";
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan monikon elatiiviin
     */
    
    public void monikonElatiivi() {
        super.heikkoAste();
        this.sananmuoto += "ist";
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan monikon illatiiviin
     */
    
    public void monikonIllatiivi() {
        this.sananmuoto += "ihin";
    }
    
    /**
     * Asettaa sanan monikon adessiiviin
     */
    
    public void monikonAdessiivi() {
        super.heikkoAste();
        this.sananmuoto += "ill";
        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan monikon ablatiiviin
     */
    
    public void monikonAblatiivi() {
        super.heikkoAste();
            
        if (this.sananmuoto.charAt(this.sananmuoto.length() - 1) != 'i') {
            this.sananmuoto += "ilt";
        } else {
            this.sananmuoto += "lt";
        }

        this.sananmuoto += super.harmoninenA();
    }
    
    /**
     * Asettaa sanan monikon allatiiviin
     */
    
    public void monikonAllatiivi() {
        super.heikkoAste();
        this.sananmuoto += "ille";
    }
}

