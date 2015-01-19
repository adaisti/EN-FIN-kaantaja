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
public class Adjektiivi extends Nomini implements VertailumuodoissaTaipuva {

    private Vertailumuoto vertailumuoto;
    
    public Adjektiivi(String lekseemi, NomininLuku luku, Sijamuoto sijamuoto, boolean astevaihtelu, Vertailumuoto vertailumuoto) {
        super(lekseemi, luku, sijamuoto, astevaihtelu);
        this.vertailumuoto = vertailumuoto;
    }

    @Override
    public void asetaVertailumuoto() {
        
        if (this.vertailumuoto.equals(Vertailumuoto.KOMPARATIIVI)) {
            if (onVokaali(Character.toString(this.lekseemi.charAt(this.lekseemi.length() - 2)))) {
                this.sananmuoto += "mpi";
            } else {
                this.sananmuoto += "empi";
            }
        } else if (this.vertailumuoto.equals(Vertailumuoto.SUPERLATIIVI)) {
            if (onVokaali(Character.toString(this.lekseemi.charAt(this.lekseemi.length() - 2)))) {
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
