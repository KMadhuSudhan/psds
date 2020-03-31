package com.madhu.psds.arrays;

import java.util.*;

public class InvalidTransactions {

    class Transaction {
        String name;
        int minutes;
        int amount;
        String city;
        String str;

        Transaction(String transaction) {
            String[] tuple = transaction.split(",");

            name = tuple[0];
            minutes = Integer.valueOf(tuple[1]);
            amount = Integer.valueOf(tuple[2]);
            city = tuple[3];
            str = transaction;
        }

        public String toString() {
            return str;
        }
    }

    public static void main(String[] args) {
        String[] transactions = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        InvalidTransactions invalidTransactions = new InvalidTransactions();
        List<String> result = invalidTransactions.invalidTransactions(transactions);
        System.out.println(result);
    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> map = new HashMap();
        Set<String> result = new HashSet<>();
        for (String transaction : transactions) {
            Transaction tran = new Transaction(transaction);
            String name = tran.name;
            if (map.containsKey(name)) {
                map.get(name).add(tran);
            } else {
                List<Transaction> transactionList = new ArrayList<>();
                transactionList.add(tran);
                map.put(name, transactionList);
            }
        }
        for (Map.Entry<String, List<Transaction>> entry : map.entrySet()) {
            List<Transaction> transactionList = entry.getValue();
            Collections.sort(transactionList, (a, b) -> a.minutes - b.minutes);

            for (int i = 0; i < transactionList.size(); i++) {
                Transaction transaction = transactionList.get(i);
                boolean isValid = true;

                if (transaction.amount > 1000) {
                    result.add(transaction.str);
                    isValid = false;
                }
                int left = i - 1;

                while (isValid && i >= 0 && transaction.minutes - transactionList.get(left).minutes <=60 ) {
                    if(!transaction.city.equals(transactionList.get(left))) {
                        isValid = false;
                        result.add(transaction.str);
                    }
                    left--;
                }

                int right = i + 1;
                while (isValid && right < transactionList.size() && transactionList.get(right).minutes - transaction.minutes  <=60 ) {
                    if(!transaction.city.equals(transactionList.get(left))) {
                        isValid = false;
                        result.add(transaction.str);
                    }
                    right++;
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (String tran: result){
            list.add(tran);
        }
        return list;
    }
}
