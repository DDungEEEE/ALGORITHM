package org.example.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연립 방정식 푸는법
// 다행이 x, y가 유일함 ㅅ발;
public class Function {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // a, b, c, d, e, f 받자
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for(int i=-999; i<=999; i++){
            for(int j=-999; j<=999; j++){
                // a * i + b * j == c -> return;
                // d * i + e * j == f -> return;
                if(a * i + b * j == c && d * i + e * j == f) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}
