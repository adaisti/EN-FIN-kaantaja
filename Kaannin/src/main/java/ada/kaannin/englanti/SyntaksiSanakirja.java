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
 * Sanakirja, josta haetaan syntaktisia tietoja
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
    
    /**
     * Alustaa kaikki muuttujat
     */
    
    public void alustaKaikki() {
        alustaPrepositiotMappi();
        alustaNumerotMappi();
        alustaArtikkelitSetti();
        alustaVerbipaatteetMappi();
    }
    
    /**
     * Alustaa prepositiot
     */
    
    public void alustaPrepositiotMappi() {
        //testausta varten
        this.prepositiot.put("on", Sijamuoto.ALLATIIVI);
        
        // tänne tulee lista kaikista prepositiosta ja mikä Sijamuoto niihin liittyy
    }
    
    /**
     * Alustaa numerot
     */
    
    public void alustaNumerotMappi() {
        this.numerot.put("1", Sijamuoto.NOMINATIIVI);
        this.numerot.put("0", Sijamuoto.PARTITIIVI);
        
        for (int i = 2; i < 500; i++) {
            this.numerot.put(Integer.toString(i), Sijamuoto.PARTITIIVI);
        }
        
        String[] taulukko = {"zero", "two", "tree", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelwe"};
        
        for (String numero : taulukko) {
            this.numerot.put(numero, Sijamuoto.PARTITIIVI);
        }
    }
    
    /**
     * Alustaa verbipäätteet
     */
    
    public void alustaVerbipaatteetMappi() {
        this.verbipaatteet.put("ing", Persoona.INFINITIIVI);
        this.verbipaatteet.put("s", Persoona.YKS3);
        
    }
    
    /**
     * asettaa artikkelit "the", "a" ja "an" artikkeleiksi
     */
    
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
