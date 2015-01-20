/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin;

import ada.kaannin.suomi.*;

/**
 *
 * @author adahyvarinen
 */
public class Main {
    public static void main(String[] args) {
        
        Substantiivi sana = new Substantiivi("kukka", NomininLuku.MONIKKO, Sijamuoto.PARTITIIVI, true);
        System.out.println(sana.sananmuoto());
        
        Pronomini toinen = new Pronomini("minä", NomininLuku.MONIKKO, Sijamuoto.ADESSIIVI, false);
        
        System.out.println(toinen.sananmuoto());
    }
}
