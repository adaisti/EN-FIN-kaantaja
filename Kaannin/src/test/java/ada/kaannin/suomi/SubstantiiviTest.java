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
public class SubstantiiviTest {
    
    public SubstantiiviTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testHarmoninenAToimii() {
        Substantiivi sana = new Substantiivi("siili", NomininLuku.YKSIKKO, Sijamuoto.PARTITIIVI, false);
        assertEquals("ä", sana.harmoninenA());
    }
    
    public void testMonikonInessiivi() {
        Substantiivi sana = new Substantiivi("siili", NomininLuku.MONIKKO, Sijamuoto.INESSIIVI, false);
        assertEquals("siilissä", sana.sananmuoto());
    }
    
    public void testAstevaihteluKKstaK() {
        Substantiivi sana = new Substantiivi("kukka", NomininLuku.YKSIKKO, Sijamuoto.GENETIIVI, true);
        assertEquals("kukan", sana.sananmuoto());
    }
}
