package com.mi.implemica.task1;

import java.util.Scanner;

/**
 * Created by West on 26.05.2017.
 */
/*1. Если мы из корректно записанного арифметического выражения, содержащего числа, знаки операций и
открывающие и закрывающие круглые скобки выбросим числа и знаки операций, а затем запишем оставшиеся
в выражении скобки без пробелов между ними, то полученный результат назовем правильным скобочным
выражением [скобочное выражение "(()(()))" - правильное, а "()(" и "())(" - нет].
Найти число правильных скобочных выражений, содержащих N открывающихся и N закрывающихся скобок.
N вводится с клавиатуры. N неотрицательное целое число.

Пример:
N =  1 (по одной скобке открывающейся и закрывающеся) - ответ 1
()
)(
))
((
Только один правильный вариант

Для введенного числа 2 -lll 2 :
()()
(())
То есть только два варианта, когда все открытые скобки правильно открываются/закрываются.
И так далее.*/
public class Task1 {
    public static void main(String[] args) {
        // open Scanner
        Scanner scanner = new Scanner(System.in);
        String lineBrackets = scanner.next();
        char controlBracket = '(';
        int countBrackets = 0;
        // The counter of opened bracket
        int openBracket = 0;
        // The counter of closed bracket
        int closedBracket = 0;
        // The number of pairs of brackets
        int pairsBrackets = 0;
        // check the first and last characters
        if (lineBrackets.charAt(lineBrackets.length() - 1) == controlBracket) {
            System.out.println(false);
        } else if (lineBrackets.charAt(0) != controlBracket) {
            System.out.println(false);
        } else {
            // start check all values
            for (int i = 0; i < lineBrackets.length(); i++) {
                if (lineBrackets.charAt(i) == controlBracket) {
                    countBrackets = countBrackets + 1;
                    openBracket = openBracket + 1;
                } else if (lineBrackets.charAt(i) != controlBracket) {
                    {
                        countBrackets = countBrackets - 1;
                        closedBracket = closedBracket + 1;
                    }
                }
            }
            if (openBracket == closedBracket) {
                pairsBrackets = openBracket;
            }
            if (countBrackets == 0) {
                System.out.println(true + " result = " + pairsBrackets);
            } else {
                System.out.println(false);
            }

        }
        //close scanner
        scanner.close();
    }

}