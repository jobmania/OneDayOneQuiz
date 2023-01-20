package com.algorizm.quiz._프로그래머스_quizlist._06_fibonaccinumber;

import java.util.ArrayList;

public class FibonacciNumber {
    public static void main(String[] args){
        FibonacciNumberSolution solution = new FibonacciNumberSolution();
        int s1 = 50;
        int answer = solution.solution(s1);
        System.out.println("answer = " + answer);
    }
}

class FibonacciNumberSolution {
    // 나머지 연산 (a + b) % m = ((a % m) + (b % m)) % m
    // int(32비트) 정수 범위를 넘어 오버플로우가 발생
    public int solution(int n) {
        ArrayList<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.add(0);
        fibonacciList.add(1);

        for(int i = 2 ; i <= n ; i++ ){
           int j = (fibonacciList.get(i-2)%1234567+fibonacciList.get(i-1)%1234567)%1234567;
            fibonacciList.add(j);
        }
        return fibonacciList.get(n);
    }
}
