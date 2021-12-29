package pl.put.poznan.transformer.mocks;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import pl.put.poznan.transformer.app.TextTransformerApplication;
import pl.put.poznan.transformer.dto.TextDTO;
import pl.put.poznan.transformer.rest.TextTransformerController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TextTransformerControllerTest {

    TextDTO textDTO;
    List<String> transforms;
    @InjectMocks
    TextTransformerController textTransformerController;

    @Mock
    Logger logger;

    @BeforeEach
    void setUp() throws Exception{
        textDTO = new TextDTO();
        transforms = new ArrayList<>();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void simpleSwapSizeTest() throws JSONException {

        textDTO.setText("test");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        TextDTO answer = textTransformerController.get(textDTO);
        assertEquals("TEST", answer.getText());
    }

    @Test
    public void notThatSimpleSwapSizeTest() throws JSONException {
        textDTO.setText("test TEST test");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        TextDTO answer = textTransformerController.get(textDTO);
        assertEquals("TEST test TEST", answer.getText());
    }

    @Test
    public void upAndDownSwapSizeTest() throws JSONException {
        textDTO.setText("tEsT");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        TextDTO answer = textTransformerController.get(textDTO);
        assertEquals("TeSt", answer.getText());
    }

    @Test
    public void upAndDownMultipleTimesSwapSizeTest() throws JSONException {
        textDTO.setText("tEsT iS ImPoRtEnT AnD SiMplE");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        TextDTO answer = textTransformerController.get(textDTO);
        assertEquals("TeSt Is iMpOrTeNt aNd sImPLe", answer.getText());
    }

    @Test
    public void swapSizeAndUpperTest() throws JSONException {
        textDTO.setText("tEsT iS ImPoRtEnT AnD SiMplE");
        transforms.add("swapsize");
        transforms.add("upper");
        textDTO.setTransforms(transforms);
        TextDTO answer = textTransformerController.get(textDTO);
        assertEquals("TEST IS IMPORTENT AND SIMPLE", answer.getText());
    }

    @Test
    public void swapSizeAndLowerAndCapitalizeTest() throws JSONException {
        textDTO.setText("tEsT iS ImPoRtEnT AnD SiMplE");
        transforms.add("swapsize");
        transforms.add("lower");
        transforms.add("capitalize");
        textDTO.setTransforms(transforms);
        TextDTO answer = textTransformerController.get(textDTO);
        assertEquals("Test Is Importent And Simple", answer.getText());
    }

    @Test
    public void swapSizeAndRepeatsTest() throws JSONException {
        textDTO.setText("!@#$% test some some some 123 123 letters");
        transforms.add("swapsize");
        transforms.add("repeats");
        textDTO.setTransforms(transforms);
        TextDTO answer = textTransformerController.get(textDTO);
        assertEquals("!@#$% TEST SOME 123 LETTERS", answer.getText());
    }

    @Test
    public void onlyNotSwappableCharactersTest() throws JSONException {
        textDTO.setText("!@#$%^&*(1234567890");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        TextDTO answer = textTransformerController.get(textDTO);
        assertEquals("!@#$%^&*(1234567890", answer.getText());
    }

    @Test
    public void intToWordAndUpperTest() throws JSONException {
        textDTO.setText("111");
        transforms.add("inttoword");
        transforms.add("upper");
        textDTO.setTransforms(transforms);
        TextDTO answer = textTransformerController.get(textDTO);
        assertEquals("STO JEDENAŚCIE", answer.getText());
    }

    @Test
    public void onlyWhitespaceSwapSizeTest() throws JSONException {
        textDTO.setText("   ");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        TextDTO answer = textTransformerController.get(textDTO);
        assertEquals("   ", answer.getText());
    }
}