package pl.put.poznan.transformer.mocks;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import pl.put.poznan.transformer.app.TextTransformerApplication;
import pl.put.poznan.transformer.dto.TextDTO;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.rest.TextTransformerController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TextTransformerControllerTest {

    private TextTransformer textTransformer = mock(TextTransformer.class);
    TextDTO textDTO;
    List<String> transforms;

    @BeforeEach
    void setUp() throws Exception{
        textDTO = new TextDTO();
        transforms = new ArrayList<>();
    }

    @Test
    public void simpleSwapSizeTest() throws JSONException {
        textDTO.setText("test");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        String resultText = "TEST";
        when(textTransformer.transform(textDTO.getText())).thenReturn(resultText);
        TextTransformerController textTransformerController = new TextTransformerController();
        Assertions.assertEquals(textTransformer.transform(textDTO.getText()), textTransformerController.get(textDTO).getText());
    }

    @Test
    public void notThatSimpleSwapSizeTest() throws JSONException {
        textDTO.setText("test TEST test");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        String resultText = "TEST test TEST";
        when(textTransformer.transform(textDTO.getText())).thenReturn(resultText);
        TextTransformerController textTransformerController = new TextTransformerController();
        Assertions.assertEquals(textTransformer.transform(textDTO.getText()), textTransformerController.get(textDTO).getText());
    }

    @Test
    public void upAndDownSwapSizeTest() throws JSONException {
        textDTO.setText("tEsT");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        String resultText = "TeSt";
        when(textTransformer.transform(textDTO.getText())).thenReturn(resultText);
        TextTransformerController textTransformerController = new TextTransformerController();
        Assertions.assertEquals(textTransformer.transform(textDTO.getText()), textTransformerController.get(textDTO).getText());
    }

    @Test
    public void upAndDownMultipleTimesSwapSizeTest() throws JSONException {
        textDTO.setText("tEsT iS ImPoRtEnT AnD SiMplE");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        String resultText = "TeSt Is iMpOrTeNt aNd sImPLe";
        when(textTransformer.transform(textDTO.getText())).thenReturn(resultText);
        TextTransformerController textTransformerController = new TextTransformerController();
        Assertions.assertEquals(textTransformer.transform(textDTO.getText()), textTransformerController.get(textDTO).getText());
    }

    @Test
    public void swapSizeAndUpperTest() throws JSONException {
        textDTO.setText("tEsT iS ImPoRtEnT AnD SiMplE");
        transforms.add("swapsize");
        transforms.add("upper");
        textDTO.setTransforms(transforms);
        String resultText = "TEST IS IMPORTENT AND SIMPLE";
        when(textTransformer.transform(textDTO.getText())).thenReturn(resultText);
        TextTransformerController textTransformerController = new TextTransformerController();
        Assertions.assertEquals(textTransformer.transform(textDTO.getText()), textTransformerController.get(textDTO).getText());
    }

    @Test
    public void swapSizeAndLowerAndCapitalizeTest() throws JSONException {
        textDTO.setText("tEsT iS ImPoRtEnT AnD SiMplE");
        transforms.add("swapsize");
        transforms.add("lower");
        transforms.add("capitalize");
        textDTO.setTransforms(transforms);
        String resultText = "Test Is Importent And Simple";
        when(textTransformer.transform(textDTO.getText())).thenReturn(resultText);
        TextTransformerController textTransformerController = new TextTransformerController();
        Assertions.assertEquals(textTransformer.transform(textDTO.getText()), textTransformerController.get(textDTO).getText());
    }

    @Test
    public void swapSizeAndRepeatsTest() throws JSONException {
        textDTO.setText("!@#$% test some some some 123 123 letters");
        transforms.add("swapsize");
        transforms.add("repeats");
        textDTO.setTransforms(transforms);
        String resultText = "!@#$% TEST SOME 123 LETTERS";
        when(textTransformer.transform(textDTO.getText())).thenReturn(resultText);
        TextTransformerController textTransformerController = new TextTransformerController();
        Assertions.assertEquals(textTransformer.transform(textDTO.getText()), textTransformerController.get(textDTO).getText());
    }

    @Test
    public void onlyNotSwappableCharactersTest() throws JSONException {
        textDTO.setText("!@#$%^&*(1234567890");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        String resultText = "!@#$%^&*(1234567890";
        when(textTransformer.transform(textDTO.getText())).thenReturn(resultText);
        TextTransformerController textTransformerController = new TextTransformerController();
        Assertions.assertEquals(textTransformer.transform(textDTO.getText()), textTransformerController.get(textDTO).getText());
    }

    @Test
    public void intToWordAndUpperTest() throws JSONException {
        textDTO.setText("111");
        transforms.add("inttoword");
        transforms.add("upper");
        textDTO.setTransforms(transforms);
        String resultText = "STO JEDENAŚCIE";
        when(textTransformer.transform(textDTO.getText())).thenReturn(resultText);
        TextTransformerController textTransformerController = new TextTransformerController();
        Assertions.assertEquals(textTransformer.transform(textDTO.getText()), textTransformerController.get(textDTO).getText());
    }

    @Test
    public void onlyWhitespaceSwapSizeTest() throws JSONException {
        textDTO.setText("   ");
        transforms.add("unfoldshortcut");
        transforms.add("swapsize");
        textDTO.setTransforms(transforms);
        String resultText = "   ";
        when(textTransformer.transform(textDTO.getText())).thenReturn(resultText);
        TextTransformerController textTransformerController = new TextTransformerController();
        Assertions.assertEquals(textTransformer.transform(textDTO.getText()), textTransformerController.get(textDTO).getText());
    }
}