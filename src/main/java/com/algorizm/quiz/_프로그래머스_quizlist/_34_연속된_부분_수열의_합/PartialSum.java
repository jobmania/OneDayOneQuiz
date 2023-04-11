package com.algorizm.quiz._프로그래머스_quizlist._34_연속된_부분_수열의_합;

import java.util.*;

public class PartialSum {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 1, 1, 2, 3, 4, 5};
        int[] arr3 = {2, 2, 2, 2, 2};

        int k1 = 7;
        int k2 = 5;
        int k3 = 6;

        Solution solution = new Solution();
        int[] solution1 = solution.solution(arr1, k1);
        int[] solution2 = solution.solution(arr2, k2);
        int[] solution3 = solution.solution(arr3, k3);

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));



    }
}

class Solution {
    public int[] solution(int[] sequence, int k) {
        int startNum = 0;
        int endNum = 0;
        int originK = k;

        List<SubSequence> subs = new ArrayList<>();

        for (int i = 0; i < sequence.length; i++) {
            int temp = sequence[i];
            k -= temp;
            if(k<0){
                // 초과시 초기화 및 다음 순번으로!!
                i = startNum;
                startNum++;
                k = originK;
            }

            if(k==0){
                endNum = i;
                subs.add(new SubSequence(startNum, endNum));
                i = startNum;
                startNum++;
                k = originK;
            }
        }

// 조건 비교 1. 첫번째 ,마지막값 차이 비교시 가장 작은값이 나오도록

        Comparator<SubSequence> comparator = new Comparator<SubSequence>() {

            /**
             - 현재 객체 < 파라미터로 넘어온 객체 : 음수 리턴
             - 현재 객체 == 파라미터로 넘어온 객체 : 0 리턴
             - 현재 객체 > 파라미터로 넘어온 객체 : 양수 리턴
             - 음수 또는 0이면 객체의 자리가 그대로 유지됨.
             - 양수일 경우 두 객체의 자리가 바뀐다.
             **/
            @Override
            public int compare(SubSequence o1, SubSequence o2) {
                if ((o1.last - o1.first) == (o2.last - o2.first)) {
                    return o1.first - o2.first;
                } else {
                    return (o1.last - o1.first) - (o2.last - o2.first);
                }
            }
        };
        Collections.sort(subs, comparator);


        return new int[]{subs.get(0).first, subs.get(0).last};
    }

    private class SubSequence {
        int first;
        int last;
        int size;

        public SubSequence(int first, int last) {
            this.first = first;
            this.last = last;
            this.size = last - first;
        }

    }
}