/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.Persoona;
import ada.kaannin.suomi.Sijamuoto;
import java.util.ArrayList;
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
    private HashMap<String, Persoona> verbipaatteet;
    
    public SyntaksiSanakirja() {
        this.prepositiot = new HashMap<String, Sijamuoto>();
        this.numerot = new HashMap<String, Sijamuoto>();
        this.artikkelit = new HashSet<String>();
        this.verbipaatteet = new HashMap<String, Persoona>();
    }
    
    public void alustaKaikki() {
        alustaPrepositiotMappi();
        alustaNumerotMappi();
        alustaArtikkelitSetti();
        alustaVerbipaatteetMappi();
    }
    
    public void alustaPrepositiotMappi() {
        // tänne tulee lista kaikista prepositiosta ja mikä Sijamuoto niihin liittyy
    }
    
    public void alustaNumerotMappi() {
        // tänne lista numeroista ja niiden Sijamuodoista
    }
    
    public void alustaVerbipaatteetMappi() {
       
        // tänne lista siitä mitä verbipäätteitä on olemassa
        // testausta varten jo jotain lisätty
        this.verbipaatteet.put("s", Persoona.YKS1);
        // hmm jotain täytyy tehdä tolle Persoona-osiolle koska
        // se ei ole aina oleellinen
    }
    
    public void alustaArtikkelitSetti() {
        String[] artikkelitTaulukko = {"the", "a", "an"};
        for (int i = 0; i < artikkelitTaulukko.length; i++) {
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
    
    public HashMap<String, Persoona> verbipaatteet() {
        return this.verbipaatteet;
    }
    
    
    
    
}
