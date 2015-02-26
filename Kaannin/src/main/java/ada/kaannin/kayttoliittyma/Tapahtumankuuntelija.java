/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.kayttoliittyma;

/**
 *
 * Kuuntelee käyttäjän toimintaa
 * 
 * @author adahyvarinen
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Tapahtumankuuntelija implements ActionListener {

    private JTextArea lahde;
    private JTextArea kohde;

    public Tapahtumankuuntelija(JTextArea lahde, JTextArea kohde) {
        this.lahde = lahde;
        this.kohde = kohde;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Teksti teksti = null;
        try {
            teksti = new Teksti(this.lahde.getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tapahtumankuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.kohde.setText(teksti.kaanna());
        
    }
}

