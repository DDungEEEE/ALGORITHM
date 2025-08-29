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
            binarySearch(arrA, Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb.toString());

    }
    static void binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left <= right){
            int mid = (left + right) / 2;

            if (arr[mid] == target){

                count++;
                if(mid - 1 >= 0 && arr[mid - 1] == target){
                    right -= 1;
                }else if(mid + 1 <= arr.length - 1 && arr[mid + 1] == target){
                    left += 1;
                }else{
                    break;
                }
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        sb.append(count).append("\n");
    }
}
