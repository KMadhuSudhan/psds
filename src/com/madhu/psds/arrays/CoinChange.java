package com.madhu.psds.arrays;
//https://leetcode.com/problems/coin-change/submissions/
//322. Coin Change

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        CoinChange coinChange = new CoinChange();
        coinChange.coinChange(coins,11);
    }
    public int coinChange(int[] coins, int amount) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);
        HashSet<Integer> v = new HashSet<Integer>();

        int d=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int change = queue.peek();
                if(change == 0) return d;
                queue.poll();
                if(v.contains(change) || change < 0) continue;
                v.add(change);
                for (int i=0;i < coins.length;i++) {
                    queue.add(change - coins[i]);
                }
            }
            d++;
        }
        return -1;
    }
}
