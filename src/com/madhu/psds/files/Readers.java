package com.madhu.psds.files;

import java.io.BufferedReader;

public class Readers {
    String nextLine;
    BufferedReader bufferedReader;

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
    public String getNextLine() {
        return nextLine;
    }

    public void setNextLine(String nextLine) {
        this.nextLine = nextLine;
    }


}
