package com.in28minutes.unittesting.demo.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonPathTest {

    @Test
    public void learning(){
        String ResponseFromService = "[\n" +
                                "{\"id\": 10001,\"name\": \"Pencil\",\"quantity\": 5,},\n" +
                                "{\"id\": 10002,\"name\": \"Pen\",\"quantity\": 10},\n" +
                                "{\"id\": 10003,\"name\": \"Eraser\",\"quantity\": 15}\n" +
                                "]";
        DocumentContext context = JsonPath.parse(ResponseFromService);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(10001, 10002, 10003);

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
        System.out.println(context.read("$.[?(@.quantity==5)]").toString());
    }

}
