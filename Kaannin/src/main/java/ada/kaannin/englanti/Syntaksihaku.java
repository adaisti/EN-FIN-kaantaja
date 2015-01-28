/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.Sijamuoto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author adahyvarinen
 */
public class Syntaksihaku {
    
    HashMap<String, Sijamuoto> prepositiot;
    
    public Syntaksihaku() {
        this.prepositiot = new HashMap<String, Sijamuoto>();
    }
    
    public void lisaaPrepositio(String englanti, Sijamuoto sijamuoto) {
        this.prepositiot.put(englanti, sijamuoto);
    }
    
    public Sijamuoto haePrepositiolla(String englanti) {
        return this.prepositiot.get(englanti);
    }
    
    public Sijamuoto haeLuvulla(int luku) {
        
        // pitää tarkistaa ettei tässä kohtaa
        // käsitellä esim tilannetta "kahdelle puikolle"
        // vaan esim tilannetta "4 silmukkaa"
        // miten?
        
        if (luku == 1) {
            return Sijamuoto.NOMINATIIVI;
        } else {
            return Sijamuoto.PARTITIIVI;
        }
        // NomininLuku pitää olla yksikkö
    }
    
    
    
    
}
