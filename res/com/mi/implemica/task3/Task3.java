package com.mi.implemica.task3;

import java.math.BigInteger;

/**
 * 3 Find the sum of the digits in the number 100! (i.e. 100 factorial)
 * {Correct answer: 648}
 * Created by West on 27.05.2017.
 */

public class Task3 {
    public static void main(String[] args) {
        String string = factorial(100).toString();
        System.out.println(aountNumber(string));
    }

    // calculation of factorial numbers
    public static BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; ++i)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    // calculation of numbers
    public static int aountNumber(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            String temp = String.valueOf(string.charAt(i));
            int a = Integer.parseInt(temp);
            count = (int) (count + a);
        }
        return count;
    }
    //
}
