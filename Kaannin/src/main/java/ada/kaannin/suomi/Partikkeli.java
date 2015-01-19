/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.suomi;

/**
 *
 * @author adahyvarinen
 */
public class Partikkeli implements VertailumuodoissaTaipuva {

    private String lekseemi;
    private Vertailumuoto muoto;
    private String sananmuoto;
    
    public Partikkeli(String lekseemi) {
        this.lekseemi = lekseemi;
    }
    
    public Partikkeli(String lekseemi, Vertailumuoto vertailumuoto) {
        this.lekseemi = lekseemi;
        this.muoto = vertailumuoto;
    }
    
    
    @Override
    public void asetaVertailumuoto() {
        
        String alku = this.lekseemi.substring(0, this.lekseemi.length() - 5);
        
        if (this.lekseemi.substring(this.lekseemi.length() - 4, this.lekseemi.length() - 1).equals("sti")) {
            
            if (this.muoto.equals(Vertailumuoto.KOMPARATIIVI)) {
                this.sananmuoto = alku + "emmin";
            } else if (this.muoto.equals(Vertailumuoto.SUPERLATIIVI)) {
                this.sananmuoto = alku + "immin";
            }
            
        }
    
    }
    
    
    
    
    
}
