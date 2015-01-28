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
public class VerbiTest {
    
    public VerbiTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSananmuoto() {
        Verbi sana = new Verbi("kaventaa", Persoona.MON1, Modus.KONDITIONAALI, Aikamuoto.PREESENS);
        assertEquals("kaventaisimme", sana.sananmuoto());
    }

    @Test
    public void testAsetaModus() {
        Verbi sana = new Verbi("kaventaa", Persoona.MON1, Modus.KONDITIONAALI, Aikamuoto.PREESENS);
        assertEquals("kaventaisimme", sana.sananmuoto());
    }

    @Test
    public void testIndikatiivi() {
        Verbi sana = new Verbi("kaventaa", Persoona.YKS1, Modus.INDIKATIIVI, Aikamuoto.PREESENS);
        assertEquals("kavennan", sana.sananmuoto());
    }

    @Test
    public void testKonditionaali() {
        Verbi sana = new Verbi("kaventaa", Persoona.MON1, Modus.KONDITIONAALI, Aikamuoto.PREESENS);
        assertEquals("kaventaisimme", sana.sananmuoto());
    }

    @Test
    public void testPotentiaali() {
        Verbi sana = new Verbi("kaventaa", Persoona.MON1, Modus.POTENTIAALI, Aikamuoto.PREESENS);
        assertEquals("kaventanemme", sana.sananmuoto());
    }

    @Test
    public void testImperatiivi() {
        Verbi sana = new Verbi("kaventaa", Persoona.MON2, Modus.IMPERATIIVI, Aikamuoto.PREESENS);
        assertEquals("kaventakaa", sana.sananmuoto());
    }

    @Test
    public void testAsetaImperatiivinPersoonaYksikko() {
        Verbi sana = new Verbi("kaventaa", Persoona.YKS2, Modus.IMPERATIIVI, Aikamuoto.PREESENS);
        assertEquals("kavenna", sana.sananmuoto());
    }
    
    @Test
    public void testAsetaImperatiivinPersoonaMonikko() {
        Verbi sana = new Verbi("kaventaa", Persoona.MON2, Modus.IMPERATIIVI, Aikamuoto.PREESENS);
        assertEquals("kaventakaa", sana.sananmuoto());
    }

    @Test
    public void testAsetaPersoona() {
        Verbi sana = new Verbi("kaventaa", Persoona.YKS1, Modus.INDIKATIIVI, Aikamuoto.PREESENS);
        assertEquals("kavennan", sana.sananmuoto());
    }

    @Test
    public void testYks1Pers() {
        Verbi sana = new Verbi("kaventaa", Persoona.YKS1, Modus.INDIKATIIVI, Aikamuoto.PREESENS);
        assertEquals("kavennan", sana.sananmuoto());
    }

    @Test
    public void testYks2Pers() {
        Verbi sana = new Verbi("kaventaa", Persoona.YKS2, Modus.INDIKATIIVI, Aikamuoto.PREESENS);
        assertEquals("kavennat", sana.sananmuoto());
    }

    @Test
    public void testYks3Pers() {
        Verbi sana = new Verbi("kaventaa", Persoona.YKS3, Modus.INDIKATIIVI, Aikamuoto.PREESENS);
        assertEquals("kaventaa", sana.sananmuoto());
    }

    @Test
    public void testMon1Pers() {
        Verbi sana = new Verbi("kaventaa", Persoona.MON1, Modus.INDIKATIIVI, Aikamuoto.PREESENS);
        assertEquals("kavennamme", sana.sananmuoto());
    }

    @Test
    public void testMon2Pers() {
        Verbi sana = new Verbi("kaventaa", Persoona.MON2, Modus.INDIKATIIVI, Aikamuoto.PREESENS);
        assertEquals("kavennatte", sana.sananmuoto());
    }

    @Test
    public void testMon3Pers() {
        Verbi sana = new Verbi("kaventaa", Persoona.MON3, Modus.INDIKATIIVI, Aikamuoto.PREESENS);
        assertEquals("kaventavat", sana.sananmuoto());
    }

    @Test
    public void testPassiivi() {
        Verbi sana = new Verbi("kaventaa", Persoona.PASSIIVI, Modus.INDIKATIIVI, Aikamuoto.PREESENS);
        assertEquals("kavennetaan", sana.sananmuoto());
    }
    
}
