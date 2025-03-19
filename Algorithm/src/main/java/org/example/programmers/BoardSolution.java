package org.example.programmers;

public class BoardSolution {
    public static void main(String[] args) {
        String[][] colors = {
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}
        };
        int h = 1;
        int w = 1;

        System.out.println(solution(colors, h, w));
    }

    /**
     * 2차원 격자 보드판에서, 위, 아래, 왼쪽, 오른쪽 칸 중 같은 색깔로 칠해진
     * 칸의 개수 구하는 Algorithm
     * h , w : 고른 칸의 위치
     */
    public static int solution(String[][] board, int h, int w){
        int count = 0;
        int n = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        String searchColor = board[h][w];

        for(int i=0; i<4; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if((w_check >=0 && w_check < n) && (h_check >= 0 && h_check < n)){
                if(searchColor.equals(board[h_check][w_check])){
                    count++;
                }
            }
        }
        return count;
    }

}
