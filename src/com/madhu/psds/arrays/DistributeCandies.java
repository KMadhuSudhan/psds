package com.madhu.psds.arrays;

public class DistributeCandies {

    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();
        distributeCandies.distributeCandies(7, 4);
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] candiesArray = new int[num_people];
        int count = 0;
        for(int i =1;i<=2*num_people && candies > 0;i++) {
            candiesArray[count++] = candies>=i ? candies : i;
            candies-=i;
            if(count >= num_people){
                count = 0;
            }
        }
       return candiesArray;
    }
}