package com.madhu.psds.arrays;
//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
//1423. Maximum Points You Can Obtain from Cards

public class MaximumPointsObtainFromCards {
    public static void main(String[] args) {
        MaximumPointsObtainFromCards maximumPointsObtainFromCards = new MaximumPointsObtainFromCards();
        int[] cardPoints = {1,2,3,4,5,6,1};
        maximumPointsObtainFromCards.maxScore(cardPoints,3);
    }
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int temp = 0;
        for(int i=n-k; i<n; i++) {
            temp += cardPoints[i];
        }

        int max = temp;

        for(int i=0; i<k; i++) {
            temp += cardPoints[i];
            temp -= cardPoints[n-k+i];

            if(temp > max)		max = temp;
        }
        return max;
    }
}
