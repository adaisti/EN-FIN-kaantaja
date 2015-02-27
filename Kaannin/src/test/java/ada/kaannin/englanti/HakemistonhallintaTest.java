/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adahyvarinen
 */
public class HakemistonhallintaTest {
    
    private Hakemistonhallinta hh;
    
    public HakemistonhallintaTest() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        hh = new Hakemistonhallinta();
    }

    @Test
    public void testAlustaSanakirjaToimii() throws FileNotFoundException {
        hh.alustaSanakirja();
        assertEquals(true, hh.s().sisaltaaSanan("alternatively"));
    }

    @Test
    public void testAlustaSanakirjatToimii() throws FileNotFoundException {
        hh.alustaSanakirjat();
        assertEquals(true, hh.ss().prepositiot().containsKey("on"));
    }

    @Test
    public void testSyoteToimii() {
        assertEquals("alternatively vaihtoehtoisesti pa", hh.syote()[0]);
    }
   
}
