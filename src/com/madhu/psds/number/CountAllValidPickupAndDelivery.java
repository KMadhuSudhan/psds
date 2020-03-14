package com.madhu.psds.number;
//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/submissions/
//1359. Count All Valid Pickup and Delivery Options
//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/522093/Java-Actually-a-simple-mathematical-problem
public class CountAllValidPickupAndDelivery {
    public static void main(String[] args) {
        CountAllValidPickupAndDelivery countAllValidPickupAndDelivery = new CountAllValidPickupAndDelivery();
        countAllValidPickupAndDelivery.countOrders(2);
    }
    public int countOrders(int n) {
        long res = 1;
        long mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            res = res * (2 * i - 1) * i % mod;
        }
        return (int)res;
    }
}
