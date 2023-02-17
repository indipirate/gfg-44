package com.gfg.cp.two;

import java.util.Arrays;

interface Search {
    int find(int target);
}

public class BinarySearch implements Search {
    private final Integer[] searchArr;

    public BinarySearch(Integer[] searchArr) {
        Arrays.sort(searchArr);
        this.searchArr = searchArr;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch(new Integer[]{1, 2, 3, 4, 6});
        System.out.println(bs.find(6));
    }

    @Override
    public int find(int target) {
        int low = 0;
        int high = this.searchArr.length;
        int found = -1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (this.searchArr[mid] < target) {
                low = mid + 1;
            } else if (this.searchArr[mid] > target) {
                high = mid - 1;
            } else {
                found = 1;
                high = -1;
            }
            ;
        }

        return found;
    }
}
