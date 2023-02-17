package com.gfg.cp.two;

import java.util.Arrays;

public class MajorityElement {

    public static void main(String[] args) {
        String input = "15";
        Integer[] integerInput = Arrays.stream(input.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int res = majorityElement(integerInput, integerInput.length);
        System.out.println(res);
    }

    static int majorityElement(Integer[] a, int size) {
        Arrays.sort(a);
        int res = size == 1 ? a[0] : -1;
        long greatest = Integer.MIN_VALUE, continuousSum = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                continuousSum++;
                if (continuousSum > (size / 2) && continuousSum > greatest) {
                    res = a[i];
                    greatest = continuousSum;
                }
            } else continuousSum = 1;
        }
        return res;
    }
}
