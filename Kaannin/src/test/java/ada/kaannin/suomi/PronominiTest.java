/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.suomi;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adahyvarinen
 */
public class PronominiTest {
    
    public PronominiTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testAsetaLukuHuomioiPoikkeukset() {
        Pronomini sana = new Pronomini("tämä", NomininLuku.MONIKKO, Sijamuoto.NOMINATIIVI, false);
        assertEquals("nämä", sana.sananmuoto());
    }
    
    @Test
    public void testAsetaLukuJattaaHuomiottaNormaalit() {
        Pronomini sana = new Pronomini("muu", NomininLuku.MONIKKO, Sijamuoto.NOMINATIIVI, false);
        assertEquals("muut", sana.sananmuoto());
    }

    @Test
    public void testAlustaMapAlustetaaOikein() {
        Pronomini sana = new Pronomini("minä", NomininLuku.MONIKKO, Sijamuoto.NOMINATIIVI, false);
        assertEquals("me", sana.getYksikkoMonikko().get("minä"));
    }

    @Test
    public void testAsetaSijamuotoOsaaSijamuotoja() {
        Pronomini sana = new Pronomini("minä", NomininLuku.MONIKKO, Sijamuoto.ADESSIIVI, false);
        assertEquals("meillä", sana.sananmuoto());
    }
    
}
