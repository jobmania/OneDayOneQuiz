package com.algorizm.quiz._프로그래머스_quizlist._46_공원산책;

import java.util.Arrays;

public class Park {
    public static void main(String[] args) {
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

        Solution solution = new Solution();
        int[] solution1 = solution.solution(park, routes);
        System.out.println("solution1 = " + Arrays.toString(solution1)); // [0,0]

        String[] park3 = {"SOO","OOO","OOO"};
        String[] routes3 = {"E 2","S 2","W 1"};  ///[2,1]
        int[] solution2 = solution.solution(park3, routes3);
        System.out.println("solution2 = " + Arrays.toString(solution2));


        String[] park2 = {"SOO","OXX","OOO"};
        String[] routes2 = {"E 2","S 2","W 1"}; // [0,1]
        int[] solution3 = solution.solution(park2, routes2);
        System.out.println("solution3 = " + Arrays.toString(solution3));


    }
}


class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x = park[0].length(); // x축크기 (0이상)
        int y = park.length; // y축 크기

        // 좌측상단이 0, 0 시작점
        int startX= 0;
        int startY= 0;

        // 행렬 그리기
        String[][] parkMap = new String[y][x];

        // Start위치 추출하기 및 좌표에 S,X 위치 표시하기
        for (int i = 0 ; i < park.length ; i ++){
            for(int j = 0 ; j < park[i].length() ; j ++){
                char c = park[i].charAt(j);

                if (c == 'S'){
                    startX = j;
                    startY = i;
                }

                if (c == 'X'){
                    parkMap[i][j] = "X";
                }else {
                    parkMap[i][j] = "O";
                }
            }
        }

        System.out.println("parkMap = " + Arrays.deepToString(parkMap));


        int pointX=startX;
        int pointY=startY;


        // 루트 시작!
        for(String route : routes){
            char direction = route.charAt(0); // E,W,N,S;
            String[] split = route.split(" ");
            int distance  = Integer.parseInt(split[1]); // 거리 추출

            int tempX = pointX;
            int tempY = pointY;
            boolean check = true;

            for(int i = 0 ; i < distance ;  i ++){

                try {
                    switch (direction){

                        case 'E':
                            String target = parkMap[tempY][tempX+1];
                            if(target.equals("X")){
                                throw new Exception();
                            }
                            tempX++;
                            break;
                        case 'W':
                            target = parkMap[tempY][tempX-1];
                            if(target.equals("X")) {

                                throw new Exception();

                            }
                            tempX--;
                            break;
                        case 'N':
                            target = parkMap[tempY-1][tempX];
                            if(target.equals("X")) {
                                throw new Exception();
                            }
                            tempY--;
                            break;
                        case 'S':
                            target = parkMap[tempY+1][tempX];
                            if(target.equals("X")) {
                                throw new Exception();
                            }
                            tempY++;

                            break;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    check = false;
                    break;
                }

            }

            if(check){
                pointX = tempX;
                pointY = tempY;
            }



        }
        answer[1] = pointX; // 가로방향
        answer[0] = pointY;// 세로방향
        return answer;
    }
}