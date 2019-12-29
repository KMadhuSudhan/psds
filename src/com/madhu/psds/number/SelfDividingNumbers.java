package com.madhu.psds.number;



import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public static void main(String[] args) {

        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
        System.out.print(selfDividingNumbers.selfDividingNumbers(1, 22));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) ans.add(n);
        }
        return ans;
    }

    private boolean selfDividing(int x) {
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

