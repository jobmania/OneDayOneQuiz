package com.algorizm.quiz._프로그래머스_quizlist._43_당구_연습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PingPong {
    public static void main(String[] args) {

        int m = 10; // 가로
        int n = 10; // 세로
        int startX = 3; // 시작 x
        int startY = 7 ; // 시작 y
        int[][] balls = {{7, 7}, {2,7}, {7,3}}; // 목표위치
        // [52, 37, 116]
        Solution solution = new Solution();
        int[] solution1 = solution.solution(m, n, startX, startY, balls);
        System.out.println("solution1 = " + Arrays.toString(solution1));


        //[52, 37, 116]

    }
}

class Solution {
    // 원쿠션 -> 4방향에서 비교해야됨
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0 ; i < balls.length ; i ++){
            int[] ball = balls[i];

            // 1. 케이스 왼쪽 벽을 맞는다. 하지만 왼쪽선상 y 좌표계가 같고, 해당좌표가 x보다 작다면 예외
            int left =0;
            int plusStartX = startX + ball[0]; // x의 거리
            int y = Math.abs(startY - ball[1]); // y 거리

            if( y!=0 || ball[0] > startX) {
                left = (int) (Math.pow(plusStartX, 2) + Math.pow(y, 2));
            }

           // 2. 케이스 오른쪽 벽을 맞는다. 하지만 오른쪽선상 y 좌표계가 같고, 해장좌표가 x보다 크면 예외
            int right = 0;
            int rightwall = m-startX; // 오른쪽벽까지의 거리
            plusStartX = (m-ball[0]) + rightwall;
            // y 는 동일 .
            if( y!=0 || ball[0] < startX){
                right = (int) (Math.pow(plusStartX, 2) + Math.pow(y, 2));
            }

            // 3. 케이스는 위쪽 벽을 맞는다. 하지만 위쪽선상 x 좌표계가 같고 해당 좌표가 크면 예외
            int top = 0;
            int x = Math.abs(startX-ball[0]);
            int topwall = n - startY;
            int plusStartY = (n-ball[1]) + topwall;

            if(x!= 0  || ball[1] < startY){
                top = (int) (Math.pow(x, 2) + Math.pow(plusStartY, 2));
            }

            // 4. 케이스는 아랫쪽 벽을 맞느다. 하지만 아래쪽 선상에 x좌표계가 같고 해당좌표보다 작다면 예외
            int bottom = 0;
            // x는동일
            plusStartY = startY + ball[1];

            if(x!= 0  || ball[1] > startY){
                bottom = (int) (Math.pow(x, 2) + Math.pow(plusStartY, 2));
            }




            int[] values = { left,right, top,bottom };

            int minNonZero = 0; // 0이 아닌 가장 작은 값 저장 변수

            for (int value : values) {
                if (value != 0) {
                    if (minNonZero == 0 || value < minNonZero) {
                        minNonZero = value;
                    }
                }
            }

            answer[i] = minNonZero;
        }



        return answer;
    }
}