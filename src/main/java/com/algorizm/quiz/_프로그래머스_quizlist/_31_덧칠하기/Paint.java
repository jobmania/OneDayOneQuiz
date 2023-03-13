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
        System.out.println("답 = " + solution.solution(n1,m1,ar1));

    }
}

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        for (int i = 0; i < section.length-1; i++) {
            int i1 = section[i];
            int i2 = section[i+1];
            int diffLeng = i2 - i1;
            while(diffLeng < m){
                diffLeng -= m;
            }
            answer++;

        }
        
        
        
        return answer;
    }
}
