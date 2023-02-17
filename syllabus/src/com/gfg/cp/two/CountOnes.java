package com.gfg.cp.two;

public class CountOnes {

    public static void main(String[] args) {
        int count = fetchCount(new int[]{1, 1, 1, 0, 0});
        System.out.println(count);
    }

    static int fetchCount(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int highestOneIndex = -1;
        int mid;
        if (arr[high] == 1) highestOneIndex = high;
        else {
            while (low <= high) {
                mid = low + ((high - low) / 2);

                if (arr[mid] == 0) {
                    high = mid - 1;
                } else {
                    highestOneIndex = mid;
                    low = mid + 1;
                }
            }
        }
        return highestOneIndex + 1;
    }
}
