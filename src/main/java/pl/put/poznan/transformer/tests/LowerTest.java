package pl.put.poznan.transformer.tests;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Lower;

import static org.junit.jupiter.api.Assertions.*;

class LowerTest {

    @Test
    public void simpleTest(){
        Lower lower = new Lower("TEST");
        assertEquals("test", lower.getText());
    }

    @Test
    public void noChangeTest(){
        Lower lower = new Lower("test");
        assertEquals("test", lower.getText());
    }

    @Test
    public void longTest(){
        Lower lower = new Lower("MORE MORE MORE TEXT TO EDIT, PLEASE WORK  ");
        assertEquals("more more more text to edit, please work  ", lower.getText());
    }

    @Test
    public void upperAndLowerTest(){
        Lower lower = new Lower("MORE MORE MORE TEXT TO EDIT, please work  ");
        assertEquals("more more more text to edit, please work  ", lower.getText());
    }

    @Test
    public void upperAndLowerByTurnsTest(){
        Lower lower = new Lower("MoRe MoRe MoRe TeXt To EdIt, PlEaSe WoRk  ");
        assertEquals("more more more text to edit, please work  ", lower.getText());
    }
}