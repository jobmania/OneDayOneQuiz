package com.algorizm.quiz.백준_quizlist._1_동적계획법.피보나치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24416 {
    //. 재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자.
    static int count = 0;
    static int dyCount = 0;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 스캐너 vs 버퍼리더
        int input = Integer.parseInt(br.readLine());



        fib(input);
        fibDynamic(input);


    }
 // 1 1 2 3 5
    private static int fibDynamic(int input) {
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i < input; i++) {
            dyCount++;
            memo[i] = memo[i-2] + memo[i-1];
        }
        return memo[input-1];
    }







    private static int fib(int input) {
        if(input ==1 || input==2){
            count++;
            return 1;
        }else {
            return fib(input - 1) + fib(input - 2);
        }
    }
}
