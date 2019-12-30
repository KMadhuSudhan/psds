package com.madhu.psds.arrays;

public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 1, 4, 0, 0, 4, 3, 3};
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        sortArrayByParityII.sortArrayByParityII(a);
        sortArrayByParityII.printArray(a, a.length);
    }

    int[] sortArrayByParityII(int[] A) {
        int i = 0, l = A.length;
        while (i < l) {
            while ((i < l) && ((i % 2 == 0 && A[i] % 2 == 0) || (i % 2 == 1 && A[i] % 2 == 1))) {
                i++;
            }
            int k = i;
            if (i % 2 == 1) {
                while (k < l && A[k] % 2 != 1) {
                    k +=1;
                }
            } else {
                while (k < l && A[k] % 2 != 0) {
                    k +=1;
                }
            }
            if(k<l) {
                int temp = A[k];
                A[k] = A[i];
                A[i] = temp;
                i++;
            }
        }
        return A;
    }

    public void printArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
