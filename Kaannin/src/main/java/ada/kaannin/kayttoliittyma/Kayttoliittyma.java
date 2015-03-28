/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.kayttoliittyma;

/**
 *
 * Graafinen käyttöliittymä
 * 
 * @author adahyvarinen
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Adan kääntäjä");
        frame.setPreferredSize(new Dimension(700, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * luo käyttöliittymän kompomentit
     * 
     * @param container 
     */
    
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(4, 1);
        container.setLayout(layout);

        JTextArea textAreaVasen = new JTextArea("Tähän tulee englanninkielinen käännettävä teksti");
        JTextArea textAreaOikea = new JTextArea("Tähän tulostuu tekstin suomenkielinen käännös");
        JButton kaannaNappi = new JButton("Käännä!");
        
        JTextField englantiKentta = new JTextField();
        JTextField suomiKentta = new JTextField();
        JTextField sanaluokkaKentta = new JTextField();
        JButton lisaysNappi = new JButton("Lisää uusi käännös sanakirjaan!");
        
        textAreaVasen.setLineWrap(true);
        textAreaOikea.setLineWrap(true);
        
        Tapahtumankuuntelija kuuntelija = new Tapahtumankuuntelija(textAreaVasen, textAreaOikea);
        kaannaNappi.addActionListener(kuuntelija);
        LisaysTapahtumankuuntelija toinen = new LisaysTapahtumankuuntelija(englantiKentta, suomiKentta, sanaluokkaKentta);
        lisaysNappi.addActionListener(toinen);

        container.add(textAreaVasen);
        container.add(kaannaNappi);
        container.add(textAreaOikea);
        container.add(luoValikko(englantiKentta, suomiKentta, sanaluokkaKentta, lisaysNappi));
    }
    
    /**
     * Luo lisäysvalikon paneelin
     * @param englantiKentta
     * @param suomiKentta
     * @param sanaluokkaKentta
     * @param lisaysNappi
     * @return paneeli
     */
    
    public JPanel luoValikko(JTextField englantiKentta, JTextField suomiKentta, JTextField sanaluokkaKentta, JButton lisaysNappi) {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(5, 2);
        panel.setLayout(layout);

        
        JLabel englantiTeksti = new JLabel("Englanninkielinen sana (esim. needle): ");
        JLabel suomiTeksti = new JLabel("Suomenkielinen käännös (esim. neulepuikko): ");
        JLabel sanaluokkaTeksti = new JLabel("Sanaluokka (esim. substantiivi):");
        

        panel.add(new JLabel("Lisää tässä omia käännöksiä sanakirjaan"));
        panel.add(new JLabel(""));
        panel.add(englantiTeksti);
        panel.add(englantiKentta);
        panel.add(suomiTeksti);
        panel.add(suomiKentta);
        panel.add(sanaluokkaTeksti);
        panel.add(sanaluokkaKentta);
        panel.add(new JLabel(""));
        panel.add(lisaysNappi);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}