/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.suomi;

/**
 *
 * @author adahyvarinen
 * 
 * Käsittelee verbejä
 * Ei osaa käsitellä kovin montaa eri aikamuotoa, vaikka aikamuoto-rakennetta onkin alustettu,
 * sillä neuleohjeissa kaikki on yleensä preesenssissä
 * 
 */
public class Verbi extends Taipuva {

    private Persoona persoona;
    private Modus modus;
    private Aikamuoto aikamuoto;
    
    public Verbi(String lekseemi, Persoona persoona, Modus modus, Aikamuoto aikamuoto) {
        super(lekseemi);
        this.persoona = persoona;
        this.modus = modus;
        this.aikamuoto = aikamuoto;
    }
    
    /**
     * Asettaa sanan oikeaan muotoon
     * @return taivutettu sana
     */
    
    public String sananmuoto() {
        this.asetaModus();
        return this.sananmuoto;
    }
    
    /**
     * Asettaa verbin oikeaan modukseen sekä niiden mukaan persoonaan
     */
    
    public void asetaModus() {
        
        this.sananmuoto = this.sananmuoto.substring(0, this.sananmuoto.length() - 1);
        
        if (this.modus.equals(Modus.INDIKATIIVI)) {
            this.indikatiivi();
        } else if (this.modus.equals(Modus.KONDITIONAALI)) {
            this.konditionaali();
        } else if (this.modus.equals(Modus.POTENTIAALI)) {
            this.potentiaali();
        } else if (this.modus.equals(Modus.IMPERATIIVI)) {
            this.imperatiivi();
        }
    }
    
    /**
     * Asettaa verbin indikatiiviin
     */
    
    public void indikatiivi() {
        this.asetaPersoona();
    }
    
    /**
     * Asettaa verbin konditionaaliin
     */
    
    public void konditionaali() {
        this.sananmuoto += "isi";
        this.asetaPersoona();
    }
    
    /**
     * Asettaa verbin potentiaaliin
     */
    
    public void potentiaali() {
        this.sananmuoto += "ne";
        this.asetaPersoona();
    }
    
    /**
     * Asettaa verbin imperatiiviin
     */
    
    public void imperatiivi() {
        this.asetaImperatiivinPersoona();
    }
    
    /**
     * Asettaa imperatiivimuotoiselle verbille persoonan
     */
    
    public void asetaImperatiivinPersoona() {
        
        if (this.persoona.equals(Persoona.YKS2)) {
            super.heikkoAste();
        } else if (this.persoona.equals(Persoona.MON2)) {
            this.sananmuoto += "kaa";
        }
    }
    
    /**
     * Asettaa säännönmukaisen persoonan
     */
    
    public void asetaPersoona() {
        if (this.persoona.equals(Persoona.YKS1)) {
            this.yks1Pers();
        } else if (this.persoona.equals(Persoona.YKS2)) {
            this.yks2Pers();
        } else if (this.persoona.equals(Persoona.YKS3)) {
            this.yks3Pers();
        } else if (this.persoona.equals(Persoona.MON1)) {
            this.mon1Pers();
        } else if (this.persoona.equals(Persoona.MON2)) {
            this.mon2Pers();
        } else if (this.persoona.equals(Persoona.MON3)) {
            this.mon3Pers();
        } else if (this.persoona.equals(Persoona.PASSIIVI)) {
            this.passiivi();
        }
    }
    
    /**
     * Asettaa yksikön 1. persoonan
     */
    
    public void yks1Pers() {
        super.heikkoAste();
        this.sananmuoto += "n";
    }
    
    /**
     * Asettaa yksikön 2. persoonan
     */
    
    public void yks2Pers() {
        super.heikkoAste();
        this.sananmuoto += "t";
    }
    
    /**
     * Asettaa yksikön 3. persoonan
     */
    
    public void yks3Pers() {
        if (this.modus.equals(Modus.INDIKATIIVI)) {
            this.sananmuoto += this.sananmuoto.substring(this.sananmuoto.length() - 1);
        }
    }
    
    /**
     * Asettaa monikon 1. persoonan
     */
    
    public void mon1Pers() {
        super.heikkoAste();
        this.sananmuoto += "mme";
    }
    
    /**
     * Asettaa monikon 2. persoonan
     */
    
    public void mon2Pers() {
        super.heikkoAste();
        this.sananmuoto += "tte";
    }
    
    /**
     * Asettaa monikon 3. persoonan
     */
    
    public void mon3Pers() {
        this.sananmuoto += "vat";
    }
    
    /**
     * Asettaa passiivin
     */
    
    public void passiivi() {
        super.heikkoAste();
        
        if (this.sananmuoto.charAt(this.sananmuoto.length() - 1) == 'a') {
            this.sananmuoto = this.sananmuoto.substring(0, this.sananmuoto.length() - 1);
            this.sananmuoto += "e";
        }
        
        this.sananmuoto += "taan";
    }
    
    
    
    
    
    
    
    
    
    
}
