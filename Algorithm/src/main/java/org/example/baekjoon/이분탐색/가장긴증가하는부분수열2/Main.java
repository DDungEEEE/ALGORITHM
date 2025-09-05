package org.example.baekjoon.이분탐색.가장긴증가하는부분수열2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수열 길이

        int[] arr = new int[N];
        int[] lis = new int[N];

        int length = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int num : arr){
            int idx = lowerBound(0, length, lis, num);
            lis[idx] = num;

            if(idx == length){
                length += 1;
            }
        }

        System.out.println(length);

    }

    static int lowerBound(int left, int right, int[] arr, int target){
        while (left < right){
            int mid = (left + right) / 2;

            if(arr[mid] >= target){
                right = mid;
            }else{
               left = mid + 1;
            }
        }

        return right;

    }
}
