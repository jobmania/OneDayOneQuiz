package com.algorizm.quiz._프로그래머스_quizlist._25_동적계획법_정수삼각형;

public class Triangle {
    public static void main(String[] args) {
        int[][] array = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        /// i는 다음 행의 i, i+1에서만 접근 가능
        Solution solution = new Solution();
        System.out.println(solution.solution(array));
    }
}

class Solution {

    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] array = new int[triangle.length][triangle.length];  // 7 , 10 15 , 18

        array[0][0] = triangle[0][0];  // 7

        int tempA = 0;
        int tempB = 0;


        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {

                // 첫번째와 끝값은 비교해서 넣을 필요가 없음.
                if(j==0) {
                    array[i][j] = array[i-1][0]+triangle[i][j];
                } else if (j==i) {
                    array[i][j] = array[i-1][i-1]+triangle[i][j];
                }else {
                    tempA = array[i-1][j-1]+triangle[i][j];
                    tempB = array[i-1][j]+triangle[i][j];

                    array[i][j] = Math.max(tempA,tempB); // 둘중 최댓값을 넣기
                    answer = Math.max(answer, array[i][j]); // 그리고 모든 최댓값 비교해서 저장하기..
                }


            }
        }

        return answer;
    }
}
