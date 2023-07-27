package com.algorizm.quiz._프로그래머스_quizlist._48_카드뭉치;

import java.util.*;

public class Card {
    public static void main(String[] args) {
        String[] c1 = {"i", "drink", "drink"};
        String[] c2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        Solution solution = new Solution();

        String solution1 = solution.solution(c1, c2, goal);
        System.out.println("solution1 = " + solution1);
    }
}

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        List<String> array = new ArrayList<>();


        Queue<String> Q1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> Q2 = new LinkedList<>(Arrays.asList(cards2));


       for (int i = 0 ; i < goal.length ; i ++){
            String peekOne = Q1.peek();
            String peekTwo = Q2.peek();

            if(goal[i].equals(peekOne)){
                Q1.poll();
            }else if(goal[i].equals(peekTwo)){
                Q2.poll();
            }else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}