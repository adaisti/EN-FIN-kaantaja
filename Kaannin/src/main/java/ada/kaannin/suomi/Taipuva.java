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
public abstract class Taipuva {
    
    protected String lekseemi;
    protected boolean astevaihtelu;
    protected String sananmuoto;
    
    public Taipuva(String lekseemi, boolean astevaihtelu, String sananmuoto) {
        this.lekseemi = lekseemi;
        this.astevaihtelu = astevaihtelu;
        this.sananmuoto = sananmuoto;
    }
    
    // voisi tehdä metodin joka päättelee onko sanassa astevaihtelu vai ei
    
    public String heikkoAste(){
        
        if (!this.astevaihtelu) {
            return this.lekseemi;
        }
        this.astevaihtelu = false;
        
        String vika = this.lekseemi.substring(this.lekseemi.length() - 1);
        String alku = this.lekseemi.substring(0, this.lekseemi.length() - 4);
        String muokattava = this.lekseemi.substring(this.lekseemi.length() - 3, this.lekseemi.length() - 2);

        if (!onVokaali(Character.toString(this.lekseemi.charAt(this.lekseemi.length() - 3)))) {
            if (muokattava.equals("pp") || muokattava.equals("tt") || muokattava.equals("kk")) {
                muokattava = muokattava.substring(1);
            } else if (muokattava.equals("mp")) {
                muokattava = "mm";
            } else if (muokattava.equals("nt")) {
                muokattava = "nn";
            } else if (muokattava.equals("nk")) {
                muokattava = "ng";
            } else if (muokattava.equals("lt")) {
                muokattava = "ll";
            } else if (muokattava.equals("rt")) {
                muokattava = "rr";
            }

            this.sananmuoto = alku + muokattava + vika;
            return this.sananmuoto;
        } else {
            muokattava = this.lekseemi.substring(this.lekseemi.length() - 2, this.lekseemi.length() - 2);
            alku = this.lekseemi.substring(0, this.lekseemi.length() - 3);

            if (muokattava.equals("p")) {
                muokattava = "v";
            } else if (muokattava.equals("t")) {
                muokattava = "d";
            } else if (muokattava.equals("k")) {
                muokattava = "";
            }

            this.sananmuoto = alku + muokattava + vika;
            return this.sananmuoto;
        }
    }
    
    public boolean onVokaali(String kirjain) {
        if (kirjain.equals("a") || kirjain.equals("e") || kirjain.equals("i") || kirjain.equals("o") || kirjain.equals("u") || kirjain.equals("y") || kirjain.equals("ä") || kirjain.equals("ö")) {
            return true;
        }
        return false;
    }
    
    
     public Vokaali vokaali() {
        
        for (int i = this.lekseemi.length() - 1; i >= 0; i++) {
            if (this.lekseemi.charAt(i) == 'y' || this.lekseemi.charAt(i) == 'ä' || this.lekseemi.charAt(i) == 'ö') {
                return Vokaali.TAKA;
            } else if (this.lekseemi.charAt(i) == 'i' || this.lekseemi.charAt(i) == 'e') {
                return Vokaali.NEUTRAALI;
            } else if (this.lekseemi.charAt(i) == 'a' || this.lekseemi.charAt(i) == 'o' || this.lekseemi.charAt(i) == 'u') {
                return Vokaali.ETU;
            }
        }
        return Vokaali.ETU;
    }
    
}

