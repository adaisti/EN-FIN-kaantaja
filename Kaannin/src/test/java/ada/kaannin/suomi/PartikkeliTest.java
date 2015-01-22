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
public class PartikkeliTest {
    
    public PartikkeliTest() {
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void testSananmuotoEiMuotoileVertailemattomiaPartikkeleita() {
        Partikkeli sana = new Partikkeli("mutta");
        assertEquals("mutta", sana.sananmuoto());
    }
    
    @Test
    public void testAsetaVertailumuotoMuodostaaKomparatiivin() {
        Partikkeli sana = new Partikkeli("iloisesti", Vertailumuoto.KOMPARATIIVI);
        assertEquals("iloisemmin", sana.sananmuoto());
    }
    
    @Test
    public void testAsetaVertailuMuotoMuodostaaSuperlatiivin() {
        Partikkeli sana = new Partikkeli("iloisesti", Vertailumuoto.SUPERLATIIVI);
        assertEquals("iloisimmin", sana.sananmuoto());
    }
    
}
