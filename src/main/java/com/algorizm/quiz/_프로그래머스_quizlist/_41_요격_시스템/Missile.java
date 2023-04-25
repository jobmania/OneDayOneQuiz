package com.algorizm.quiz._프로그래머스_quizlist._41_요격_시스템;

import java.util.Arrays;

public class Missile {
    public static void main(String[] args) {
        int[][] array = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};


        Solution solution = new Solution();
        int result = solution.solution(array);
        System.out.println("result = " + result);

    }
}

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // 배열의 2번째  순으로 정렬, 같다면 1번째 숫자가 빠른 것부터 정렬을 진행
        // 1번째 배열에 마지막에 요격을 배치하고, 이후 배열에 포함되어있는지 판단
        // 포함되어있지 않다면 요격을 하나더 추가하고, 이 요격 또한 배열의 마지막에 배치

        /// 정렬을 먼저 하자.
        // [[1, 4], [4, 5], [3, 7], [4, 8], [5, 12], [11, 13], [10, 14]]
        Arrays.sort(targets, (int[] i1, int[] i2) -> {
            if(i1[1]==i2[1]){
                return i1[0]-i2[0];
            }
            return i1[1] - i2[1];
        });

        int[] firstTarget = targets[0];
        int missileTarget = firstTarget[1];
        answer++;

        for (int i = 1; i < targets.length; i++) {
            int[] target = targets[i];
            if(missileTarget>target[0]){
                continue;
            }
            answer++;
            missileTarget = target[1];
        }


        return answer;
    }
}