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
public class SyntaksiSanakirjaTest {
    
    private SyntaksiSanakirja ss;
    
    public SyntaksiSanakirjaTest() {
    }
    
    @Before
    public void setUp() {
        ss = new SyntaksiSanakirja();
    }

    @Test
    public void testAlustaKaikki() {
        ss.alustaKaikki();
        assertEquals(true, ss.verbipaatteet().containsKey("ing"));
    }


    @Test
    public void testAlustaVerbipaatteetMappiToimii() {
        ss.alustaVerbipaatteetMappi();
        assertEquals(true, ss.verbipaatteet().containsKey("ing"));
    }

    @Test
    public void testAlustaArtikkelitSettiToimii() {
        ss.alustaArtikkelitSetti();
        assertEquals(true, ss.artikkelit().contains("the"));
    }

    @Test
    public void testAlustaPrepositiotToimii() {
        ss.alustaPrepositiotMappi();
        assertEquals(true, ss.prepositiot().containsKey("on"));
    }

    @Test
    public void testAlustaNumerotToimiiLukusanoilla() {
        ss.alustaNumerotMappi();
        assertEquals(true, ss.numerot().containsKey("3"));
    }

    @Test
    public void testAlustaNumerotToimiiNumeromerkeilla() {
        ss.alustaNumerotMappi();
        assertEquals(true, ss.numerot().containsKey("two"));
    }
    
}
