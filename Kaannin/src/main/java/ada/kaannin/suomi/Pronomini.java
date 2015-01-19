/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.suomi;

import java.util.ArrayList;

/**
 *
 * @author adahyvarinen
 */
public class Pronomini extends Nomini {
    
    private ArrayList<String> yksikossa;
    private ArrayList<String> monikossa;
    
    
    public Pronomini(String lekseemi, NomininLuku luku, Sijamuoto sijamuoto, boolean astevaihtelu) {
        super(lekseemi, luku, sijamuoto, astevaihtelu);
        
        this.yksikossa = new ArrayList<String>();
        this.monikossa = new ArrayList<String>();
        
        this.alustaListat();
    }
    
    public void asetaLuku() {
        if (this.yksikossa.contains(this.lekseemi) && this.luku == NomininLuku.MONIKKO) {
            this.sananmuoto = this.monikossa.get(this.yksikossa.indexOf(this.lekseemi));
        }  
    }
    
    public void alustaListat() {
        String[] yksi = {"minä", "sinä", "hän", "tämä", "tuo", "se"};
        String[] moni = {"me", "te", "he", "nämä", "nuo", "ne"};
        
        for (int i = 0; i < 10; i++) {
            this.yksikossa.add(yksi[i]);
            this.monikossa.add(moni[i]);
        }
    }
    
    
}
