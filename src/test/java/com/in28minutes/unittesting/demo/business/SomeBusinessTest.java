package com.in28minutes.unittesting.demo.business;

import org.junit.Test;
import static org.junit.Assert.*;

public class SomeBusinessTest {

    @Test
    public void calcuateSum_basic(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        int actualResult = business.calculateSum(new int[]{1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcuateSum_empty(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        int actualResult = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calcuateSum_oneValue(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        int actualResult = business.calculateSum(new int[]{5});
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

}
