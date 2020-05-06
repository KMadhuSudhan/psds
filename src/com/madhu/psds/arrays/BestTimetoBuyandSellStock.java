package com.madhu.psds.arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
//714. Best Time to Buy and Sell Stock with Transaction Fee

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        BestTimetoBuyandSellStock bestTimetoBuyandSellStock = new BestTimetoBuyandSellStock();
        int[] prices = {1, 3, 2, 8, 4, 9};
        bestTimetoBuyandSellStock.maxProfit(prices,2);
    }
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
