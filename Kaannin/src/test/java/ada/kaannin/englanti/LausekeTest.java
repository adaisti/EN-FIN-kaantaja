/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.Persoona;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adahyvarinen
 */
public class LausekeTest {
    
    Lauseke verbilauseke;
    Lauseke verbilauseke2;
    Lauseke substantiivilauseke;
    Lauseke substantiivilauseke2;
    Sanakirja s;
    SyntaksiSanakirja ss;
    
    public LausekeTest() {
    }
    
    @Before
    public void setUp() {
        s = new Sanakirja();
        ss = new SyntaksiSanakirja();
        
        s.lisaaKaannos("knit", "neuloa", Sanaluokka.VERBI);
        s.lisaaKaannos("holder", "apupuikko", Sanaluokka.SUBSTANTIIVI);
        s.lisaaKaannos("needle", "puikko", Sanaluokka.SUBSTANTIIVI);
        s.lisaaKaannos("increase", "lisätä", Sanaluokka.VERBI);
        
        ss.alustaKaikki();
        
        verbilauseke = new Lauseke("increases", s, ss);
        verbilauseke2 = new Lauseke("knitting", s, ss);
        substantiivilauseke = new Lauseke ("on two needles", s, ss);
        substantiivilauseke2 = new Lauseke ("holders", s, ss);
        
    }

    @Test
    public void testJaaSanoiksi() {
        assertEquals("needles", substantiivilauseke.jaaSanoiksi()[2]);
    }

    @Test
    public void testAsetaLekseemiToimiiSubstantiivilausekkeella() {
        substantiivilauseke.asetaLekseemi();
        assertEquals(true, substantiivilauseke.onMonikko("needles"));
        assertEquals("needle", substantiivilauseke.lekseemi());
    }

    @Test
    public void testOnMonikko() {
        assertEquals(true, substantiivilauseke2.onMonikko("holders"));
    }


    @Test
    public void testOnVerbimuoto() {
        
    }

    @Test
    public void testVoiOllaVerbi() {
    }

    @Test
    public void testEtsiVerbipaate() {
        assertEquals("s", verbilauseke.etsiVerbipaate("increases"));
    }
    
}
