package org.example.programmers.level2.괄호회전하기;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String s){
        Map<Character, Character> chars = new HashMap<>();

        int count = 0;

        chars.put(')', '(');
        chars.put(']', '[');
        chars.put('}', '{');

        char[] c = s.toCharArray();

        for(int i = 0; i < c.length; i++){
            Deque<Character> store = new ArrayDeque<>();

            //처음은 회전 X, 1부터 증가할 시
            if(i > 0){
                c = rotation(c);
            }

            boolean isPerfect = false;
            for(char cc : c){
                //{, [, (
                if(chars.containsValue(cc)){
                    store.push(cc);
                }// 비어있거나 쌍이 안맞을떄
                else if(store.isEmpty() || store.peek() != chars.get(cc)){
                    isPerfect = false;
                    break;
                }// 비어있지 않고 쌍이 맞음 -> pop
                else{
                    store.pop();
                }

                isPerfect = true;
            }

            if(isPerfect){
                count++;
            }
        }

        return count;
    }

    public char[] rotation(char[] arr){
        char first = arr[0];

        for(int i = 1; i < arr.length; i++){
            char temp = arr[i];
            arr[i - 1] = temp;
        }
        arr[arr.length - 1] = first;
        return arr;
    }

}
