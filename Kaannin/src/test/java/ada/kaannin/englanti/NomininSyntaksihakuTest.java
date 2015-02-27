/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.NomininLuku;
import ada.kaannin.suomi.Sijamuoto;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adahyvarinen
 */
public class NomininSyntaksihakuTest {
    
    NomininSyntaksihaku nsh;
    Hakemistonhallinta hh;
    
    public NomininSyntaksihakuTest() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        hh = new Hakemistonhallinta();
        nsh = new NomininSyntaksihaku(hh.ss(), "needles");
    }

    @Test
    public void testLuku() {
        assertEquals(NomininLuku.MONIKKO, nsh.luku(true));
    }

    @Test
    public void testSijamuotoToimii() {
        assertEquals(Sijamuoto.NOMINATIIVI, nsh.sijamuoto());
    }

    @Test
    public void testHaePrepositiollaToimii() {
        nsh.haePrepositiolla();
        assertEquals(Sijamuoto.NOMINATIIVI, nsh.getSijamuoto());
    }

    @Test
    public void testHaeNumerollaToimii() {
        nsh.haeNumerolla();
        assertEquals(Sijamuoto.PARTITIIVI, nsh.getSijamuoto());
    }

    @Test
    public void testOnPrepositiolauseke() {
        assertEquals(false, nsh.onPrepositiolauseke());
    }
    
}
