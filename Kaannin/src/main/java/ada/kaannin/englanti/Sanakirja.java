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
            // voidaan parannella myöhemmin jotenkin seuraavasti
            // ehkä ==1 aiheuttaa jänniä virheitä
//            if (this.kaannokset.keySet().size() == 1) {
//                return this.kaannokset.get(englanti);
//            }
//            else {
//                return this.parempiKaannos(englanti);
//            }
        }
        
        HashMap eiKaannosta = new HashMap<>();
        eiKaannosta.put(englanti.toUpperCase(), Sanaluokka.EISANALUOKKAA);
        return eiKaannosta;
    }
    
    public ArrayList<Sanaluokka> haeKaannoksenSanaluokka(String englanti) {
        ArrayList<Sanaluokka> tamanSanaluokat = new ArrayList<>();
        
        if (this.haeKaannos(englanti).keySet() == null) {
            return null;
        }
        
        for (String suomi : this.haeKaannos(englanti).keySet()) {
            tamanSanaluokat.add(this.suomenSanat.get(suomi));
        }
        return tamanSanaluokat;
    }
    
    public HashMap parempiKaannos(String englanti) {
        // tässä hyödynnetään predikaattitietoutta
        // ja tutkitaan kumpi kahdesta käännöksestä on parempi
        return null;
    }
    
    public boolean onSubstantiivi(String englanti) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(englanti)) {
            if (luokka.equals(Sanaluokka.SUBSTANTIIVI)) {
                return true;
            }
        }
        // huomaa if-ehdon muoto, vrt onVerbi
        return false;
    }
    
    public boolean onPronomini(String sana) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(sana)) {
            if (!luokka.equals(Sanaluokka.PRONOMINI)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean onAdjektiivi(String sana) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(sana)) {
            if (!luokka.equals(Sanaluokka.ADJEKTIIVI)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean onNumeraali(String sana) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(sana)) {
            if (!luokka.equals(Sanaluokka.NUMERAALI)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean onPartikkeli(String sana) {
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(sana)) {
            if (!luokka.equals(Sanaluokka.PARTIKKELI)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean onVerbi(String sana) {
        
        if (this.haeKaannoksenSanaluokka(sana) == null || this.haeKaannoksenSanaluokka(sana).isEmpty()) {
            return false;
        }
        
        
        // tässä forin sisäinen if-ehto on eri päin kuin muissa sanaluokissa
        // on mietittävä miksi heittää nullpointerexceptionin jos toisin päin
        // ja mitä sille voi tehdä
        for (Sanaluokka luokka : this.haeKaannoksenSanaluokka(sana)) {
            if (luokka.equals(Sanaluokka.VERBI)) {
                return true;
            }
        }
        return false;
    }
    
    
}
