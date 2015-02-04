/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.Sijamuoto;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author adahyvarinen
 */
public class SyntaksiSanakirja {
    
    private HashMap<String, Sijamuoto> prepositiot;
    private HashMap<String, Sijamuoto> numerot;
    private HashSet<String> artikkelit;
    
    public SyntaksiSanakirja() {
        this.prepositiot = new HashMap<String, Sijamuoto>();
        this.numerot = new HashMap<String, Sijamuoto>();
        this.artikkelit = new HashSet<String>();
    }
    
    public void alustaPrepositiotMappi() {
        // tänne tulee lista kaikista prepositiosta ja mikä Sijamuoto niihin liittyy
    }
    
    public void alustaNumerotMappi() {
        // tänne lista numeroista ja niiden Sijamuodoista
    }
    
    public void alustaArtikkelitSetti() {
        String[] artikkelitTaulukko = {"the", "a", "an"};
        for (int i = 0; i < 10; i++) {
            this.artikkelit.add(artikkelitTaulukko[i]);
        }
    }
    
    public HashMap<String, Sijamuoto> prepositiot() {
        return this.prepositiot;
    }
    
    public HashMap<String, Sijamuoto> numerot() {
        return this.numerot;
    }
    
    public HashSet<String> artikkelit() {
        return this.artikkelit;
    }
    
    
    
}
