package com.yumtao.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.LongBinaryOperator;

public class Test {


    public static void main(String[] args) {

        String[] stringsArray = {"1", "2"};

        Comparator tComparator = (s1, s2) -> {
            return -1;
        };

        // sort(T[] a, Comparator<? super T> c)
        Arrays.sort(stringsArray, (s1, s2) -> { return -1; });
        Arrays.sort(stringsArray, (s1, s2) -> s1.compareToIgnoreCase(s2));
        Arrays.sort(stringsArray, String::compareToIgnoreCase);
        Arrays.sort(stringsArray, String::indexOf);


        System.out.println(Arrays.toString(stringsArray));
    }
}
