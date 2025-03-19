package org.example.study;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayPractice {
    public static void main(String[] args) {
       int[] answers = {1, 3, 2, 4, 2};
       int[] a1 = {1, 2, 3, 4, 5};
       int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
       int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

       int[] scoreList = {0, 0, 0};

       for(int i=0; i<answers.length; i++){
           if(a1[i%5] == answers[i]){
               scoreList[0]++;
           }
           if(a2[i%a2.length] == answers[i]){
               scoreList[1]++;
           }
           if(a3[i%a3.length] == answers[i]){
               scoreList[2]++;
           }
       }

        int max = Arrays.stream(scoreList).max().getAsInt();

       List<Integer> result = new ArrayList<>();
       for (int i=0; i<3; i++){
           if(scoreList[i] == max){
               result.add(i+1);
           }
       }

        System.out.println(result.stream().sorted().collect(Collectors.toList()));

    }
}
