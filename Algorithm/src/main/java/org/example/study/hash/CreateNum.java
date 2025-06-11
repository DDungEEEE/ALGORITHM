package org.example.study.hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class CreateNum {
    public boolean solution(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        set.addAll(Arrays.stream(arr).boxed().toList());

        for(int i = 0; i < arr.length; i++) {
            int targetValue = target - arr[i];
            if(set.contains(targetValue)){
                if(arr[i] == targetValue){
                    continue;
                }
                return true;
            }

        }
        return false;
    }
}
