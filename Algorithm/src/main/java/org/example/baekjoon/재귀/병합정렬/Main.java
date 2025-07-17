package org.example.baekjoon.재귀.병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int saveCount = 0; // 배열에 저장된 횟수 누적
    static int targetCount = 0; // 목표 저장 횟수
    static int targetNum = -1; // 목표 저장횟수 도달시 저장된 값
    static int[] result; // 병합 과정에서 사용할 임시 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String[] strArr = first.split(" ");

        int n = Integer.parseInt(strArr[0]); // 배열의 크기
        targetCount = Integer.parseInt(strArr[1]); // 목표 저장 횟수

        String nums = br.readLine();
        int[] num = new int[n];
        result = new int[n];

        String[] numStr = nums.split(" ");
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(numStr[i]);
        }

        mergeSort(num, 0, n - 1);

        if(targetNum != -1){
            System.out.println(targetNum);
        }else{
            System.out.println(targetNum);
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 왼쪽 절반 정렬
            mergeSort(arr, left, mid);

            // 오른쪽 절반 정렬
            mergeSort(arr, mid + 1, right);

            //병합
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;     // 왼쪽 배열 시작 idx
        int j = mid + 1;  // 오른쪽 배열 시작 idx
        int k = left;     // 임시 배열 시작 idx

        // 두 배열 비교하며 작은 값을 result에 복사
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                result[k++] = arr[i++];
            } else {
                result[k++] = arr[j++];
            }
        }

        // 두 배열 중 하나는 다 쓰여서 while문 탈출 -> 남은 배열 값 복사
        while (i <= mid) result[k++] = arr[i++];
        while (j <= right) result[k++] = arr[j++];

        // result -> arr 삽입
        for (int t = left; t <= right; t++) {
            arr[t] = result[t];
            saveCount++;

            // 저장 횟수가 일치할시 targetNum에 저장
            if (saveCount == targetCount) {
                targetNum = arr[t];
            }
        }
    }
}
