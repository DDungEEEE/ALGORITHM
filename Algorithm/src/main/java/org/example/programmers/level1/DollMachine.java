package org.example.programmers.level1;

import java.util.Stack;

public class DollMachine {
    public static void main(String[] args) {
        DollMachine dollMachine = new DollMachine();
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(dollMachine.solution(null, moves));
    }

    public int solution(int[][] board, int[] moves){

        Stack<Integer> answer = new Stack<>();

        int result = 0;
        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                int doll = board[j][moves[i] - 1];
                if(doll != 0){
                    board[j][moves[i]-1] = 0;
                    if(isBoom(answer, doll)){
                        answer.pop();
                        result += 2;
                    }else{
                        answer.push(doll);
                    }
                break;
                }
            }
        }
        return result;
    }

    public boolean isBoom(Stack<Integer> bucket, int target){
        return !bucket.isEmpty() && bucket.peek() == target;
    }
}
