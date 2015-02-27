/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.Aikamuoto;
import ada.kaannin.suomi.Modus;
import ada.kaannin.suomi.Persoona;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adahyvarinen
 */
public class VerbinSyntaksihakuTest {
    
    private VerbinSyntaksihaku vsh;
    private Hakemistonhallinta hh;
    
    public VerbinSyntaksihakuTest() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        hh = new Hakemistonhallinta();
        vsh = new VerbinSyntaksihaku(hh.ss(), "knit");
    }

    @Test
    public void testModus() {
        assertEquals(Modus.IMPERATIIVI, vsh.modus());
    }

    @Test
    public void testAikamuoto() {
        assertEquals(Aikamuoto.PREESENS, vsh.aikamuoto());
    }

    @Test
    public void testPersoona() {
        assertEquals(Persoona.YKS2, vsh.persoona());
    }
    
}
