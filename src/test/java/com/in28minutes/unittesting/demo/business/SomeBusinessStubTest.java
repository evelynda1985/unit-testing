package com.in28minutes.unittesting.demo.business;

import com.in28minutes.unittesting.demo.service.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }

}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        business.setSomeDataService(new SomeDataServiceStub());//because it has default constructor
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    /*@Test
    public void calcuateSumUsingDataService_empty(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }*/

    @Test
    public void calcuateSumUsingDataService_oneValue(){
        SomeBusinessImplementation business = new SomeBusinessImplementation();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

}
