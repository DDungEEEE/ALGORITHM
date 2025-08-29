package org.example.baekjoon.이분탐색.수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arrA = new int[N];

        for(int i = 0; i < N; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            binarySearch(arrA, Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb.toString());

    }

    public static void binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] == target){
                sb.append(1).append("\n");
                return;
            }else if (arr[mid] < target) {
                left = mid + 1; // 오른쪽으로 이동
            } else {
                right = mid - 1; // 왼쪽으로 이동
            }
        }

        sb.append(0).append("\n");
    }
}
