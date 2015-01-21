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
public abstract class Nomini extends Taipuva {
    
    protected NomininLuku luku;
    protected Sijamuoto sijamuoto;
    protected Vokaali vokaali;
    
    public Nomini(String lekseemi) {
        super(lekseemi, false, lekseemi);
        this.lekseemi = lekseemi;
        this.luku = NomininLuku.YKSIKKO;
        this.sijamuoto = Sijamuoto.NOMINATIIVI;
        this.astevaihtelu = false;
        this.sananmuoto = lekseemi;
        this.vokaali = vokaali();
    }
    
  
    
    public Nomini(String lekseemi, NomininLuku luku, Sijamuoto sijamuoto, boolean astevaihtelu) {
        super(lekseemi, astevaihtelu, lekseemi);
        this.lekseemi = lekseemi;
        this.luku = luku;
        this.sijamuoto = sijamuoto;
        this.astevaihtelu = astevaihtelu;
        this.sananmuoto = lekseemi;
        this.vokaali = vokaali();
    }
    
    
    public String sananmuoto() {
        this.asetaSijamuoto();
        return this.sananmuoto;
    }
 
    public void asetaSijamuoto() {
        if (this.luku.equals(NomininLuku.YKSIKKO)) {
            asetaYksikonSijamuoto();
        } else {
            asetaMonikonSijamuoto();
        }
    }
    
    
    public void asetaYksikonSijamuoto() {
        if (this.sijamuoto.equals(Sijamuoto.GENETIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "n";
        } else if (this.sijamuoto.equals(Sijamuoto.PARTITIIVI)) {
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.ESSIIVI)) { 
            this.sananmuoto += "n";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.TRANSLATIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "ksi";
        } else if (this.sijamuoto.equals(Sijamuoto.INESSIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "ss";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.ELATIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "st";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.ILLATIIVI)) {
            String vikaKirjain = Character.toString(this.sananmuoto.charAt(this.sananmuoto.length() - 1));
            
            if (onVokaali(vikaKirjain)) {
                this.sananmuoto += vikaKirjain;
            } else {
                this.sananmuoto += "ee"; //tätä täytyy vielä miettiä 
            }
            
            this.sananmuoto += "n";
        } else if (this.sijamuoto.equals(Sijamuoto.ADESSIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "ll";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.ABLATIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "lt";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.ALLATIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "lle";
        }
    }
    
    public void asetaMonikonSijamuoto() {
        if (this.sijamuoto.equals(Sijamuoto.NOMINATIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "t";
        } else if (this.sijamuoto.equals(Sijamuoto.GENETIIVI)) {
            this.sananmuoto += "jen";
        } else if (this.sijamuoto.equals(Sijamuoto.PARTITIIVI)) {
            this.sananmuoto += "j";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.ESSIIVI)) { 
            this.sananmuoto += "in";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.TRANSLATIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "iksi";
        } else if (this.sijamuoto.equals(Sijamuoto.INESSIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "iss";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.ELATIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "ist";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.ILLATIIVI)) {
            this.sananmuoto += "hin";
        } else if (this.sijamuoto.equals(Sijamuoto.ADESSIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "ill";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.ABLATIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "ilt";
            this.sananmuoto += super.harmoninenA();
        } else if (this.sijamuoto.equals(Sijamuoto.ALLATIIVI)) {
            super.heikkoAste();
            this.sananmuoto += "ille";
        }
    }
   
}

