package com.madhu.psds.arrays;

public class DuplicateElemenets {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4,4,6};
        int res=0;
        for(int i=0;i<a.length;i++){
            res^=a[i];
        }
        System.out.print(res);
//        System.out.print(4 ^ 6);
//        DuplicateElemenets duplicateElemenets = new DuplicateElemenets();
//        duplicateElemenets.findDuplicate(a);
    }
    public void findDuplicate(int[] arr) {
        int length = arr.length;
        int i;
        for (i = 0; i < length; i++) {
            System.out.println("index " + i  + ", "  + -arr[Math.abs(arr[i])]);
            if (arr[Math.abs(arr[i])] < 0) {
                System.out.println("printed " + Math.abs(arr[i]));
            } else {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
        }
    }
}
