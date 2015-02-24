/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * Luokan tarkoituksena on kontrolloida sanakirjoja ja muuta hakemistoa
 * 
 * @author adahyvarinen
 */
public class Hakemistonhallinta {
    
    private Sanakirja s;
    private SyntaksiSanakirja ss;
    
    public Hakemistonhallinta() throws FileNotFoundException {
        this.s = new Sanakirja();
        this.ss = new SyntaksiSanakirja();
        alustaSanakirjat();
    }
    
    
    public void alustaSanakirja() throws FileNotFoundException {
        Scanner tiedostonlukija = new Scanner(new File("src/main/resources/sanat.txt"));

        while(tiedostonlukija.hasNextLine()) {
            String rivi = tiedostonlukija.nextLine();
            String[] osat = rivi.split(" ");

            if (osat.length >= 3) {
                Sanaluokka luokka = Sanaluokka.EISANALUOKKAA;
                
                switch (osat[osat.length - 1]) {
                    case "s": 
                        luokka = Sanaluokka.SUBSTANTIIVI;
                        break;
                    case "a": 
                        luokka = Sanaluokka.ADJEKTIIVI;
                        break;
                    case "n": 
                        luokka = Sanaluokka.NUMERAALI;
                        break;
                    case "pr": 
                        luokka = Sanaluokka.PRONOMINI;
                        break;
                    case "pa": 
                        luokka = Sanaluokka.PARTIKKELI;
                        break;
                    case "v": 
                        luokka = Sanaluokka.VERBI;
                        break;
                }
                String englanti = "";
                
                for (int i = 0; i < osat.length - 2; i++) {
                    englanti += osat[i];
                }
                s.lisaaKaannos(englanti, osat[osat.length - 2], luokka);
            }
        }
    }
    
    public void alustaSanakirjat() throws FileNotFoundException {
        ss.alustaKaikki();
        alustaSanakirja();
    }
    
    public Sanakirja s() {
        return this.s;
    }
    
    public SyntaksiSanakirja ss() {
        return this.ss;
    }
}
