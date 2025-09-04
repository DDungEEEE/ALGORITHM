package org.example.baekjoon.이분탐색.공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main  {
    static int N;
    static int M;
    static int[] wifi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        // 공유기 개수
        M = Integer.parseInt(st.nextToken());

        wifi = new int[N];
        for(int i = 0; i < N; i++){
            wifi[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(wifi);
        System.out.println(binarySearch());
    }

    static int binarySearch(){
        int left = 1;
        int right = wifi[N - 1] - wifi[0];
        int result = 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if(canInstall(mid)){
                result = Math.max(result, mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return result;
    }

    static boolean canInstall(int distance){
        int count = 1;
        int lastInstalled = wifi[0];

        for(int i = 1; i < N; i++){
            if((wifi[i] - lastInstalled) >= distance){
                count++;
                lastInstalled = wifi[i];
            }
        }

        return count >= M;
    }
}
