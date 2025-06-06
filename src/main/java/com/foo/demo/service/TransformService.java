package com.foo.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TransformService {

    private static final Integer COMPARE_NUMBER_ONE = 3;
    private static final Integer COMPARE_NUMBER_TWO = 5;
    private static final Integer COMPARE_NUMBER_THREE = 7;
    private static final String FOO = "FOO";
    private static final String BAR = "BAR";
    private static final String QUIX = "QUIX";



    public static String getTransformNumber(int number) {

        StringBuilder transform = new StringBuilder();
        String str = String.valueOf(number);

        if (number % COMPARE_NUMBER_ONE == 0) transform.append(FOO);
        if (number % COMPARE_NUMBER_TWO == 0) transform.append(BAR);

        checkNumberRightToLeft(str , transform);

        return !transform.isEmpty() ? transform.toString() : String.valueOf(number);
    }

    public String transformBatchProcessing(int number) {

        StringBuilder transform = new StringBuilder();

        //Integer.toString(number);
        //return getTransformNumber(number);

        return Integer.toString(number).concat("  ").concat(getTransformNumber(number));
    }


    public static void checkNumberRightToLeft (String str , StringBuilder transform){

        for (char c : str.toCharArray()) {
            if (c ==  Integer.toString(COMPARE_NUMBER_ONE).charAt(0)) transform.append(FOO);
            if (c == Integer.toString(COMPARE_NUMBER_TWO).charAt(0)) transform.append(BAR);
            if (c == Integer.toString(COMPARE_NUMBER_THREE).charAt(0)) transform.append(QUIX);
        }

    }
}
