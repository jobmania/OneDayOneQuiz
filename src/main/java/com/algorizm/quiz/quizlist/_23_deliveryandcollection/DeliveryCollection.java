package com.algorizm.quiz.quizlist._23_deliveryandcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliveryCollection {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int cap = 2;                    // 4   // 2
        int n = 7;                      // 5    // 2
        int[] del = {1, 0, 2, 0, 1, 0, 2};  // 1, 0, 3, 1, 2    // 1, 0
        int[] pic = {0, 2, 0, 1, 0, 2, 0};  // 0, 3, 0, 4, 0    // 1, 0
        System.out.println("답은 " + solution.solution(cap, n, del, pic));
    }
}

class Solution {

    //탐욕법으루 풀자..
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;


        int totalDelivery = Arrays.stream(deliveries).sum();
        int totalPickups = Arrays.stream(pickups).sum();
        int temp = 0;
        int temp2 = 0;



        while(true){
            //순서에 대한정보.
            List<Integer> delArr = new ArrayList<>();
            List<Integer> pickArr = new ArrayList<>();

            for(int i = deliveries.length-1; i >=0 ; i--){
                if(deliveries[i]!=0) delArr.add(i);
                temp += deliveries[i];
               if(temp > cap){
                   deliveries[i] = temp-cap;
                   temp = cap;
                   break;
               }else {
                   deliveries[i] = 0;
               }
            }




            for(int i = pickups.length-1 ; i>=0 ; i--){
                if(pickups[i]!=0) pickArr.add(i);
                temp2 += pickups[i];

                if(temp2 > cap){
                    pickups[i] = temp2-cap;
                    temp2= cap;
                    break;
                }else{
                    pickups[i] = 0;
                }
            }

            if(delArr.get(0)>pickArr.get(0)){
                answer += 2L *(delArr.get(0)+1);
            }else {
                answer += 2L *(pickArr.get(0)+1);
            }






            if(totalPickups==0 & totalDelivery==0){
                break;
            }
        }




        return answer;
    }
}
