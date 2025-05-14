package org.example.programmers.level3;

import java.util.Stack;

public class EditTable {

    public static void main(String[] args) {
        EditTable editTable = new EditTable();
        String[] cmd ={"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        System.out.println(editTable.solution(8, 2, cmd));
    }
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];

        boolean[] isDeleted = new boolean[n];

        Stack<Integer> deleteStack = new Stack<>();

        for(int i=0; i<n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n-1] = -1;

        for(String c : cmd){
            if(c.startsWith("U")){
                String[] s = c.split(" ");

                int idx = Integer.parseInt(s[1]);
                // 다음 인덱스들을 연결
                for(int j=0; j<idx; j++){
                   if(prev[k] == -1){
                       break;
                   }else{
                       k = prev[k];
                   }
                }
            }else if(c.startsWith("D")){
                String[] s = c.split(" ");

                int idx = Integer.parseInt(s[1]);
                // 다음 인덱스들을 연결
                for(int j=0; j<idx; j++){
                    if(next[k] == -1){
                        break;
                    }else{
                        k = next[k];
                    }
                }
            }else if(c.equals("C")){
                deleteStack.push(k);
                isDeleted[k] = true;
                if(prev[k] != -1) next[prev[k]] = next[k];
                if(next[k] != -1) prev[next[k]] = prev[k];
                k = (next[k] == -1) ? prev[k] : next[k];

            }else{
                Integer rollback = deleteStack.pop();
                isDeleted[rollback] = false;

                if (prev[rollback] != -1) next[prev[rollback]] = rollback;
                if(next[rollback] != -1) prev[next[rollback]] = rollback;
            }
        }
        StringBuilder sb = new StringBuilder();
       for(int i=0; i<n; i++){
           if(isDeleted[i]){
               sb.append("X");
           }else{
               sb.append("O");
           }
       }
       return sb.toString();
    }
}
