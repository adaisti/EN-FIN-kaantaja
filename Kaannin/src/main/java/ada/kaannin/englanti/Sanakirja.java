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
    
    private HashMap<String, HashMap> kaannokset;
    private HashMap<String, Sanaluokka> suomenSanat;

    public Sanakirja() {
        this.kaannokset = new HashMap<String, HashMap>();
        this.suomenSanat= new HashMap<String, Sanaluokka>();
    }
    
    public boolean sisaltaaSanan(String englanti) {
        if (this.kaannokset.containsKey(englanti)) {
            return true;
        }
        return false;
    }
    
    public void lisaaKaannos(String englanti, String suomi, Sanaluokka sanaluokka) {
        this.suomenSanat.put(suomi, sanaluokka);
        this.kaannokset.put(englanti, suomenSanat);
    }
    
    public HashMap<String, Sanaluokka> haeKaannos(String englanti) {
        if (this.kaannokset.containsKey(englanti)) {
            return this.kaannokset.get(englanti);
        }
        
        HashMap eiKaannosta = new HashMap<>();
        eiKaannosta.put(englanti.toUpperCase(), Sanaluokka.EISANALUOKKAA);
        return eiKaannosta;
    }
    
    public ArrayList<Sanaluokka> haeKaannoksenSanaluokka(String englanti) {
        ArrayList<Sanaluokka> tamanSanaluokat = new ArrayList<>();
        
        if (this.haeKaannos(englanti).keySet() == null) {
            tamanSanaluokat.add(Sanaluokka.EISANALUOKKAA);
            return tamanSanaluokat;
        }
        
        for (String suomi : this.haeKaannos(englanti).keySet()) {
            tamanSanaluokat.add(this.suomenSanat.get(suomi));
        }
        return tamanSanaluokat;
    }
    
    public boolean onSubstantiivi(String englanti) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(englanti)) {
            if (luokka.equals(Sanaluokka.SUBSTANTIIVI)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean onPronomini(String sana) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(sana)) {
            if (luokka.equals(Sanaluokka.PRONOMINI)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean onAdjektiivi(String sana) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(sana)) {
            if (luokka.equals(Sanaluokka.ADJEKTIIVI)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean onNumeraali(String sana) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(sana)) {
            if (luokka.equals(Sanaluokka.NUMERAALI)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean onPartikkeli(String sana) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(sana)) {
            if (!luokka.equals(Sanaluokka.PARTIKKELI)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean onVerbi(String sana) {
        final ArrayList<Sanaluokka> haeKaannoksenSanaluokka = this.haeKaannoksenSanaluokka(sana);
        
        // en ole varma onko tästä mitään iloa mutta olkoon nyt toistaiseksi siinä
        if (haeKaannoksenSanaluokka == null || haeKaannoksenSanaluokka.isEmpty()) {
            return false;
        }
       
        // huomaa if-ehdon ja boolean-palautuksen suunta
        System.out.println(haeKaannoksenSanaluokka);
        for (Sanaluokka luokka : haeKaannoksenSanaluokka) {
            if (luokka.equals(Sanaluokka.VERBI)) {
                return true;
            }
        }
        return false;
    }
    
    
}
