/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.suomi;

/**
 *
 * @author adahyvarinen
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
    
    public String sananmuoto() {
        this.asetaModus();
        return this.sananmuoto;
    }
    
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
    
    public void indikatiivi() {
        this.asetaPersoona();
    }
    
    public void konditionaali() {
        this.sananmuoto += "isi";
        this.asetaPersoona();
    }
    
    public void potentiaali() {
        this.sananmuoto += "ne";
        this.asetaPersoona();
    }
    
    public void imperatiivi() {
        this.asetaImperatiivinPersoona();
    }
    
    
    public void asetaImperatiivinPersoona() {
        
        if (this.persoona.equals(Persoona.YKS2)) {
            super.heikkoAste();
        } else if (this.persoona.equals(Persoona.MON2)) {
            this.sananmuoto += "kaa";
        }
    }
    
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
    
    public void yks1Pers() {
        super.heikkoAste();
        this.sananmuoto += "n";
    }
    
    public void yks2Pers() {
        super.heikkoAste();
        this.sananmuoto += "t";
    }
    
    public void yks3Pers() {
        if (this.modus.equals(Modus.INDIKATIIVI)) {
            this.sananmuoto += this.sananmuoto.substring(this.sananmuoto.length() - 1, this.sananmuoto.length() - 1);
        }
    }
    
    public void mon1Pers() {
        super.heikkoAste();
        this.sananmuoto += "mme";
    }
    
    public void mon2Pers() {
        super.heikkoAste();
        this.sananmuoto += "tte";
    }
    
    public void mon3Pers() {
        this.sananmuoto += "vat";
    }
    
    public void passiivi() {
        super.heikkoAste();
        
        if (this.sananmuoto.charAt(this.sananmuoto.length() - 1) == 'a') {
            this.sananmuoto = this.sananmuoto.substring(0, this.sananmuoto.length() - 1);
            this.sananmuoto += "e";
        }
        
        this.sananmuoto += "taan";
    }
    
    
    
    
    
    
    
    
    
    
}
