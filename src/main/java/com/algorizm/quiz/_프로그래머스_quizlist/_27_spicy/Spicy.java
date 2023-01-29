package com.algorizm.quiz._프로그래머스_quizlist._27_spicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Spicy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        int k = 7;
        int[] arr = {1, 2, 3, 9, 10, 12};
//        System.out.println(solution.solution(arr,k));
        System.out.println(solution2.solution(arr,k));

        int[] arr2 = {1,2,3,9,10,12};
//        System.out.println(solution.solution(arr2,k));

        int[] arr3 = {1,1,1,1,1,1,1};
//        System.out.println(solution.solution(arr3,k));

        int[] arr4 = {15};
//        System.out.println(solution.solution(arr4,k));



    }


}

class Solution {  // 실패 시간 초과
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 최솟값 섞고 이를 재배치 하면 array경우 O(n), 이진트리경우 O(logN)
        // min heap으로 구성 (가장 낮은값이 먼저 빠지도록)

        ArrayList<Integer> heap = new ArrayList<>();
        heap.add(0);
        // 삽입 및 정렬
        Arrays.sort(scoville);  // 오름차순 정렬
        for (int j : scoville) {
            heap.add(j);
        }

        while(heap.get(1) < K){
            answer++;

            if(heap.size()==2){
              return -1;
            } else if (heap.size()<4) {
                int min = heap.get(2);
                int temp = heap.get(1) + 2 * min;
                heap.remove(Integer.valueOf(min));
                heap.set(1,temp);
            } else {
                int min = Math.min(heap.get(2), heap.get(3));
                int temp = heap.get(1) + 2 * min;
                heap.remove(Integer.valueOf(min));
                heap.set(1, temp);
            }



            for (int i = 0; i < heap.size(); i++) {
                while(i>1 && heap.get(i) < heap.get(i/2) ){
                    int temp1 = heap.get(i);
                    int temp2 = heap.get(i / 2);
                    heap.set(i,temp2);
                    heap.set(i/2,temp1);
                    i = i/2;
                }
            }
        }

        return answer;
    }
}
class Solution2{
    public int solution(int[] scoville, int K) {
        int answer = 0;

        //낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

        for (int j : scoville) {
            priorityQueueLowest.add(j);
        }

        while(priorityQueueLowest.peek()<K){
            try{
                Integer poll1 = priorityQueueLowest.poll();  // 첫번째값, 배열에서 제거
                Integer poll2 = priorityQueueLowest.poll();  // 첫번째값, 배열에서 제거
                int sum = poll1 + 2 * poll2;
                priorityQueueLowest.add(sum);
                answer++;
            }catch (NullPointerException e){
                return -1;
            }
        }
        return answer;
    }
}


