package com.in28minutes.unittesting.demo.business;

import com.in28minutes.unittesting.demo.service.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImplementation SomeBusinessImplementation;

    @Mock
    SomeDataService dataServiceMock;

    /*@Before //We don't need this anymore because mockito do it for us
    public void before(){
        business.setSomeDataService(dataServiceMock);//because it has default constructor
    }*/

    @Test
    public void calculateSumUsingDataService_basic(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6,SomeBusinessImplementation.calculateSumUsingDataService());
    }

    @Test
    public void calcuateSumUsingDataService_empty(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0,SomeBusinessImplementation.calculateSumUsingDataService());
    }

    @Test
    public void calcuateSumUsingDataService_oneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5,SomeBusinessImplementation.calculateSumUsingDataService());
    }

}
