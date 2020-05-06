package com.madhu.psds.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();

        if(label == 1){
            list.add(1);
            return list;
        }

        int numLevels = (int) (Math.log(label) / Math.log(2))+1;
        int flag = 1;

        while(numLevels >= 1){

            if(flag == 1){
                list.add(label);
                flag = 0;
            }
            else{
                int levelStartNo = (int)Math.pow(2, numLevels-1);
                int levelEndNo = (int)(Math.pow(2, numLevels))-1;
                list.add(levelStartNo + (levelEndNo - label));
                flag = 1;
            }

            label = label/2;
            numLevels = (int) (Math.log(label) / Math.log(2))+1;
        }

        Collections.reverse(list);
        return list;
    }
}
