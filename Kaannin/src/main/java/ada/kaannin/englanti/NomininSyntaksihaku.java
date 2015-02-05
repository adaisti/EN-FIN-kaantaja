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
    
    
    // WTF täytyy tehdä tälle luokalle jotain
    

    public Sijamuoto sijamuoto() {
        
        if (onPrepositiolauseke()) {
            haePrepositiolla();
        } else if (this.numero != 0) {
            haeNumerolla();
        }
        
        return this.sijamuoto;
    }
    
    public void haePrepositiolla() {
        this.sijamuoto = this.prepositiot.get(this.prepositio);
    }
    
    public void haeNumerolla() {
        
        if (onPrepositiolauseke()) {
            this.haePrepositiolla();
        }
       
        if (this.numero == 1) {
            this.sijamuoto = Sijamuoto.NOMINATIIVI;
        } else {
            this.sijamuoto = Sijamuoto.PARTITIIVI;
        }
        this.luku = NomininLuku.YKSIKKO;
    }
    
    
    
    public boolean onPrepositiolauseke() {
        
        if (this.prepositiot.containsKey(this.ekasana)) {
            return true;
        }
        
        return false;
    }
    
    
    
}
