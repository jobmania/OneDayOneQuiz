package com.algorizm.quiz._프로그래머스_quizlist._42_달리기_경주;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;


public class Running {
    public static void main(String[] args) {

        String[] players = { "mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        String[] answer = solution2.solution(players, callings);
        System.out.println(Arrays.toString(answer));


    }
}

class Solution { /// 시간초과
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};


        int i = 0 ;

        while(i!=callings.length){

            String calling = callings[i];

            for (int j = 0 ; j < players.length ; j ++){
                String player = players[j];

                if(calling.equals(player)){
                    String foward = players[j - 1];
                    players[j-1] = player;
                    players[j] = foward;
                }

            }

            i++;
        }

        return players;
    }
}

class Solution2 { // 해쉬맵으로 풀기
    public String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> answer = new HashMap<>();

        for (int i = 0 ; i < players.length ; i ++){
            answer.put(players[i], i);
        }

        for (String calling : callings) {
            Integer callNumber = answer.get(calling);

            // 이전 순번 선수 찾기
            String frontPlayer = players[ (callNumber - 1)];


            answer.put(frontPlayer, callNumber); // 앞 선수는 뒷쪽으로 보내기
            players[callNumber] = frontPlayer;


            answer.put(calling, callNumber - 1); // 앞쪽으로 추월
            players[callNumber-1 ] = calling;



        }



        return players;
    }
}