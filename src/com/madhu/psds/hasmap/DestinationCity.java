package com.madhu.psds.hasmap;
//https://leetcode.com/problems/destination-city/
//1436. Destination City

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {
    public static void  main(String[] args) {
        DestinationCity destinationCity = new DestinationCity();
    }
    public String destCity(List<List<String>> paths) {
        Map<String,String> map = new LinkedHashMap();
        for(int i=0;i<paths.size();i++) {
            map.put(paths.get(i).get(0),paths.get(i).get(1));
        }
        String des  = map.keySet().iterator().next();
        while(map.get(des)!=null) {
            des = map.get(des);
        }
        return des;
    }
}
