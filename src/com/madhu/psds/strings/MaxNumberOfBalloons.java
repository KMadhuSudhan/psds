package com.madhu.psds.strings;

public class MaxNumberOfBalloons {
    public static void main(String[] args) {
        String text = "nlaebolko";
        MaxNumberOfBalloons maxNumberOfBalloons = new  MaxNumberOfBalloons();
        System.out.println(maxNumberOfBalloons.maxNumberOfBalloons(text));
    }
    public int maxNumberOfBalloons(String text) {
        int[] freq=new int[26];
        for(int i=0;i<text.length();i++){
            freq[text.charAt(i)-'a']++;
        }
        int answer=0;
        while(true){
            if(freq['b'-'a']>0 && freq['a'-'a']>0 && freq['n'-'a']>0 && freq['l'-'a']>1 && freq['o'-'a']>1){
                answer++;
                freq['b'-'a']--;
                freq['a'-'a']--;
                freq['n'-'a']--;
                freq['l'-'a']=freq['l'-'a']-2;
                freq['o'-'a']=freq['o'-'a']-2;
            }
            else{
                break;
            }
        }
        return answer;
    }
}
