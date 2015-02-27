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
public class NumeraaliTest {
    
    Numeraali sana;
    
    public NumeraaliTest() {
    }
    
    @Before
    public void setUp() {
        sana = new Numeraali("kolme", NomininLuku.YKSIKKO, Sijamuoto.GENETIIVI);
    }

    @Test
    public void sananmuotoToimii() {
        assertEquals("kolmen", sana.sananmuoto());
    }
    
}
