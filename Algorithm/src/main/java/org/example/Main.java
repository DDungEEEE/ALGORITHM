package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer ts;

        for(int i = 0; i <count; i++){
           ts = new StringTokenizer(bufferedReader.readLine(), " ");
           bufferedWriter.write((Integer.parseInt(ts.nextToken()) + Integer.parseInt(ts.nextToken()))+ "\n");
        }
        bufferedReader.close();;
        bufferedWriter.flush();;
        bufferedWriter.close();

    }
}