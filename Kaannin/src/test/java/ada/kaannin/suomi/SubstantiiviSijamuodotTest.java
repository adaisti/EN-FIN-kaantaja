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
public class SubstantiiviSijamuodotTest {
    
    public SubstantiiviSijamuodotTest() {
        
    }

    @Before
    public void setUp() {
    }
    
    @Test
    public void nominatiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.NOMINATIIVI, true);
        assertEquals("puikot", sana.sananmuoto());
    }
    
    @Test
    public void genetiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.GENETIIVI, true);
        assertEquals("puikkojen", sana.sananmuoto());
    }
    
    @Test
    public void partitiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.PARTITIIVI, true);
        assertEquals("puikkoja", sana.sananmuoto());
    }
    
    @Test
    public void essiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.ESSIIVI, true);
        assertEquals("puikkoina", sana.sananmuoto());
    }
    
    @Test
    public void translatiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.TRANSLATIIVI, true);
        assertEquals("puikoiksi", sana.sananmuoto());
    }
    
    @Test
    public void inessiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.INESSIIVI, true);
        assertEquals("puikoissa", sana.sananmuoto());
    }
    
    @Test
    public void elatiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.ELATIIVI, true);
        assertEquals("puikoista", sana.sananmuoto());
    }
    
    @Test
    public void illatiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.ILLATIIVI, true);
        assertEquals("puikkoihin", sana.sananmuoto());
    }
    
    @Test
    public void adessiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.ADESSIIVI, true);
        assertEquals("puikoilla", sana.sananmuoto());
    }
    
    @Test
    public void ablatiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.ABLATIIVI, true);
        assertEquals("puikoilta", sana.sananmuoto());
    }
    
    @Test
    public void allatiiviMonikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.MONIKKO, Sijamuoto.ALLATIIVI, true);
        assertEquals("puikoille", sana.sananmuoto());
    }
    
    @Test
    public void nominatiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.NOMINATIIVI, true);
        assertEquals("puikko", sana.sananmuoto());
    }
    
    @Test
    public void genetiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.GENETIIVI, true);
        assertEquals("puikon", sana.sananmuoto());
    }
    
    @Test
    public void partitiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.PARTITIIVI, true);
        assertEquals("puikkoa", sana.sananmuoto());
    }
    
    @Test
    public void essiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.ESSIIVI, true);
        assertEquals("puikkona", sana.sananmuoto());
    }
    
    @Test
    public void traslatiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.TRANSLATIIVI, true);
        assertEquals("puikoksi", sana.sananmuoto());
    }
    
    @Test
    public void inessiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.INESSIIVI, true);
        assertEquals("puikossa", sana.sananmuoto());
    }
    
    @Test
    public void elatiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.ELATIIVI, true);
        assertEquals("puikosta", sana.sananmuoto());
    }
    
    @Test
    public void illatiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.ILLATIIVI, true);
        assertEquals("puikkoon", sana.sananmuoto());
    }
    
    @Test
    public void adessiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.ADESSIIVI, true);
        assertEquals("puikolla", sana.sananmuoto());
    }
    
    @Test
    public void ablatiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.ABLATIIVI, true);
        assertEquals("puikolta", sana.sananmuoto());
    }
    
    @Test
    public void allatiiviYksikkoTest() {
        Substantiivi sana = new Substantiivi("puikko", NomininLuku.YKSIKKO, Sijamuoto.ALLATIIVI, true);
        assertEquals("puikolle", sana.sananmuoto());
    }
}
