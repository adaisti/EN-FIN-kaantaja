/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.kaannin.englanti;

import ada.kaannin.suomi.Vertailumuoto;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adahyvarinen
 */
public class VertailumuodoissaTaipuvanSyntaksihakuTest {
    
    private Hakemistonhallinta hh;
    private VertailumuodoissaTaipuvanSyntaksihaku vtsh;
    
    public VertailumuodoissaTaipuvanSyntaksihakuTest() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        hh = new Hakemistonhallinta();
        vtsh = new VertailumuodoissaTaipuvanSyntaksihaku(hh.ss(), "long");
    }

    @Test
    public void testVertailumuoto() {
        assertEquals(Vertailumuoto.POSITIIVI, vtsh.vertailumuoto());
    }
    
}
