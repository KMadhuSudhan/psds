package com.madhu.psds.strings;
//https://leetcode.com/problems/top-k-frequent-words/submissions/
//692. Top K Frequent Words

import java.util.*;

public class TopKFreqWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> countMap = new HashMap<>();
        int length = words.length;
        for (int i=0;i< length;i++) {
            int count = countMap.getOrDefault(words[i],0);
            countMap.put(words[i],count+1);
        }
        SortedSet<String> sortedSet = new TreeSet<String>(new WordCountComparator(countMap));

        /* Add the words into a ordered set sorted by the count */
        Iterator<String> keys = countMap.keySet().iterator();
        while(keys.hasNext()) {
            sortedSet.add(keys.next());
        }

        List<String> result = new ArrayList<>();
        for(String entry:  sortedSet) {
            if(k<0) break;
            result.add(entry);
            k--;
        }
        return result;
    }

    class WordCountComparator implements Comparator<String> {
        Map<String, Integer> counts;
        public WordCountComparator(Map<String, Integer> counts) {
            this.counts = counts;
        }

        public int compare(String a, String b) {
            /* If the word count is different, sort desc by count. Otherwise sort ASC lexicographically.
                Keep in mind that if we only compare by the count, we will only store one word per count in the set (no dups). */
            int countComparison = counts.get(b) - counts.get(a);
            return countComparison != 0 ? countComparison : a.compareTo(b);
        }
    }

    public static void main(String[] args) {
        TopKFreqWords topKFreqWords = new TopKFreqWords();
        String[] strings = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFreqWords.topKFrequent(strings,2);
    }
}
