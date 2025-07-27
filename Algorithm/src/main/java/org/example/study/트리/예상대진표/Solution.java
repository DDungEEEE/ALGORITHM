package org.example.study.트리.예상대진표;

public class Solution {
    public static void main(String[] args) {
        int a = 4;
        int b = 7;

        int round = 0;

        while(a != b){
            a = (a + 1) / 2;
            b = (b + 1) / 2;

            round ++;
        }

        System.out.println(round);
    }

}
