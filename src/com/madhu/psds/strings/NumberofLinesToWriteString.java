package com.madhu.psds.strings;

public class NumberofLinesToWriteString {
    public static void main(String[] args) {
        int[] widths = new int[] {7,5,4,7,10,7,9,4,8,9,6,5,4,2,3,10,9,9,3,7,5,2,9,4,8,9};
        String s = "zlrovckbgjqofmdzqetflraziyvkvcxzahzuuveypqxmjbwrjvmpdxjuhqyktuwjvmbeswxuznumazgxvitdrzxmqzhaaudztgie";
        NumberofLinesToWriteString numberofLinesToWriteString = new NumberofLinesToWriteString();
        int[] counts = numberofLinesToWriteString.numberOfLines(widths,s);
        System.out.println(counts[0] + " " + counts[1]);
    }

    public int[] numberOfLines(int[] widths, String S) {
        char[] chars = S.toCharArray();
        int length = chars.length;
        int lineCount = 0;
        int totalLineCount = 1;
        for (int i=0;i<length;i++) {
            int width = widths[chars[i] - 'a'];
            if(lineCount == 100) {
                lineCount = 0;
                if(i!= (length -1)) totalLineCount++;
            }
            if((width+lineCount) > 100) {
                lineCount = width;
                totalLineCount++;
            } else {
                lineCount+=width;
            }
        }
        int[] linesAdnUnits = new int[]{totalLineCount,lineCount};
        return linesAdnUnits;
    }
}
