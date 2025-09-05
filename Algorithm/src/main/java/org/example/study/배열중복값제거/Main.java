package org.example.study.배열중복값제거;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 1, 3, 4};

        Integer[] arr2 = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(arr2, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr2));
    }
}
