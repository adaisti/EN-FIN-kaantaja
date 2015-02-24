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
 * Luokka etsii tunnettuja sanoja ja tietää lisäksi niiden suomenkieliset vastineet
 * ja sanaluokat
 * 
 * Tässä versiossa sanan käännös on yksikäsitteinen, vaikka oikeasti näin ei aina ole
 * 
 * @author adahyvarinen
 */
public class Sanakirja {
    
    private HashMap<String, HashMap> kaannokset;

    public Sanakirja() {
        this.kaannokset = new HashMap<String, HashMap>();
    }
    
    /**
     * Tutkii onko sana sanakirjassa
     * 
     * @param englanti
     * @return true jos sana on sanakirjassa
     */
    
    public boolean sisaltaaSanan(String englanti) {
        if (this.kaannokset.containsKey(englanti)) {
            return true;
        }
        return false;
    }
    
    /**
     * Lisää käännöksen sanakirjaan
     * 
     * @param englanti
     * @param suomi
     * @param sanaluokka 
     */
    
    public void lisaaKaannos(String englanti, String suomi, Sanaluokka sanaluokka) {
        HashMap<String, Sanaluokka> suomenSanat = new HashMap<String, Sanaluokka>();
        suomenSanat.put(suomi, sanaluokka);
        this.kaannokset.put(englanti, suomenSanat);
    }
    
    /**
     * Etsii sanakirjassa olevan sanan käännöksen
     * 
     * 
     * @param englanti
     * @return HashMap, jossa on suomen sana ja sanaluokka, tai englannin sana isoilla kirjaimilla
     */
    
    public HashMap<String, Sanaluokka> haeKaannos(String englanti) {
        if (this.kaannokset.containsKey(englanti.toLowerCase())) {
            return this.kaannokset.get(englanti.toLowerCase());
        }

        HashMap<String, Sanaluokka> eiKaannosta = new HashMap<>();
        eiKaannosta.put(englanti.toUpperCase(), Sanaluokka.EISANALUOKKAA);
        return eiKaannosta;
    }
    
    /**
     * etsii sanaluokan englanninkieliselle sanalle
     * 
     * @param englanti
     * @return Sanaluokka
     */
    
    public ArrayList<Sanaluokka> haeKaannoksenSanaluokka(String englanti) {
        ArrayList tamanSanaluokat = new ArrayList<Sanaluokka>();
        if (!sisaltaaSanan(englanti)) {
            tamanSanaluokat.add(Sanaluokka.EISANALUOKKAA);
        } else {
            for (String suomi : this.haeKaannos(englanti).keySet()) {
                tamanSanaluokat.add(this.kaannokset.get(englanti).get(suomi));
            }
        }
        return tamanSanaluokat;
    }
    
    /**
     * Metodi kertoo onko joku englannin sana substantiivi
     * 
     * @param englanti
     * @return true, jos sana on Substantiivi
     */
    
    public boolean onSubstantiivi(String englanti) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(englanti)) {
            if (luokka.equals(Sanaluokka.SUBSTANTIIVI)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi kertoo onko joku englannin sana pronomini
     * 
     * @param englanti
     * @return true, jos sana on pronomini
     */
    
    public boolean onPronomini(String englanti) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(englanti)) {
            if (luokka.equals(Sanaluokka.PRONOMINI)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi kertoo onko joku englannin sana adjektiivi
     * 
     * @param englanti
     * @return true, jos sana on adjektiivi
     */
    
    public boolean onAdjektiivi(String englanti) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(englanti)) {
            if (luokka.equals(Sanaluokka.ADJEKTIIVI)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi kertoo onko joku englannin sana numeraali
     * 
     * @param englanti
     * @return true, jos sana on numeraali
     */
    
    public boolean onNumeraali(String englanti) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(englanti)) {
            if (luokka.equals(Sanaluokka.NUMERAALI)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi kertoo onko joku englannin sana partikkeli
     * 
     * @param englanti
     * @return true, jos sana on partikkeli
     */
    
    public boolean onPartikkeli(String englanti) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(englanti)) {
            if (luokka.equals(Sanaluokka.PARTIKKELI)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodi kertoo onko joku englannin sana verbi
     * 
     * @param englanti
     * @return true, jos sana on verbi
     */
    
    public boolean onVerbi(String englanti) {
        
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(englanti)) {
            if (luokka.equals(Sanaluokka.VERBI)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Tutkii onko joku sana adverbi
     * @param englanti
     * @return true, jos on adverbi
     */
    
    public boolean onAdverbi(String englanti) {
        if ((englanti.substring(englanti.length() - 2)).equals("ly") && this.onPartikkeli(englanti)) {
            return true;
        }
        return false;
    }
    
    
    
}
