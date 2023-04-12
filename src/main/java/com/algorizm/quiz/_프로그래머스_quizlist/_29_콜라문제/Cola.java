package com.algorizm.quiz._프로그래머스_quizlist._29_콜라문제;

public class Cola {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a1 = 2 ;
        int b1 = 1 ;
        int n1 = 20;
        System.out.println("1번 " + solution.solution(a1,b1,n1));


        int a2 = 3;
        int b2 = 1;
        int n2 = 20;
//        System.out.println("2번 " + solution.solution(a2,b2,n2));
    }

}

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(n>=a){
            answer += (n/a)*b;
            n = (n/a)*b + n%a;
        }



        return answer;
    }
}