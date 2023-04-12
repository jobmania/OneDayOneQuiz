package com.algorizm.quiz._프로그래머스_quizlist._14_멀리_뛰기;

public class JumpToJump {
    public static void main(String[] args) {
        solution2 solution = new solution2();
        int s1 = 4;
        System.out.println("answer 은 " + solution.solution(s1) );
    }
}

class JumpToJumpSolution {
    public long solution(int n) {
        // 한칸, 두칸만 가능. 5일때 1,1,1,1,1 1개
        //  2,1,1,1 4개 ( 4C1) / 2,2,1 3개 ( 3C2) -> 8개 // 가장 쉬운방법은 list로 넣어서 전체 갯수 새고 2 세고 방법인데..
        long answer = 0 ;
        int count = 0; // 2의 갯수

        while(true) {
            if(count==0){
                count++;
                answer++;
                continue;
            }
            if((n/2+n%2)<count) break;

            for(int i = 1 ; i <= n/2+n%2 ; i++ ){
                // 5인경우 4c1 + 3c2
                // 100인 경우 99c1 + 98c2 + 97c3 .... + 45c45
                // 복잡도 때문에 fail...
            }

        }

        return answer;
    }
}

class solution2{
    public long solution(int n) {



        // 1인 경우 1
        // 2인 경우 1+1, 2
        // 3인 경우 1+1+1, 2+1, 1+2
        // 4인 경우 1+1+1+1, 2+1+1, 1+2+1, 1+1+2, 2+2

        // 해당 i-2번째의 경우 +2를 더하면 i번 수가 되므로 i-2번째의 경우의 수와 i-1번의 +1을 경우의 수를 더하면 i번의 경우의 수가 된다.
        // 피보나치;



        long[] answerList = new long[2001];

        answerList[0] = 1;
        answerList[1] = 2;

        for(int i = 2 ; i<2001; i++){
            answerList[i] = (answerList[i-1] + answerList[i-2])%1234567;

        }

        return answerList[n-1];
    }
}