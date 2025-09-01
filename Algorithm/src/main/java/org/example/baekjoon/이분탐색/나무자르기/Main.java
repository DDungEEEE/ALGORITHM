package org.example.baekjoon.이분탐색.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] trees;
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        // 집으로 가져가려고 하는 나무의 길이
        N = Integer.parseInt(st.nextToken());
        trees = new long[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long lngHeight = 0;

        for(int i = 0; i < M; i++){
            trees[i] = Integer.parseInt(st2.nextToken());
            lngHeight = Math.max(lngHeight, trees[i]);
        }

        System.out.println(binarySearch(lngHeight));


    }

    static long binarySearch(long lngHeight){
        long left = 1;
        long right = lngHeight;
        long maxHeight = 0;

        while (left <= right){
            long mid = (left + right) / 2;
            if(canCutting(mid)){
                maxHeight = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return maxHeight;
    }

    static boolean canCutting(long height){
        long total = 0;

        for(long tree : trees){
            if(tree > height){
                total += (int) (tree - height);
            }
        }

        return total >= N;
    }
}
