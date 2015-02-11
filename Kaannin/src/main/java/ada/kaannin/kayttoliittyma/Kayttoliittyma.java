/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.kayttoliittyma;

/**
 *
 * @author adahyvarinen
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Adan kääntäjä");
        frame.setPreferredSize(new Dimension(500, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        JTextArea textAreaVasen = new JTextArea("Tähän tulee englanninkielinen teksti");
        JTextArea textAreaOikea = new JTextArea();
        JButton kaannaNappi = new JButton("Käännä");
        
        textAreaVasen.setLineWrap(true);
        textAreaOikea.setLineWrap(true);
        
        Tapahtumankuuntelija kuuntelija = new Tapahtumankuuntelija(textAreaVasen, textAreaOikea);
        kaannaNappi.addActionListener(kuuntelija);


        container.add(textAreaVasen);
        container.add(kaannaNappi);
        container.add(textAreaOikea);
    }

    public JFrame getFrame() {
        return frame;
    }
}