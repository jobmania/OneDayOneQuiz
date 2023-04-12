package com.algorizm.quiz._프로그래머스_quizlist._22_우박수열_정적분;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollatzConjecture {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 5;
        int[][] ranges = {{0,0},{0,-1} ,{2,-3}, {3,-3}}; // [33.0,31.5,0.0,-1.0]

        System.out.println(Arrays.toString(solution.solution(k, ranges)));

    }
}

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        // 1. k를 구해서 먼저 그래프를 그리자.  5 라면 5 ⇒ 16 ⇒ 8 ⇒ 4 ⇒2 ⇒ 1 이되어 총 5번만에 1이 됩니다.
        List<Integer> integerList = new ArrayList<>();
        while (true){
            integerList.add(k);
            if(k==1){
                break;
            }
            if(k%2==0){ // 절반
                k = k/2;
            }else {
                k = 3*k+1;
            }
        }
        System.out.println("integerList = " + integerList);
        /// 순서가 x축 좌표, 값이 y축 좌표

        for (int i = 0; i < ranges.length ; i++) {
            int a = ranges[i][0];
            int b = integerList.size()+ranges[i][1]-1;
            if(a>b) {
                answer[i] = -1;
                continue;
            }
            double sum = 0;
            //적분
            for (int j = a; j < b ; j++) {
                double x = integerList.get(j);
                double y = integerList.get(j+1);
                sum += (x+y)/ 2;

            }
            answer[i] = sum;

        }


        return answer;
    }
}
