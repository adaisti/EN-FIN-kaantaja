/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import java.util.ArrayList;

/**
 *
 * @author adahyvarinen
 */
public class Lause {
    
    String teksti;
    ArrayList<String> lausekkeet;
    SyntaksiSanakirja ss;
    
    public Lause(SyntaksiSanakirja syntaksisanakirja, String teksti) {
        this.ss = syntaksisanakirja;
        this.teksti = teksti;
    }
    
    public void jaaLausekkeiksi() {
        
        String[] osat = this.jaaSanoiksi();
        String lauseke;
        int i = 0;
        
        while(i < osat.length) {
            lauseke = osat[i];
            while (onPrepositio(osat[i]) || onNumero(osat[i]) || onArtikkeli(osat[i])) {
                i++;
                lauseke += osat[i];
            }
            this.lausekkeet.add(lauseke);
            i++;
        }
    }
    
    // nämä jaotellut "esipaistetut" lausekkeet pitäisi varmaan laittaa johonkin
    // ja hyödyntää niitä siellä
    
    public ArrayList<String> lausekkeet() {
        return this.lausekkeet;
    }
    
    // Tämä metodi saattaa olla turha
    
//    public int laskeValilyonnit() {
//        int valilyonteja = 0;
//        for (int i = 0; i < 10; i++) {
//            if (this.teksti.charAt(i) == ' ') {
//                valilyonteja++;
//            }
//        }
//        return valilyonteja;
//    }
    
    public String[] jaaSanoiksi() {
        String[] osat = this.teksti.split(" ");
        return osat;
    }
    
    
    
    public boolean onPrepositio(String sana) {
        if (ss.prepositiot().keySet().contains(sana)) {
            return true;
        }
        return false;
    }
    
    public boolean onNumero(String sana) {
        if (ss.numerot().keySet().contains(sana)){
            return true;
        }
        return false;
    }
    
    public boolean onArtikkeli(String sana) {
        if (ss.artikkelit().contains(sana)) {
            return true;
        }
        return false;
    }
    
    
}
