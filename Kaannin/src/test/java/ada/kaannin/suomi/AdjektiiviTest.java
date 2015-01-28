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
public class AdjektiiviTest {
    
    public AdjektiiviTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testAsetaVertailumuotoKomparatiiviNominatiivi() {
        Adjektiivi sana = new Adjektiivi("nopea", NomininLuku.YKSIKKO, Sijamuoto.NOMINATIIVI, Vertailumuoto.KOMPARATIIVI);
        assertEquals("nopeampi", sana.sananmuoto());
    }
    
    @Test
    public void testAsetaVertailumuotoKomparatiiviInessiivi() {
        Adjektiivi sana = new Adjektiivi("nopea", NomininLuku.YKSIKKO, Sijamuoto.INESSIIVI, Vertailumuoto.KOMPARATIIVI);
        assertEquals("nopeammissa", sana.sananmuoto());
    }
    
    @Test
    public void testSijamuodotToimiiAblatiivinMonikko() {
        Adjektiivi sana = new Adjektiivi("pieni", NomininLuku.MONIKKO, Sijamuoto.ABLATIIVI, Vertailumuoto.POSITIIVI);
        assertEquals("pieniltä", sana.sananmuoto());
    }

    
    
    @Test
    public void testSananmuoto() {
    }
    
}
