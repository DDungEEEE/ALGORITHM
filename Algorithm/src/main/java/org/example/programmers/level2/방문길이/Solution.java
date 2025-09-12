    package org.example.programmers.level2.방문길이;

    import java.util.HashSet;
    import java.util.Set;

    public class Solution {

        public static void main(String[] args) {
            String dirs = "ULURRDLLU";
            String dirs2 = "LULLLLLLU";

            System.out.println(solution(dirs));
    //        System.out.println(solution(dirs2));
        }

        public static class Node{
            int x;
            int y;

            public Node(int x, int y){
                this.x = x;
                this.y = y;
            }

            public int getX(){
                return x;
            }
            public int getY(){
                return y;
            }

            public Node move(String str){
                if(canMove(str)){
                    switch (str){
                        case "L":
                            x -= 1;
                            break;
                        case "R":
                            x += 1;
                            break;
                        case "U":
                            y +=1;
                            break;
                        case "D":
                            y -= 1;
                            break;
                    }

                }

                return this;

            }

            boolean canMove(String str){
                int nx = x, ny = y;
                switch (str){
                    case "L":
                        nx -= 1;
                        break;
                    case "R":
                        nx += 1;
                        break;
                    case "U":
                        ny +=1;
                        break;
                    case "D":
                        ny -= 1;
                        break;
                }

                return nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5;
            }
        }

        public static int solution(String dirs){
            Node node = new Node(0, 0);
            String[] moves = dirs.split("");

            Set<String> visited = new HashSet<>();


            for (String move : moves) {
                int x = node.getX();
                int y = node.getY();
                Node movedNode = node.move(move);

                int movedX = movedNode.getX();
                int movedY = movedNode.getY();

                if(x != movedX || y != movedY){
                    String path1 = x + "," + y + "," + movedX + "," + movedY;
                    String path2 =movedX + "," + movedY + "," + x + "," + y;

                    visited.add(path1);
                    visited.add(path2);
                }


            }

            return visited.size() / 2;
        }

    }
