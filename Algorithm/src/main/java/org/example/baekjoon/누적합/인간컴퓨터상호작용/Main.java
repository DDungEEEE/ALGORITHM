package org.example.baekjoon.누적합.인간컴퓨터상호작용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int[][] sum = new int[26][name.length() + 1];

        for(int i = 0; i < name.length(); i++){
            int idx = name.charAt(i) - 'a';
            sum[idx][i] += 1;
        }

        for(int i = 0; i < 26; i++){
            for(int j = 1; j < name.length(); j++){
                sum[i][j] += sum[i][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String findStr = st.nextToken();

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int idx = findStr.charAt(0) - 'a';


            int result = start > 0 ? sum[idx][end] - sum[idx][start - 1] : sum[idx][end];

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }
}
