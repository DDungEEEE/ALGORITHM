package org.example.programmers.level2.짝지어제거하기;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int solution(String s){
        Deque<Character> store = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(!store.isEmpty() && store.peek() == c){
                store.pop();
            }else{
                store.push(c);
            }
        }


        return store.isEmpty() ? 1 : 0;
    }
}
