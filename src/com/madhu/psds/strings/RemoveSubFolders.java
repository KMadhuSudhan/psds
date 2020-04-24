package com.madhu.psds.strings;
//https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
//1233. Remove Sub-Folders from the Filesystem

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveSubFolders {
    public static void main(String[] args) {
        String[] folders = {"/a/b/c", "/a/b/ca", "/a/b/d"};
        RemoveSubFolders removeSubFolders = new RemoveSubFolders();
        System.out.println(removeSubFolders.removeSubfolders(folders));
    }

    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        int length = folder.length;
        boolean[] deletedIndex = new boolean[folder.length];
        set.add(folder[0]);
        for (int i = 1; i < length; i++) {
            String[] words = folder[i].split("/");
            StringBuilder word = new StringBuilder("/");
            for (int j = 1; j < length - 1; j++) {
                word.append(words[j]);
                if (set.contains(word.toString())) {
                    deletedIndex[i] = true;
                    break;
                }
                word.append("/");
            }
            if (deletedIndex[i] == false) {
                set.add(folder[i]);
            }
        }
        set = new HashSet<>();
        set.add(folder[length - 1]);
        for (int i = folder.length - 2; i >= 0; i--) {
            if (deletedIndex[i]) continue;
            String[] words = folder[i].split("/");
            StringBuilder word = new StringBuilder();
            word.append("/");
            for (int j = 1; j < words.length - 1; j++) {
                word.append(words[j]);
                if (set.contains(word.toString())) {
                    deletedIndex[i] = true;
                    break;
                }
                if (j != words.length - 2) word.append("/");
            }
            if (deletedIndex[i] == false) {
                set.add(folder[i]);
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            if (!deletedIndex[i]) {
                list.add(folder[i]);
            }
        }
        return list;
    }

}
