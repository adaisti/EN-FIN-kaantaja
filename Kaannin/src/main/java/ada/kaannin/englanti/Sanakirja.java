/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author adahyvarinen
 */
public class Sanakirja {
    
    HashMap<String, HashMap> kaannokset;
    HashMap<String, Sanaluokka> suomenSanat;

    public Sanakirja() {
        this.kaannokset = new HashMap<String, HashMap>();
        this.suomenSanat= new HashMap<String, Sanaluokka>();
    }
    
    public void lisaaKaannos(String englanti, String suomi, Sanaluokka sanaluokka) {
        this.suomenSanat.put(suomi, sanaluokka);
        this.kaannokset.put(suomi, suomenSanat);
    }
    
    public HashMap<String, Sanaluokka> haeKaannos(String englanti) {
        if (this.kaannokset.containsKey(englanti)) {
            if (this.kaannokset.keySet().size() == 1) {
                return this.kaannokset.get(englanti);
            }
            else {
                return this.parempiKaannos(englanti);
            }
        }
        
        HashMap eiKaannosta = new HashMap<String, Sanaluokka>();
        eiKaannosta.put(englanti.toUpperCase(), Sanaluokka.EISANALUOKKAA);
        return eiKaannosta;
    }
    
    public HashMap parempiKaannos(String englanti) {
        // tässä hyödynnetään predikaattitietoutta
        // ja tutkitaan kumpi kahdesta käännöksestä on parempi
        return null;
    }
    
}
