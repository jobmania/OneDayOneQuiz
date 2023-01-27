package com.algorizm.quiz._프로그래머스_quizlist._27_spicy;

import java.util.ArrayList;

public class Spicy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution.solution(arr,k));
    }


}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 최솟값 섞고 이를 재배치 하면 array경우 O(n), 이진트리경우 O(logN)
        // min heap으로 구성 (가장 낮은값이 먼저 빠지도록)

        ArrayList<Integer> heap = new ArrayList<>();


        // 삽입 및 정렬
        pushAndSort(scoville, heap);


        // 로직 후  삽입 및 정렬 , 삭제
        while(heap.get(1)<7){
            int min = Math.min(heap.get(2), heap.get(3));
            int setNum = heap.get(1) + 2 * min;
            heap.set(1,setNum);

        }





        return answer;
    }

    private static void pushAndSort(int[] scoville, ArrayList<Integer> heap) {
        for (int i = 0; i < scoville.length+1; i++) {
            if(i==0) {
               heap.add(0);
            }
           heap.add(scoville[i-1]);
           while(i>1 && heap.get(i/2)> heap.get(i)){
               int temp = heap.get(i/2);
               heap.set(i/2, heap.get(i));
               heap.set(i,temp);
               i = i/2;
           }
        }
    }
}


