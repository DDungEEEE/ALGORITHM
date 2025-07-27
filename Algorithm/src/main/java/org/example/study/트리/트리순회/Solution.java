package org.example.study.트리.트리순회;

import javax.swing.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        String[] result = new String[3];
        result[0] = preOrder(arr, 0);
        result[1] = inOrder(arr, 0);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    private static String preOrder(int[] nodes, int idx){
        if(idx >= nodes.length){
            return "";
        }

        return nodes[idx] + " " +
                preOrder(nodes, 2 * idx + 1) +
                preOrder(nodes, 2 * idx + 2);
    }

    private static String inOrder(int[] nodes, int idx){
        if(idx >= nodes.length){
            return "";
        }

        return inOrder(nodes, 2 * idx + 1) +      // 왼쪽 자식 순회
                nodes[idx] + " " +                 // 루트 방문
                inOrder(nodes, 2 * idx + 2);
    }
}
