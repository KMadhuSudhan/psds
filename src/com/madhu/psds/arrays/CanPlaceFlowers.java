package com.madhu.psds.arrays;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        System.out.println(canPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if (length == 1 && flowerbed[0] == 0) return true;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }

        if (flowerbed[length - 1] == 0 && flowerbed[length - 2] == 0) {
            flowerbed[length - 1] = 1;
            n--;
        }
        for (int i = 1; n > 0 && i < length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
