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
        
        // kommentoitu piiloon tiedostonluku ja tehty sen sijaan palikkaratkaisu,
        // jossa sanat on syötetty käsin, jottei tiedostopolku estäisi ohjelman käyttämistä
        // laitoksen koneilla
        
//        Scanner tiedostonlukija = new Scanner(new File("src/main/resources/sanat.txt"));
//
//        while(tiedostonlukija.hasNextLine()) {
//            String rivi = tiedostonlukija.nextLine();
        
        for (int j = 0; j < this.syote().length; j++) {
            
            String rivi = this.syote()[j];
            
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
    
    public String[] syote() {
        String[] syote = {"alternatively vaihtoehtoisesti pa", "approximately noin pa", "beginning alku s", "between välissä pa", "back takareuna s", "loop silmukka s", "bind off päättele v", "colour väri s", "contrasting vastakkainen a", "cast on luoda v", "decrease kaventaa v", "front etureuna s", "following seuraava a", "increase lisätä v", "knit neuloa v", "together yhdessä pa", "cable palmikko s", "twist kierto s", "right oikea pa", "left vasen pa", "make tehdä v", "pick up poimia v", "and ja pa", "main colour pääväri s", "measure mitta s", "measurement mitta s", "place marker silmukkamerkki s", "previous edellinen pa", "pass over siirtää v", "stitch silmukka s", "st silmukka s", "purl nurinneuloa v", "remaining jäljelläoleva s", "repeat toistaa v", "side puoli s", "skip ohittaa v", "slip nostaa v", "through kautta pa", "wrong nurja a", "turn kääntää v", "work neuletyö s", "wrap langankierto s", "yarn lanka s", "round pyöreä a", "round needle pyöröpuikko s", "yarn lanka s", "skein lankakerä s", "ball lankakerä s", "hank lankavyyhti s", "stash varasto s", "darning ompeluneula s", "double pointed needle sukkapuikko s", "cable needle apupuikko s", "cable stitch holder palmikkopuikko s", "circular needle pyöröpuikko s", "pattern kaava s", "chart mallikuvio s", "motif mallikerta s", "stitch marker silmukkamerkki s", "ring marker silmukkamerkki s", "gauge mittari s", "flat taso s", "row kerros s", "bobble nyppy s", "bind off päätellä v", "continue jatkaa s", "break katkaista v", "edge reuna s", "selvage reuna s", "steek saumavara s", "swatch mallitilkku s", "tension neuletiheys s", "garter stitch edestaikaisneule s", "panel palmikkorakenne s", "rib joustinneule s", "ribbing joustinneule s", "lace pitsi s", "fair isle kuvioneule s", "and ja pa", "or tai pa", "you sinä pr", "can voida v", "one yksi n", "two kaksi n", "tree kolme n", "four neljä n", "five viisi n", "six kuusi n", "seven seitsemän n", "eigth kahdeksan n", "nine yhdeksän n", "ten kymmenen n", "eleven yksitoista n", "twelwe kaksitoista n", "again uudestaan pa", "move siirtää v", "needle neulepuikko s"};
        return syote;
    }
    
    
}
