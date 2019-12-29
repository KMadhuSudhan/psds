package com.madhu.psds.number.selfdivingnumber;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public static void main(String[] args) {
        System.out.print(selfDividingNumbers(1, 22));
    }

    private static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) ans.add(n);
        }
        return ans;
    }

    public static boolean selfDividing(int x) {
        int temp = x;
        while (x != 0) {
            int rem = x % 10;
            if (rem == 0 || temp % rem != 0)
                return false;
            x /= 10;
        }
        return true;
    }
}

