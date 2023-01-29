package com.algorizm.quiz._프로그래머스_quizlist._27_spicy;

import java.util.ArrayList;
import java.util.Arrays;

public class Spicy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 7;
        int[] arr = {1, 2, 3, 9, 10, 12};
//        System.out.println(solution.solution(arr,k));

        int[] arr2 = {1,2,3,9,10,12};
//        System.out.println(solution.solution(arr2,k));

        int[] arr3 = {1,1,1,1,1,1,1};
        System.out.println(solution.solution(arr3,k));

        int[] arr4 = {15};
        System.out.println(solution.solution(arr4,k));

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


