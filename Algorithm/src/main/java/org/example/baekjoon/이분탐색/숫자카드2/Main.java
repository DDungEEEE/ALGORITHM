package org.example.baekjoon.이분탐색.숫자카드2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
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
            int target = Integer.parseInt(st.nextToken());
            int count = upperBound(arrA, target) - lowerBound(arrA, target);
            sb.append(count).append(" ");
        }

        System.out.println(sb.toString());

    }
    // target 이상 처음 나오는 인덱스
    static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // target 초과 처음 나오는 인덱스
    static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
