package pl.put.poznan.transformer.tests;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Upper;

import static org.junit.jupiter.api.Assertions.*;

class UpperTest {

    @Test
    public void simpleTest(){
        Upper upper = new Upper("test");
        assertEquals("TEST", upper.getText());
    }

    @Test
    public void noChangeTest(){
        Upper upper = new Upper("TEST");
        assertEquals("TEST", upper.getText());
    }

    @Test
    public void longTest(){
        Upper upper = new Upper("more more more text to edit, please work  ");
        assertEquals("MORE MORE MORE TEXT TO EDIT, PLEASE WORK  ", upper.getText());
    }

    @Test
    public void upperAndLowerTest(){
        Upper upper = new Upper("MORE MORE MORE TEXT TO EDIT, please work  ");
        assertEquals("MORE MORE MORE TEXT TO EDIT, PLEASE WORK  ", upper.getText());
    }

    @Test
    public void upperAndLowerByTurnsTest(){
        Upper upper = new Upper("MoRe MoRe MoRe TeXt To EdIt, PlEaSe WoRk  ");
        assertEquals("MORE MORE MORE TEXT TO EDIT, PLEASE WORK  ", upper.getText());
    }
}