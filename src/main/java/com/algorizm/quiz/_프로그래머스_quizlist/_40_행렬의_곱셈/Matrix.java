package com.algorizm.quiz._프로그래머스_quizlist._40_행렬의_곱셈;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(arr1, arr2)));
    }
}


/// 앞행은 행
/// 뒤행은 열
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];


        for (int i = 0; i < arr1.length; i++) { // 첫번째 행렬의 행을 증가
            for (int j = 0; j < arr2[0].length; j++) { // 두번째 행렬의 열을 증가
                for (int k = 0; k < arr1[i].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }


            }


        }

        return answer;
    }
}