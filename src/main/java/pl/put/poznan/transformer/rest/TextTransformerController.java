package pl.put.poznan.transformer.rest;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.dto.TextDTO;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;


@RestController
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(value ="/api/{text}", method = RequestMethod.GET, produces = "application/json")
    public String gettest(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return  transformer.transform(text);
    }

    @RequestMapping(value = "/api", method = RequestMethod.GET, produces = "application/json")
    public String get(@RequestBody TextDTO textDTO) throws JSONException {

        //return textDTO.getText();
        // log the parameters
        logger.debug(textDTO.getText());
        logger.debug(Arrays.toString(textDTO.getTransforms()));

        // perform the transformation, you should run your logic here, below is just a silly example
        JSONObject response = new JSONObject();
        TextTransformer textTransformer = new TextTransformer(textDTO.getTransforms());
        response.put("text", textTransformer.transform(textDTO.getText()));

        return response.toString();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }
}


