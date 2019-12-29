package com.madhu.psds.strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public static void main(String[] args) {
        UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();
        String[] emails = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        String[] emails2 = new String[] {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(uniqueEmailAddresses.numUniqueEmails(emails));

    }
    public int numUniqueEmails(String[] emails) {
        Set<String> emailAddress = new HashSet();
        for (String email: emails) {
            String[] emailAndDomain = email.split("@");
            StringBuilder sb = new StringBuilder();
            for(char charc: emailAndDomain[0].toCharArray()) {
                if(charc == '+') {
                    break;
                }
                if(charc == '.') {
                    continue;
                }
                sb.append(charc);
            }
            String resultEmail = sb.append("@").append(emailAndDomain[1]).toString();
            emailAddress.add(resultEmail);
        }
        return emailAddress.size();
    }
}
