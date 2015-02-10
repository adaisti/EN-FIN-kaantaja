/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin;

import ada.kaannin.englanti.Lauseke;
import ada.kaannin.englanti.Sanakirja;
import ada.kaannin.englanti.Sanaluokka;
import ada.kaannin.englanti.SyntaksiSanakirja;
import ada.kaannin.suomi.*;

/**
 *
 * @author adahyvarinen
 */
public class Main {
    public static void main(String[] args) {
        
        Sanakirja s = new Sanakirja();
        SyntaksiSanakirja ss = new SyntaksiSanakirja();
        
        s.lisaaKaannos("holder", "apupuikko", Sanaluokka.SUBSTANTIIVI);
        
        String mahdollinenLekseemi = "holders";
        
        if (mahdollinenLekseemi.charAt(mahdollinenLekseemi.length() - 1) == 's') {
            System.out.println("loppuu s:ään");
            mahdollinenLekseemi = mahdollinenLekseemi.substring(0, mahdollinenLekseemi.length() - 1);
            System.out.println(mahdollinenLekseemi);
            if (s.sisaltaaSanan(mahdollinenLekseemi) && s.onSubstantiivi(mahdollinenLekseemi)) {
                System.out.println("oli monikko");
            }
            System.out.println("ei ollut monikko");
        }
    }
}
