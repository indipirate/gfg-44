package com.gfg.cp.one;

import java.util.stream.Stream;

interface OneD {
    long calculateSum(int l, int r);
}

interface TwoD {
    long calculateSum(int r1, int c1, int r2, int c2);
}

public class PrefixSum {

    public static void main(String[] args) {
        OneDPrefixSum oneD = new OneDPrefixSum(Stream.of(1, 2, 3, 4, 5, 6).toArray(Integer[]::new));
        int l = 0, r = 5;
        System.out.printf("l = %d, r = %d => " + oneD.calculateSum(l, r) + "\n", l, r);
        TwoDPrefixSum twoD = new TwoDPrefixSum(Stream.of(
                Stream.of(1, 1, 1).toArray(Integer[]::new),
                Stream.of(1, 1, 1).toArray(Integer[]::new),
                Stream.of(1, 1, 1).toArray(Integer[]::new)
        ).toArray(Integer[][]::new));
        int r1 = 1, c1 = 1, r2 = 2, c2 = 2;
        System.out.printf("[%d,%d] [%d,%d]  => " + twoD.calculateSum(r1, c1, r2, c2) + "\n", r1, c1, r2, c2);
    }

}

class TwoDPrefixSum implements TwoD {
    private final Integer[][] sumArr;


    TwoDPrefixSum(Integer[][] sumArr) {
        int n = sumArr.length;
        int m = sumArr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sumArr[i][j] = sumArr[i][j - 1] + sumArr[i][j];
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j];
            }
        }
        this.sumArr = sumArr;
        System.out.println(this.sumArr);
    }

    @Override
    public long calculateSum(int r1, int c1, int r2, int c2) {
        long sum = this.sumArr[r2][c2];
        if (c1 - 1 >= 0) {
            sum -= this.sumArr[r2][c1 - 1];
        }
        if (r1 - 1 >= 0) {
            sum -= this.sumArr[r1 - 1][c2];
        }
        if (r1 - 1 >= 0 && c1 - 1 >= 0) {
            sum += this.sumArr[r1 - 1][c1 - 1];
        }
        return sum;
    }
}

class OneDPrefixSum implements OneD {
    private final Integer[] sumArr;

    OneDPrefixSum(Integer[] sumArr) {
        System.out.print(sumArr[0] + "->" + sumArr[0] + ",");
        for (int i = 1; i < sumArr.length; i++) {
            System.out.print(sumArr[i] + "->");
            sumArr[i] = sumArr[i - 1] + sumArr[i];
            System.out.print(sumArr[i] + ",");
        }
        this.sumArr = sumArr;
        System.out.println();
    }

    @Override
    public long calculateSum(int l, int r) {

        if (l - 1 >= 0) {
            return this.sumArr[r] - this.sumArr[l - 1];
        } else {
            return this.sumArr[r];
        }
    }
}
