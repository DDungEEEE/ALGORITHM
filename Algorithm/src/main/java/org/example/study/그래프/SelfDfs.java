package org.example.study.그래프;

import java.util.ArrayList;
import java.util.List;

public class SelfDfs {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 5;
        visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(3).add(5);

        dfs(1);
    }

    public static void dfs(int idx){
        visited[idx] = true;
        List<Integer> nodes = graph.get(idx);

        for(int node : nodes){
            if(visited[node]){
                visited[node] = false;

            }
        }
    }
}
