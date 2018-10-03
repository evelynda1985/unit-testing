package com.in28minutes.unittesting.demo.business;

import com.in28minutes.unittesting.demo.service.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImplementation {

    private SomeDataService someDataService;

    public int calculateSum(int[] data){
        int sum = 0;
        for (int value : data){
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingStreams(int[] data){
        return Arrays.stream(data).reduce(Integer :: sum).orElse(0);
    }

    public int calculateSumUsingDataService(){
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value : data){
            sum += value;
        }
        return sum;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
}
