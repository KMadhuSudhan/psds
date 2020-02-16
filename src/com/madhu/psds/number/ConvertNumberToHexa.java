package com.madhu.psds.number;

public class ConvertNumberToHexa {
    public String toHex(int num) {
        String hexa = "";
        char hexchars[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int rem;
        if (num == 0) return "0";
        boolean nonZeroHasCome = false;
        if (num > 0) {
            while (num > 0) {
                rem = num % 16;
                hexa = hexchars[rem] + hexa;
                num = num / 16;
            }
        } else {
            double n = num + Math.pow(2, 32);
            double temp;
            while (n > 0) {
                temp = n % 16;
                char hexaChar =  hexchars[(int) temp];
                if(hexaChar!='0') nonZeroHasCome = true;
                if(!nonZeroHasCome && hexaChar != '0') {
                    hexa = hexchars[(int) temp] + hexa;
                }
                n = n / 16;
            }
        }
        return hexa;
    }

    public static void main(String[] args) {
        ConvertNumberToHexa convertNumberToHexa = new ConvertNumberToHexa();
        System.out.println(-20 >>> 4);
        System.out.println(convertNumberToHexa.toHex(-100000));
    }
}
