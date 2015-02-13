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
import javax.swing.JTextArea;

public class Tapahtumankuuntelija implements ActionListener {

    private JTextArea lahde;
    private JTextArea kohde;
    private Teksti lukija;

    public Tapahtumankuuntelija(Teksti lukija, JTextArea lahde, JTextArea kohde) {
        this.lahde = lahde;
        this.kohde = kohde;
        this.lukija = lukija;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.kohde.setText(this.lahde.getText());
        // tällä hetkellä vain kopioi tekstin
        // pitää muuttaa niin että käännetään lahde.getText();
    }
}

