package org.example.programmers.level2.올바른괄호;

import java.util.Stack;

public class Solution {
    boolean solution(String s){
        boolean answer = true;
        Stack<Character> result = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                result.push('(');
            }else if(result.isEmpty() && c == ')'){
                return false;
            }else{
                result.pop();
            }
        }

        return result.isEmpty();
    }
}
