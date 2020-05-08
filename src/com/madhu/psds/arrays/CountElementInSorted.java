package com.madhu.psds.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountElementInSorted {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        CountElementInSorted countElementInSorted = new CountElementInSorted();
        System.out.println(countElementInSorted.getCount(list));
    }

    int getCount(List<Integer> A) {
        int low = 0,high=A.size()-1,mid = 0;
        while (low<high) {
            mid = low + (high-low)/2;
            if(A.get(mid) == 2) {
                break;
            }
            else if(A.get(mid) < 2) {
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        low = mid - 1;
        int size = 0;
        while (low>=0 && A.get(low) == 2){
            size++;
            low--;
        }
        return size + (mid-1);
    }
}
