package com.madhu.psds.files;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        String fileNames = "file1.txt,file2.txt,file3.txt";
        String[] array = fileNames.split(",");

        String basePath = "/Users/konda.madhusudhan/MyProjects/psds/src/com/madhu/psds/files/";

        //files list
        List<BufferedReader> bufferedReaders = new ArrayList<>();
        try {
            for (int i = 0; i < array.length; i++) {
                InputStream in = new FileInputStream(new File( basePath + array[i]));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                bufferedReaders.add(reader);
            }
            NameSorter nameSorter = new NameSorter();
            while (true) {
                List<Readers> readers = new ArrayList<>();
                Boolean anyReaderExist = false;
                for (BufferedReader bufferedReader : bufferedReaders) {
                    Readers reader = new Readers();
                    reader.setBufferedReader(bufferedReader);
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        anyReaderExist = true;
                        reader.setNextLine(line);
                    }
                    readers.add(reader);
                }
                Collections.sort(readers, nameSorter);
                if (anyReaderExist == false) break;
            }
        } catch (IOException io) {
            System.out.println("io Exception");
        }
    }

    static class NameSorter implements Comparator<Readers> {
        @Override
        public int compare(Readers o1, Readers o2) {
            if(o1 == null) return -1;
            if(o2 == null) return 1;
            if(o1 == null && o2 == null) return 0;
            if(o1.getNextLine() == null && o2.getNextLine() == null) return 0;
            if(o1.getNextLine() == null) return  -1;
            if(o2.getNextLine() == null) return 1;
            return o1.getNextLine().compareTo(o2.getNextLine());
        }
    }
}
