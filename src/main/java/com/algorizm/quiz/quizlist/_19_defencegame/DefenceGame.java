package com.algorizm.quiz.quizlist._19_defencegame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DefenceGame {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] array = {4, 2, 4, 5, 3, 3, 1}; // ANSWER = 5

        Solution solution = new Solution();
        System.out.println("solution.solution() = " + solution.solution3(n, k, array));


    }

}

class Solution {
    public int solution(int n, int k, int[] enemy) {
        //  출력크기 조과라고 뜨는데!!

        int answer = 0;
        List<Integer> integerList = new ArrayList<>();

        // k수보다 작거나 같은 스테이지는 스테이지 수만큼 주기
        if (enemy.length <= k) {
            return enemy.length;
        }


        /// 최소한 k 수만큼 스테이지는 클리어 가능.
        for (int i = 0; i < k; i++) {
            integerList.add(enemy[i]);       // [4,2,4], k=3
        }
        answer = k;

        int tempK = k; // 순서
        int tempN = n;  // n의 토탈값..

        /// 하나씩 배열에 넣고 가장큰 k개의 숫자만 제거하고 그 합이 n보다 작다면 ok
        Loop:
        while (true) {
            integerList.add(enemy[tempK]);
            // 내림차순 정렬해서
            Collections.sort(integerList, Collections.reverseOrder());

            for (int i = k; i < integerList.size(); i++) {
                tempN = tempN - integerList.get(i);
                if (tempN < 0) {
                    break Loop;
                }
            }
            tempK++;
            answer = tempK;
            tempN = n;
        }


        return answer;
    }


    // 이분탐색으로 풀어보자! 특정 범위 내의 탐색을 log(N)으로 끝낼 수 있기 때문
    public int solution2(int n, int k, int[] enemy) {
        int left =0;
        int right = enemy.length;

        while(left < right){
            int mid = (left + right ) / 2;

            // 만약 mid 위치가 막을 수 있는 위치라면 left 위치를 mid로 이동.
            // 만약 mid 위치가 막을 수 없는 위치라면 right 위치를 mid로 이동.

        }
        return left;
    }

    //PriorityQueue  타입으로 풀어보자! 우선순위가 높은 엘리먼트가 먼저 나가는 자료구조
    public int solution3(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 작은 수 부터 넣는 방식 { 2,4,1} -> [1 , 2, 4]로 들어간다.

        for(int i = 0; i<enemy.length; i++){
            queue.add(enemy[i]);

            // k까지는 round는 무조건 성공한다. k보다 라운드가 크다면 큰수부터 제거.
            if(queue.size()>k){
                Integer smallNum = queue.poll();
                n -= smallNum; // 가장 작은수를 뺀다.

                if(n<0){
                    break;
                }
            }

            answer++;
        }
        return answer;
    }

}