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
            if (this.sijamuoto.equals(Sijamuoto.GENETIIVI)) {
                super.heikkoAste();
                this.sananmuoto += "n";
            } else if (this.sijamuoto.equals(Sijamuoto.PARTITIIVI)) {
                if (this.vokaali.equals(Vokaali.ETU)) {
                    this.sananmuoto += "a";
                } else {
                    this.sananmuoto += "ä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.ESSIIVI)) { 
                if (this.vokaali.equals(Vokaali.ETU)) {
                    this.sananmuoto += "na";
                } else {
                    this.sananmuoto += "nä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.TRANSLATIIVI)) {
                super.heikkoAste();
                this.sananmuoto += "ksi";
            } else if (this.sijamuoto.equals(Sijamuoto.INESSIIVI)) {
                super.heikkoAste();
                if (this.vokaali.equals(Vokaali.ETU)) {
                    this.sananmuoto += "ssa";
                } else {
                    this.sananmuoto += "ssä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.ELATIIVI)) {
                super.heikkoAste();
                if (this.vokaali.equals((Vokaali.ETU))) {
                    this.sananmuoto += "sta";
                } else {
                    this.sananmuoto += "stä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.ILLATIIVI)) {
                this.sananmuoto += Character.toString(this.lekseemi.charAt(this.lekseemi.length() - 1));
                this.sananmuoto += "n";
            } else if (this.sijamuoto.equals(Sijamuoto.ADESSIIVI)) {
                super.heikkoAste();
                if (this.vokaali.equals(Vokaali.ETU)) {
                    this.sananmuoto += "lla";
                } else {
                    this.sananmuoto += "llä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.ABLATIIVI)) {
                super.heikkoAste();
                if (this.vokaali.equals(Vokaali.ETU)) {
                    this.sananmuoto += "lta";
                } else {
                    this.sananmuoto += "llä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.ALLATIIVI)) {
                super.heikkoAste();
                this.sananmuoto += "lle";
            }
        } else {
            if (this.sijamuoto.equals(Sijamuoto.NOMINATIIVI)) {
                super.heikkoAste();
                this.sananmuoto += "t";
            } else if (this.sijamuoto.equals(Sijamuoto.GENETIIVI)) {
                this.sananmuoto += "jen";
            } else if (this.sijamuoto.equals(Sijamuoto.PARTITIIVI)) {
                if (this.vokaali.equals(Vokaali.ETU)) {
                    this.sananmuoto += "ja";
                } else {
                    this.sananmuoto += "jä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.ESSIIVI)) { 
                if (this.vokaali.equals(Vokaali.ETU)) {
                    this.sananmuoto += "ina";
                } else {
                    this.sananmuoto += "inä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.TRANSLATIIVI)) {
                super.heikkoAste();
                this.sananmuoto += "iksi";
            } else if (this.sijamuoto.equals(Sijamuoto.INESSIIVI)) {
                super.heikkoAste();
                if (this.vokaali.equals(Vokaali.ETU)) {
                    this.sananmuoto += "issa";
                } else {
                    this.sananmuoto += "issä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.ELATIIVI)) {
                super.heikkoAste();
                if (this.vokaali.equals((Vokaali.ETU))) {
                    this.sananmuoto += "ista";
                } else {
                    this.sananmuoto += "istä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.ILLATIIVI)) {
                this.sananmuoto += "hin";
            } else if (this.sijamuoto.equals(Sijamuoto.ADESSIIVI)) {
                super.heikkoAste();
                if (this.vokaali.equals(Vokaali.ETU)) {
                    this.sananmuoto += "illa";
                } else {
                    this.sananmuoto += "illä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.ABLATIIVI)) {
                super.heikkoAste();
                if (this.vokaali.equals(Vokaali.ETU)) {
                    this.sananmuoto += "ilta";
                } else {
                    this.sananmuoto += "illä";
                }
            } else if (this.sijamuoto.equals(Sijamuoto.ALLATIIVI)) {
                super.heikkoAste();
                this.sananmuoto += "ille";
            }
        }
            
    }
    
   
}

