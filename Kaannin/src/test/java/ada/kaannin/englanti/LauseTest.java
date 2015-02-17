/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adahyvarinen
 */
public class LauseTest {
    
    SyntaksiSanakirja ss;
    Sanakirja s;
    Lause lause;
    
    public LauseTest() {
    }
    
    @Before
    public void setUp() {
        ss = new SyntaksiSanakirja();
        s = new Sanakirja();
        
        ss.alustaKaikki();
        
        lause = new Lause(ss, s, "create 42 sts on two needles");
    }

    @Test
    public void testJaaLausekkeiksiRajaaOikeinLukusanan() {
        lause.jaaLausekkeiksi();
        assertEquals("create", lause.lausekkeet().get(0).toString());
    }
    
    @Test
    public void testJaaLausekkeiksiRajaaPreposition() {
        lause.jaaLausekkeiksi();
        assertEquals("42 sts", lause.lausekkeet().get(1).toString());
    }

    @Test
    public void testJaaSanoiksi() {
        assertEquals("sts", lause.jaaSanoiksi()[2]);
    }

    @Test
    public void testOnLausekkeenLoppuHuomaaEtteiLopu() {
        assertEquals(false, lause.onLausekkeenLoppu("the"));
    }
    
    @Test
    public void testOnLausekkeenLoppuHuomaaEttaLoppuu() {
        assertEquals(true, lause.onLausekkeenLoppu("needle"));
    }
    
    @Test
    public void testOnPrepositioTunnistaaOikean() {
        assertEquals(true, lause.onPrepositio("on"));
    }
    
    @Test
    public void testOnPrepositioTunnistaaVaaran() {
        assertEquals(false, lause.onPrepositio("needle"));
    }

    @Test
    public void testOnNumeroTunnistaaOikean() {
        assertEquals(true, lause.onNumero("42"));
    }

    @Test
    public void testOnNumeroTunnistaaVaaran() {
        assertEquals(false, lause.onNumero("needle"));
    }
    
    @Test
    public void testOnArtikkeliTunnistaaOikean() {
        assertEquals(true, lause.onArtikkeli("the"));
    }
    
    @Test
    public void testOnArtikkeliTunnistaaVaaran() {
        assertEquals(false, lause.onArtikkeli("needle"));
    }
}
