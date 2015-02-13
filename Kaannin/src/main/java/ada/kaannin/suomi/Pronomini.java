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
 * Luokka käsittelee pronomineja
 */
public class Pronomini extends Nomini {
    
    private HashMap<String, String> yksikkoMonikko;
    
    
    public Pronomini(String lekseemi, NomininLuku luku, Sijamuoto sijamuoto) {
        super(lekseemi, luku, sijamuoto);
        
        this.yksikkoMonikko = new HashMap<String, String>();
        
        this.alustaMap();
    }
    
    /**
     * Asettaa pronominin luvun oikein
     * Huomioi sen, että yleensä morfologinen ero on suuri
     */
    
    public void asetaLuku() {
        if (this.yksikkoMonikko.containsKey(lekseemi)) {
            this.sananmuoto = this.yksikkoMonikko.get(lekseemi);
            if (this.sijamuoto.equals(Sijamuoto.NOMINATIIVI)) {
                this.luku = NomininLuku.YKSIKKO;
            }
        } 
    }
    
    /**
     * Alustaa monikkojen ja yksikkojen Mapin
     */
    
    public void alustaMap() {
        String[] yksi = {"minä", "sinä", "hän", "tämä", "tuo", "se"};
        String[] moni = {"me", "te", "he", "nämä", "nuo", "ne"};
        
        for (int i = 0; i < 6; i++) {
            this.yksikkoMonikko.put(yksi[i], moni[i]);
        }
    }
    
    public HashMap getYksikkoMonikko() {
        return this.yksikkoMonikko;
    }
    
    
    @Override
    public void asetaSijamuoto() {
        this.asetaLuku();
        super.asetaSijamuoto();
    }
    
}
