package com.madhu.psds.arrays;

import java.util.*;

public class SubdomainVisitCount {
    public static void main(String[] args) {
        String[] a = new String[]{"9001 discuss.leetcode.com"};
        SubdomainVisitCount subdomainVisitCount = new SubdomainVisitCount();
        List<String> resultDomains = subdomainVisitCount.subdomainVisits(a);
        subdomainVisitCount.printArray(resultDomains);
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> domainsMap = new LinkedHashMap();
        List<String> resultDomains = new ArrayList();
        int length = cpdomains.length;
        for (int i=0;i<length;i++) {
            String[] visitsAndDoamins = cpdomains[i].split(" ");
            int visits = Integer.valueOf(visitsAndDoamins[0]);
            int visitCount = domainsMap.getOrDefault(visitsAndDoamins[1],0);
            domainsMap.put(visitsAndDoamins[1],visitCount + visits);
            String restOfDoamin =  visitsAndDoamins[1];
            while (restOfDoamin.contains(".")) {
                String[] domains = restOfDoamin.split("\\.",2);
                int count = domainsMap.getOrDefault(domains[1],0);
                domainsMap.put(domains[1],count+visits);
                restOfDoamin = domains[1];
            }
        }
        for (Map.Entry<String,Integer> entry: domainsMap.entrySet()) {
            resultDomains.add(entry.getValue() + " " + entry.getKey());
        }
        return resultDomains;
    }

    public void printArray(List<String> resultDomains) {
        for (String domain: resultDomains) {
            System.out.print(" " + domain);
        }
    }
}
