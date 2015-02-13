/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.suomi;

/**
 *
 * @author adahyvarinen
 * 
 * Luokka käsittelee partikkeleja,
 * jotka joko eivät taivu
 * tai taipuvat vertailumuodoissa
 * 
 */
public class Partikkeli implements VertailumuodoissaTaipuva {

    private String lekseemi;
    private Vertailumuoto muoto;
    private String sananmuoto;
    
    public Partikkeli(String lekseemi) {
        this.lekseemi = lekseemi;
        this.sananmuoto = lekseemi;
        this.muoto = Vertailumuoto.POSITIIVI;
    }
    
    public Partikkeli(String lekseemi, Vertailumuoto vertailumuoto) {
        this.lekseemi = lekseemi;
        this.muoto = vertailumuoto;
        this.sananmuoto = lekseemi;
    }
    
    /**
     * jos sana taipuu vertailumuodoissa, asettaa oikein muodon, muuten ei aseta mitään
     * @return taivutettu tai taipumaton sana
     */
    
    public String sananmuoto() {
        
        if (!this.muoto.equals(Vertailumuoto.POSITIIVI)) {
            asetaVertailumuoto();
        }
        
        return this.sananmuoto;
    }
    
    /**
     * Asettaa sanamuodon oikeaan vertailumuotoon
     */
    
    
    @Override
    public void asetaVertailumuoto() {
        
        String alku = this.lekseemi.substring(0, this.lekseemi.length() - 4);
        
        if (this.lekseemi.substring(this.lekseemi.length() - 3, this.lekseemi.length()).equals("sti")) {
            
            if (this.muoto.equals(Vertailumuoto.KOMPARATIIVI)) {
                this.sananmuoto = alku + "emmin";
            } else if (this.muoto.equals(Vertailumuoto.SUPERLATIIVI)) {
                this.sananmuoto = alku + "immin";
            }
            
        }
    
    }
    
    
    
    
    
}
