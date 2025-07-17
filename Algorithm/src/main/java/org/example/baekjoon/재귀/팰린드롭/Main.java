package org.example.baekjoon.재귀.팰린드롭;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 팰린드롬 문제
 * 첫 index의 문자와 마지막 index의 문자를 비교하여
 * 같을 경우 재귀로 다음 문자 비교
 */
public class Main {
    // 재귀 함수 호출 횟수
    static int callCount = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력할 문자열 수
        int n = Integer.parseInt(br.readLine());

        //문자열 담을 배열, 각각의 입력 담기
        String[] words = new String[n];
        for(int i = 0; i < n; i++){
            words[i] = br.readLine();
        }

        for(int i = 0; i < words.length; i++){
            callCount = 0;

            String word = words[i];

            int startIdx = 0; // 시작 index
            int lastIdx = word.length() - 1; // 마지막 index

            int result = solution(word, startIdx, lastIdx);

            // 결과 출력
            System.out.println(result + " " + callCount);
        }
    }

    public static int solution(String word, int startIdx, int lastIdx){
        callCount++;

        // 문자열의 시작한 index가 마지막 index보다 커질시 일치함으로 true 반환
        if(startIdx >= lastIdx){
            return 1;
        }

        if(word.charAt(startIdx) != word.charAt(lastIdx)){
            // 시작 index와 마지막 index의 문자가 다를 경우 false 반환
            return 0;
        } else {
            // 같을 경우 재귀로 다음 문자 비교
            return solution(word, startIdx + 1, lastIdx - 1);
        }
    }
}
