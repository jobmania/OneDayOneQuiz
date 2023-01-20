package com.algorizm.quiz._프로그래머스_quizlist._23_deliveryandcollection;

import java.util.*;

public class DeliveryCollection {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int cap = 2;                         // 4                // 2           //2
        int n = 7;                           // 5                // 2           //7
        int[] del = {1, 0, 2, 0, 1, 0, 2};  // {1, 0, 3, 1, 2}     // {1, 0}    // {1, 0, 2, 0, 1, 0, 2
        int[] pic = {0, 2, 0, 1, 0, 2, 0};  // {0, 3, 0, 4, 0}     // {1, 0}   //{0, 2, 0, 1, 0, 2, 0}
//        System.out.println("답은 " + solution.solution(cap, n, del, pic));
        System.out.println("답은 " + new Solution2().solution(cap, n, del, pic));

        int cap1 = 4;
        int n1 = 5;
        int[] del1 = {1, 0, 3, 1, 2};
        int[] pic1 = {0, 3, 0, 4, 0};
//        System.out.println("답은 " + solution.solution(cap1, n1, del1, pic1));
        System.out.println("답은 " + new Solution2().solution(cap1, n1, del1, pic1));

        int cap2 = 2;
        int n2 = 2;
        int[] del2 = {0, 0};
        int[] pic2 = {0, 0};
//        System.out.println("답은 " + solution.solution(cap2, n2, del2, pic2));
        System.out.println("답은 " + new Solution2().solution(cap2, n2, del2, pic2));





        int cap3 = 5;
        int n3 = 5;
        int[] del3 = {2, 0, 0, 0, 7 };
        int[] pic3 = {2, 0, 0, 7, 0 };
//        System.out.println("답은 " + solution.solution(cap2, n2, del2, pic2));
        System.out.println("답은 " + new Solution2().solution(cap3, n3, del3, pic3));


        int cap4 = 20;
        int n4 = 3;
        int[] del4 = {0, 0, 7 };
        int[] pic4 = {2, 0, 2 };
//        System.out.println("답은 " + solution.solution(cap2, n2, del2, pic2));
        System.out.println("답은 " + new Solution2().solution(cap4, n4, del4, pic4));

    }
}

class Solution {

    //탐욕법으루 풀자.. -> 시간  초과로 실패 ㅠㅠ;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Queue<Integer> delQ = new LinkedList<>();
        Queue<Integer> picQ = new LinkedList<>();

        int temp = 0;
        int temp2 = 0;
        int tempNum1 = 0;
        int tempNum2 = 0;
        int totalDelivery = Arrays.stream(deliveries).sum(); // 총 갯수
        int totalPickups = Arrays.stream(pickups).sum();


        while (true) {


            if (totalPickups == 0 && totalDelivery == 0) {
                break;
            }

            totalDelivery = getTotalDelivery(cap, n, deliveries, delQ, temp, totalDelivery);
            totalPickups = getTotalDelivery(cap, n, pickups, picQ, temp2, totalPickups);


            if(delQ.isEmpty()) delQ.add(0);
            if(picQ.isEmpty()) picQ.add(0);

            tempNum1 = delQ.peek();
            tempNum2 = picQ.peek();

            if (tempNum1 > tempNum2) {  // {0,0} 배열일시 에러 터짐..
                answer += 2L * (tempNum1 + 1);
            } else {
                answer += 2L * (tempNum2 + 1);
            }

            delQ.clear();
            picQ.clear();
            temp = 0;
            temp2 = 0;
            tempNum1 = 0;
            tempNum2 = 0;

        }
        return answer;
    }

    private int getTotalDelivery(int cap, int n, int[] deliveries, Queue<Integer> delQ, int temp, int totalDelivery) {
        int temps = 0;
        for (int i = n - 1; i >= 0; i--) {
             temps = deliveries[i];

            if (temps != 0){
                delQ.add(i);
                temp += temps;
                totalDelivery -= temps;


                if (temp > cap) {
                    deliveries[i] = temp - cap;
                    totalDelivery += temp - cap;
                    break;
                } else {
                    deliveries[i] = 0;
                }

            }else {
                continue;  // 0 이면 넘어가기
            }

        }
        return totalDelivery;
    }

}

class Solution2{
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        int answer = 0;

        for(int i = n-1 ; i >-1 ; i--){     // 끝에서부터 시작 해당 위치에 0, 0 일 때까지
            while (deliveries[i] > 0 || pickups[i] > 0){
                deliveries[i] -= cap;
                pickups[i] -= cap;
                answer += 2 *(i+1);
            } // ok

            if(i==0) break; // i= 0 일시 아래에서 배열 에러발생.

            // 초과분에 대해서 i-1에 이월하여 해결.

            if(deliveries[i]<0){
                deliveries[i-1] += deliveries[i];
                deliveries[i] = 0;
            }

            if(pickups[i]<0){
                pickups[i-1] += pickups[i]; ///[8 0 0 0 0 10 ]
                pickups[i] = 0 ;
            }
        }

        System.out.println(Arrays.toString(deliveries));
        System.out.println(Arrays.toString(pickups));
        return answer;
    }


}