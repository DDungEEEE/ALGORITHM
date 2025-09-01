package org.example.baekjoon.이분탐색.랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int N;
    static long[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken()); // 랜선 개수
        N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        lines = new long[K];
        long lngLine = 0; // 제일 긴 랜선

        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            lngLine = Math.max(lines[i], lngLine);
        }

        System.out.println(binarySearch(lngLine));;

        // 입력 확인용

    }

    public static boolean isEnough(long length){
        int count = 0;
        for(int i = 0; i < lines.length; i++){
            count += (int) (lines[i] / length);
        }

        return count >= N;
    }

    public static long binarySearch(long lngLine){
        long left = 1;
        long right = lngLine;
        long maxLength = 0;

        while (left <= right){
            long mid = (left + right) / 2;

            if(isEnough(mid)){
                maxLength = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return maxLength;
    }
}