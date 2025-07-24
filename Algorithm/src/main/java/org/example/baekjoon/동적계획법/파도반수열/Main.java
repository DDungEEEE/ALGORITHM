package org.example.baekjoon.동적계획법.파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Long> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nums.addAll(Arrays.asList(1L, 1L, 1L, 2L, 2L));

        for(int i  = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            System.out.println(padovan(num));
        }
    }

    public static long padovan(int n){
        if(nums.size() < n){
            for(int i = nums.size(); i < n; i++){
                nums.add(nums.get(i - 1) + nums.get(i - 5));
            }
        }

        return nums.get(n - 1);
    }
}
