package com.madhu.psds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinaryToDecimal {
    public static void main(String[] args) {
        ConvertBinaryToDecimal convertBinaryToDecimal = new ConvertBinaryToDecimal();
        System.out.println((int)('A'));
    }

    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        return convertBinaryToDecimal(list);
    }

    public int convertBinaryToDecimal(List<Integer> list) {
        int decimal = 0;
        int base = 1;
        int count = list.size() - 1;
        while (count >= 0) {
            int bit = list.get(count);
            decimal = decimal + base * bit;
            base = base * 2;
        }
        return decimal;
    }
}
