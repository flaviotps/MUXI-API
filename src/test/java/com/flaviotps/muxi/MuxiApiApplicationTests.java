package com.flaviotps.muxi;

import com.flaviotps.muxi.Util.Constants;
import com.flaviotps.muxi.service.TerminalService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MuxiApiApplicationTests {


    @Autowired
    TerminalService terminalService;




    @Test
    public void SchemaValidation() throws Exception {

        try {
            JSONObject schema = new JSONObject(Constants.JSON_SCHEMA);
            boolean validSchema = terminalService.validate(schema, new JSONObject(Constants.TEST_JSON));
            Assert.assertEquals(true, validSchema);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
