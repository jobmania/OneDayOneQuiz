package com.algorizm.quiz._프로그래머스_quizlist._31_덧칠하기;

public class Paint {
    public static void main(String[] args) {

        int n1 = 8; //
        int n2 = 5; //
        int n3 = 4;

        int m1 = 4;
        int m2 = 4;
        int m3 = 1;

        int[] ar1 = {2, 3, 6};
        int[] ar2 = {1, 3};
        int[] ar3 = {1, 2, 3, 4};

        Solution solution = new Solution();
        System.out.println("답 = " + solution.solution(n1,m1,ar1)); // 2 , 1,  4

    }
}

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int point = 0 ; // 마지막 칠한 위치
        for (int i : section) {
            if( i > point ){
                answer++;
                point += i + m - 1 ;
            }
        }


        return answer;
    }
}
