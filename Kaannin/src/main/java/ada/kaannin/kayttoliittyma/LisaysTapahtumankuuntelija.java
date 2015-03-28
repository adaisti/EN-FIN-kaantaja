/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.kayttoliittyma;

import ada.kaannin.englanti.Hakemistonhallinta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * Luokka käsittelee sananlisäysnapin tapahtumia
 * 
 * @author Ada
 */
public class LisaysTapahtumankuuntelija implements ActionListener {
    
    private JTextField englanti;
    private JTextField suomi;
    private JTextField sanaluokka;
    
    public LisaysTapahtumankuuntelija(JTextField englantiTeksti, JTextField suomiTeksti, JTextField sanaluokkaTeksti) {
        this.englanti = englantiTeksti;
        this.suomi = suomiTeksti;
        this.sanaluokka = sanaluokkaTeksti;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            Hakemistonhallinta hh = new Hakemistonhallinta();
            hh.lisaaKaannosSanakirjaan(this.englanti.getText(), this.suomi.getText(), this.sanaluokka.getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LisaysTapahtumankuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LisaysTapahtumankuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.englanti.setText("");
        this.suomi.setText("");
        this.sanaluokka.setText("");
    }
    
}
