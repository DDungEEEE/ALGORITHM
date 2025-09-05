package org.example.study.두개뽑아서더하기;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 1};
        Set<Integer> result = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                result.add(arr[i] + arr[j]);
            }
        }

        System.out.println(result.stream().sorted());
    }
}
