/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.suomi;

/**
 *
 * Kokoaa kaikkien taipuvien sanojen yhteiset ominaisuudet, kuten astevaihtelun ja vokaaliharmonian
 * 
 * @author adahyvarinen
 */
public abstract class Taipuva {
    
    protected String lekseemi;
    protected boolean astevaihtelu;
    protected String sananmuoto;
    protected Vokaali vokaali;
    
    public Taipuva(String lekseemi) {
        this.lekseemi = lekseemi;
        this.sananmuoto = lekseemi;
        this.vokaali = vokaali();
    }
    
    /**
     * Alkeellinen tapa tutkia onko jossakin sanassa astevaihtelu
     * @return true jos sanassa voi esiintyä astevaihtelua, muuten false
     */
    
    public boolean astevaihtelu() {
        String vika = this.sananmuoto.substring(this.sananmuoto.length() - 1);
        String tokavika = this.sananmuoto.substring(this.sananmuoto.length() - 2, this.sananmuoto.length() - 1);
        
        if (onVokaali(vika)) {
            if (tokavika.equals("k") || tokavika.equals("p") || tokavika.equals("t")) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Kattometodi sananmuodon heikkoasteisen astevaihtelumuodon sanavartalon muodostamiseksi
     * Esim puikko: puiko
     * 
     * @return sanavartalo
     */
    
    public String heikkoAste(){
        
        this.astevaihtelu = astevaihtelu();
        
        if (!this.astevaihtelu || this.sananmuoto.length() < 3) {
            return this.sananmuoto;
        }

        if (!onVokaali(Character.toString(this.sananmuoto.charAt(this.sananmuoto.length() - 3)))) {
            return this.heikkoAsteKaksiKirjaintaMuuttuu();
        } else {
            return this.heikkoAsteYksiKirjainMuuttuu();
        }
    }
    
    /**
     * 
     * @return yhtä kirjainta vastaava heikkoasteinen kirjain
     */
    
    public String heikkoAsteYksiKirjainMuuttuu() {
        String muokattava = this.sananmuoto.substring(this.sananmuoto.length() - 2, this.sananmuoto.length() - 1);
        String alku = this.sananmuoto.substring(0, this.sananmuoto.length() - 2);
        String vika = this.sananmuoto.substring(this.sananmuoto.length() - 1);
        

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
    
    /**
     * 
     * 
     * @return kahta kirjainta vastaava heikkoasteinen merkkijono
     */
    
    public String heikkoAsteKaksiKirjaintaMuuttuu() {
        String vika = this.sananmuoto.substring(this.sananmuoto.length() - 1);
        String alku = this.sananmuoto.substring(0, this.sananmuoto.length() - 3);
        String muokattava = this.sananmuoto.substring(this.sananmuoto.length() - 3, this.sananmuoto.length() - 1);
        
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
    }
    
    /**
     * Tutkii onko joku kirjain vokaali
     * 
     * @param kirjain
     * @return true jos kirjain on vokaali, muuten false
     */
    
    public boolean onVokaali(String kirjain) {
        if (kirjain.equals("a") || kirjain.equals("e") || kirjain.equals("i") || kirjain.equals("o") || kirjain.equals("u") || kirjain.equals("y") || kirjain.equals("ä") || kirjain.equals("ö")) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodi palauttaa a tai ä käytettävän vokaalin mukaisesti
     * 
     * @return a tai ä
     */
    
    
    public String harmoninenA() {
        if (this.vokaali().equals(Vokaali.ETU)) {
            return "a";
        } else {
            return "ä";
        }
    }
    
    /**
     * Tutkii minkä vokaaliharmonian mukainen sana on
     *  
     * @return etu-, taka- tai neutraalivokaali
     */
    
     public Vokaali vokaali() {
        for (int i = this.lekseemi.length() - 1; i >= 0; i--) {
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

