/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.NomininLuku;
import ada.kaannin.suomi.Sijamuoto;
import java.util.HashMap;

/**
 *
 * Luokka palauttaa nomineille ominaisia syntaktisia ilmentymiä hakujen perusteella
 * 
 * @author adahyvarinen
 */
public class NomininSyntaksihaku {
    
    private HashMap<String, Sijamuoto> prepositiot;
    private Sijamuoto sijamuoto;
    private NomininLuku luku;
    private String ekasana;
    private String prepositio;
    private int numero;
    
    public NomininSyntaksihaku(SyntaksiSanakirja syntaksisanakirja, String lauseke) {
        this.prepositiot = syntaksisanakirja.prepositiot();
        this.sijamuoto = Sijamuoto.NOMINATIIVI;
        this.luku = NomininLuku.YKSIKKO;
        this.ekasana = "";
        this.prepositio = "";
        this.numero = 0;
    }
    
    /**
     * Metodi tutkii mikä saneen luku on
     * 
     * @param onMonikko
     * @return monikko, jos sana on monikossa, muuten yksikkö
     */
    
    public NomininLuku luku(boolean onMonikko) {
        if (onMonikko) {
            return NomininLuku.MONIKKO;
        }
        return NomininLuku.YKSIKKO;
    }
    
    /**
     * Etsii nominiin liittyvän sijamuodon muiden lausekkeen sanojen perusteella
     * 
     * @return Sijamuoto
     */

    public Sijamuoto sijamuoto() {
        
        if (onPrepositiolauseke()) {
            haePrepositiolla();
        } else if (this.numero != 0) {
            haeNumerolla();
        }
        
        return this.sijamuoto;
    }
    
    /**
     * etsii prepositioon liittyvän sijamuodon
     */
    
    public void haePrepositiolla() {
        if (this.prepositiot.get(this.prepositio) == null) {
            return;
        }
        
        this.sijamuoto = this.prepositiot.get(this.prepositio);
    }
    
    /**
     * etsii lukusanaan liittyvän sijamuodon
     * 
     */
    public void haeNumerolla() {
        
        if (this.numero == 1) {
            this.sijamuoto = Sijamuoto.NOMINATIIVI;
        } else {
            this.sijamuoto = Sijamuoto.PARTITIIVI;
        }
        this.luku = NomininLuku.YKSIKKO;
    }
    
    /**
     * tutkii onko jokin lauseke prepositiolauseke
     * 
     * @return true jos on prepositiolauseke
     */
    
    public boolean onPrepositiolauseke() {
        
        if (this.prepositiot.containsKey(this.ekasana)) {
            return true;
        }
        
        return false;
    }
    
    
    public Sijamuoto getSijamuoto() {
        return this.sijamuoto;
    }
    
    
}
