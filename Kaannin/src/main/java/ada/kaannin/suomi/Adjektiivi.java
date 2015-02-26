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
 * Luokka käsittelee adjektiiveja
 * joita voidaan taivuttaa sijamuodoissa Nomini-luokan metodeilla
 * sekä vertailumuodoissa
 */



public class Adjektiivi extends Nomini implements VertailumuodoissaTaipuva {

    private Vertailumuoto vertailumuoto;
    
    public Adjektiivi(String lekseemi, NomininLuku luku, Sijamuoto sijamuoto, Vertailumuoto vertailumuoto) {
        super(lekseemi, luku, sijamuoto);
        this.vertailumuoto = vertailumuoto;
    }

    /*
    * Toteuttaa VertailumuodoissaTaipuva-rajapinnan
    * Asettaa sananmuodon oikeaan vertailumuotoon
    * 
    */
    
    @Override
    public void asetaVertailumuoto() {
        
        if (this.vertailumuoto.equals(Vertailumuoto.KOMPARATIIVI)) {
            if (onVokaali(Character.toString(this.sananmuoto.charAt(this.sananmuoto.length() - 1)))) {
                this.sananmuoto += "mpi";
            } else {
                this.sananmuoto += "empi";
            }
            this.astevaihtelu = true;
        } else if (this.vertailumuoto.equals(Vertailumuoto.SUPERLATIIVI)) {
            if (onVokaali(Character.toString(this.sananmuoto.charAt(this.sananmuoto.length() - 1)))) {
                this.sananmuoto += "n";
            } else {
                this.sananmuoto += "in";
            }
        } 
    }
    
    @Override
    public String sananmuoto() {
        this.asetaVertailumuoto();
        super.asetaSijamuoto();
        return this.sananmuoto;
    }
    
}
