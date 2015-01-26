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
public class SubstantiiviTaipuvaTest {
    
    public SubstantiiviTaipuvaTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testHarmoninenAToimiiNeutraalilla() {
        Substantiivi sana = new Substantiivi("siili", NomininLuku.YKSIKKO, Sijamuoto.PARTITIIVI, false);
        assertEquals("ä", sana.harmoninenA());
    }
    
    @Test
    public void testHarmoninenAToimiiEtuvokaalilla() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.PARTITIIVI, false);
        assertEquals("a", sana.harmoninenA());
    }
    
    @Test
    public void onVokaaliTunnistaaVokaalin() {
        Substantiivi sana = new Substantiivi("siili", NomininLuku.YKSIKKO, Sijamuoto.PARTITIIVI, false);
        assertEquals(true, sana.onVokaali("a"));
    }
    
    @Test
    public void onVokaaliTunnistaaKonsonantin() {
        Substantiivi sana = new Substantiivi("siili", NomininLuku.YKSIKKO, Sijamuoto.PARTITIIVI, false);
        assertEquals(false, sana.onVokaali("k"));
    }
    
    @Test
    public void vokaaliPalauttaaEtuvokaalin() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.PARTITIIVI, false);
        assertEquals(Vokaali.ETU, sana.vokaali());
    }
    
    @Test
    public void vokaaliPalauttaaTakavokaalin() {
        Substantiivi sana = new Substantiivi("työ", NomininLuku.YKSIKKO, Sijamuoto.PARTITIIVI, false);
        assertEquals(Vokaali.TAKA, sana.vokaali());
    }
    
    @Test
    public void vokaaliPalauttaaNeutraalivokaalin() {
        Substantiivi sana = new Substantiivi("siili", NomininLuku.YKSIKKO, Sijamuoto.PARTITIIVI, false);
        assertEquals(Vokaali.NEUTRAALI, sana.vokaali());
    }
    
    @Test
    public void testAstevaihteluKKstaK() {
        Substantiivi sana = new Substantiivi("kukka", NomininLuku.YKSIKKO, Sijamuoto.GENETIIVI, true);
        assertEquals("kukan", sana.sananmuoto());
    }
    
    @Test
    public void testAstevaihteluPstaV() {
        Substantiivi sana = new Substantiivi("papu", NomininLuku.YKSIKKO, Sijamuoto.GENETIIVI, true);
        assertEquals("pavun", sana.sananmuoto());
    }
    
    @Test
    public void testAstevaihteluRTstaRR() {
        Substantiivi sana = new Substantiivi("parta", NomininLuku.YKSIKKO, Sijamuoto.GENETIIVI, true);
        assertEquals("parran", sana.sananmuoto());
    }
    
}
