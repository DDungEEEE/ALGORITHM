package org.example.study.트리.양과늑대;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static class Info{
        int node;
        int sheep;
        int wolf;
        HashSet<Integer> canVisited;

        public Info(int node, int sheep, int wolf, HashSet<Integer> canVisited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.canVisited = canVisited;
        }
    }

    public static ArrayList<Integer>[] tree;

    public static void makeTree(int[] info, int[][] edges){
        tree = new ArrayList[info.length];

        for(int i = 0 ; i < info.length; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            tree[edges[i][0]].add(edges[i][1]);
        }
    }

    public int solution(int[] info, int[][] edges){
        // info -> 트리 정보
        // edges -> 트리의 간선 정보

        makeTree(info, edges);

        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));
        int count = -1;

        while(!queue.isEmpty()){
            Info cur = queue.poll();

            //양의 개수 업데이트
            count = Math.max(count, cur.sheep);
            HashSet<Integer> canVisited = cur.canVisited;

            // 방문할 수 있는 노드들을 모두 추가
            canVisited.addAll(tree[cur.node]);

            for(int next : canVisited){
                HashSet<Integer> visited = new HashSet<>(canVisited);

                visited.remove(next);

                if(info[next] == 1){
                    if(cur.sheep > cur.wolf + 1){
                        queue.add(new Info(next, cur.sheep, cur.wolf + 1, visited));
                    }
                }else{
                    queue.add(new Info(next, cur.sheep + 1, cur.wolf, visited));
                }
            }
        }
        return count;
    }

}