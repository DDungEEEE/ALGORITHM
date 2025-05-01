package org.example.programmers.level2;

import java.util.Stack;

public class TeamsTown {
    public static void main(String[] args) {
        String s = "baabaa";
        String s2 = "cdcd";

        System.out.println(solution(s));
    }
    static int solution(String s){
        String[] str = s.split("");
        Stack<String> result = new Stack<>();
        for(int i=0; i<str.length; i++){
            if(!result.isEmpty() && result.peek().equals(str[i])){
                result.pop();
            }else{
                result.push(str[i]);
            }
        }
        return result.isEmpty() ? 1 : 0;
    }
}
