package com.madhu.psds.arrays;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        BinaryWatch binaryWatch = new BinaryWatch();
        System.out.print(Integer.bitCount(7));
        binaryWatch.readBinaryWatch(1);
    }
    public List<String> readBinaryWatch(int num) {
        int i,j;
        List<String> p=new ArrayList<>();
        int l;

        for(i=0;i<=11;i++)
        {
            for(j=0;j<=59;j++)
            {
                if((bit(i)+bit(j))==num)
                {
                    String s="";
                    if(j>9)
                        s=Integer.toString(i)+':'+Integer.toString(j);
                    else
                        s=Integer.toString(i)+':'+'0'+Integer.toString(j);

                    p.add(s);
                }
            }
        }
        return p;
    }

    int bit(int n)
    {
        int count=0;
        while(n!=0)
        {
            if(n%2!=0)
                count++;
            n=n/2;
        }

        return count;
    }
}
