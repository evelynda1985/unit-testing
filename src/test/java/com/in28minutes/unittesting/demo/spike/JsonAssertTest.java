package com.in28minutes.unittesting.demo.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test //accepts spaces but you must to pass all the parameters
    public void jsonAssert_StrictTrue() throws JSONException {
        String expectedRespose = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedRespose, actualResponse, true);
    }

    @Test // you pass all o some of the parameters
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedRespose = "{\"id\":1,\"name\":\"Ball\"}";
        JSONAssert.assertEquals(expectedRespose, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutSpaces() throws JSONException {
        String expectedRespose = "{id:1,name:Ball,price:10,quantity:100}";
        JSONAssert.assertEquals(expectedRespose, actualResponse, false);
    }

}
