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
        
        lause = new Lause(ss, s, "create 42 sts on two needles");
    }

    @Test
    public void testJaaLausekkeiksi() {
    }

    @Test
    public void testLausekkeet() {
    }

    @Test
    public void testJaaSanoiksi() {
    }

    @Test
    public void testOnLausekkeenLoppuHuomaaEtteiLopu() {
        assertEquals(true, lause.onLausekkeenLoppu("the"));
    }
    
    @Test
    public void testOnLausekkeenLoppuHuomaaEttaLoppuu() {
        assertEquals(true, lause.onLausekkeenLoppu("needle"));
    }
    

    @Test
    public void testOnPrepositio() {
    }

    @Test
    public void testOnNumero() {
    }

    @Test
    public void testOnArtikkeli() {
    }
    
}
