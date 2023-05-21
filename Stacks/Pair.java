package com.mashukh.Stacks;

public class Pair implements Comparable<Pair> {
    int st;
    int et;

    public Pair(int st, int et) {
        this.st = st;
        this.et = et;
    }

    public int compareTo(Pair other) {
        return this.st - other.st;
    }


}


