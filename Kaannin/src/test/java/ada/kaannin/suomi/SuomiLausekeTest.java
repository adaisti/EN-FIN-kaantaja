/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.suomi;

import ada.kaannin.englanti.Sanaluokka;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adahyvarinen
 */
public class SuomiLausekeTest {
    
    SuomiLauseke sl;
    
    public SuomiLausekeTest() {
    }
    
    @Before
    public void setUp() {
        sl = new SuomiLauseke(Sanaluokka.ADJEKTIIVI, "nopea", NomininLuku.YKSIKKO, Sijamuoto.INESSIIVI, Vertailumuoto.KOMPARATIIVI);
    }

    @Test
    public void testTaivuta() {
        assertEquals("nopeammissa", sl.taivuta());
    }
    
}
