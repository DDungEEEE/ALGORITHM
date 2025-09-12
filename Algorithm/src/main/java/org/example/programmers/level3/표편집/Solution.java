package org.example.programmers.level3.표편집;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

        String result = s.solution(n, k, cmd);
        System.out.println(result); // 기대값: OOOOXOOO
    }

    public static String solution(int n , int k, String[] cmd){
        boolean[] deleted = new boolean[n];
        Deque<Integer> deletedRow = new ArrayDeque<>();

        int curIdx = k;
        //해당 인덱스의 이전 값
        int[] prev = new int[n + 2];
        //해당 인덱스의 이후 값
        int[] next = new int[n + 2];

        for(int i = 0; i < n; i++){
            prev[i] = i - 1;

            if(i == n - 1){
                next[i] = -1;
            }else{
                next[i] = i + 1;
            }

        }

        for(int i = 0; i < cmd.length; i++){
            String command = cmd[i];


            if(command.length() >= 3){
                String[] str = command.split(" ");

                String main = str[0];
                int height = Integer.parseInt(str[1]);

                for(int j = 0; j < height; j++){
                    if(main.equals("D")){
                        curIdx = next[curIdx];
                    }else{
                        curIdx = prev[curIdx];
                    }
                }

            }else{
                // 삭제
                if(command.equals("C")){
                    deleted[curIdx] = true;
                    // 쓰레기통에 삭제된 행 추가
                    deletedRow.push(curIdx);
                    // 마지막 행일 때
                    if(next[curIdx] == -1){
                        next[prev[curIdx]] = -1;

                        curIdx = prev[curIdx];
                    }else if(prev[curIdx] == -1){
                        prev[next[curIdx]] = -1;
                        curIdx = next[curIdx];
                    }
                    else{
                        int prevIdx = prev[curIdx];
                        int nextIdx = next[curIdx];

                        next[prevIdx] = nextIdx;
                        prev[nextIdx] = prevIdx;

                        curIdx = nextIdx;
                    }
                }
                // 되돌리기
                else{
                    Integer rollBack = deletedRow.pop();
                    deleted[rollBack] = false;

                    if(prev[rollBack] != -1){
                        next[prev[rollBack]] = rollBack;
                    }

                    if(next[rollBack] != -1) {
                        prev[next[rollBack]] = rollBack;
                    }

                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for(boolean delete : deleted){
            String a = (delete) ? "X" : "O";
            sb.append(a);
        }

        return sb.toString();
    }
}
