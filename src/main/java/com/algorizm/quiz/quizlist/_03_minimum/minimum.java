package com.algorizm.quiz.quizlist._03_minimum;

import java.util.Arrays;

public class minimum {
    public static void main(String[] args){
    SolutionMinimum solutionMinimum = new SolutionMinimum();
    int [] arr1 = {1, 2};
    int [] arr2 = {3, 4};
    int [] arr3 = {1, 4, 2};
    int [] arr4 = {5,4, 4};

    int answer = solutionMinimum.solution(arr3,arr4);
        System.out.println(answer);
    }

}

class SolutionMinimum
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        // 한배열은 오름차순 다른 배열은 내림차순

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0 ; i < A.length ; i++){
            answer += A[i]*B[A.length-i-1];
        }
        return answer;
    }
    /// 시간초과 테스트 실패





}
