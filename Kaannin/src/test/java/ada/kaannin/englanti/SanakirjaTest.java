/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adahyvarinen
 */
public class SanakirjaTest {
    
    Sanakirja s;
    
    public SanakirjaTest() {
        
        
    }
    
    @Before
    public void setUp() {
        s = new Sanakirja();
        s.lisaaKaannos("small", "pieni", Sanaluokka.ADJEKTIIVI);
        s.lisaaKaannos("two", "kaksi", Sanaluokka.NUMERAALI);
        s.lisaaKaannos("and", "ja", Sanaluokka.PARTIKKELI);
        s.lisaaKaannos("you", "sinä", Sanaluokka.PRONOMINI);
        s.lisaaKaannos("knit", "neuloa", Sanaluokka.VERBI);
        s.lisaaKaannos("needle", "neulepuikko", Sanaluokka.SUBSTANTIIVI);
    }

    @Test
    public void testSisaltaaSanan() {
        assertEquals(true, s.sisaltaaSanan("knit"));
    }


    @Test
    public void testHaeKaannos() {
        HashMap<String, Sanaluokka> neuloa= new HashMap<>();
        neuloa.put("neuloa", Sanaluokka.VERBI);
        assertEquals(neuloa, s.haeKaannos("knit"));
    }

    @Test
    public void testHaeKaannoksenSanaluokkaHakeeOlemassaOlevanSananSanaluokan() {
        assertEquals(Sanaluokka.VERBI, s.haeKaannoksenSanaluokka("knit").get(0));
    }
    
    @Test
    public void testHaeKaannoksenSanaluokkaHakeeOlemassaPuuttuvanSananSanaluokan() {
        assertEquals(Sanaluokka.EISANALUOKKAA, s.haeKaannoksenSanaluokka("lepakko").get(0));
    }

    @Test
    public void testOnSubstantiivi() {
        assertEquals(true, s.onSubstantiivi("needle"));
    }

    @Test
    public void testOnPronomini() {
        assertEquals(true, s.onPronomini("you"));
    }

    @Test
    public void testOnAdjektiiviTunnistaaOikeanAdjektiivin() {
        assertEquals(true, s.onAdjektiivi("small"));
    }
    
    @Test
    public void testOnAdjektiiviTunnistaaEtteiOleAdjektiivi() {
        assertEquals(false, s.onAdjektiivi("two"));
    }

    @Test
    public void testOnNumeraaliTunnistaaOikeanNumeraalin() {
        assertEquals(true, s.onNumeraali("two"));
    }

    @Test
    public void testOnNumeraaliTunnistaaVaaranNumeraalin() {
        assertEquals(false, s.onNumeraali("small"));
    }
    
    @Test
    public void testOnPartikkeli() {
        assertEquals(true, s.onPartikkeli("and"));
    }

    @Test
    public void testOnVerbi() {
        assertEquals(true, s.onVerbi("knit"));
    }
    
}
