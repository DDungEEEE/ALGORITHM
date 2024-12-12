package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(bufferedReader.readLine());
        double[] numList = new double[n];
        int max = 1;
        int i=0;
        double result=0;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        while (stringTokenizer.hasMoreTokens()){
            int num = Integer.parseInt(stringTokenizer.nextToken());
            numList[i] = num;
            max = Math.max(max, num);
            i++;
        }

        for(int a=0; a<n; a++){
            result += numList[a] / max * 100;
        }

        bufferedWriter.write(result/n + "");
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}