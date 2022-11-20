package com.algorizm.quiz.quizlist.followupwords;

import java.util.HashMap;

public class FollowUpWords {
    public static void main(String[] args){
        FollowUpWordsSolution solution = new FollowUpWordsSolution();
        String[] s1 = { "hello", "one", "even", "never", "now", "world", "draw"};
        int n = 2;
        int[] answer = solution.solution(n, s1);
        System.out.println("answer[0] + answer[1] = " + answer[0] + ","+ answer[1]);

    }
}

class FollowUpWordsSolution {
    public int[] solution(int n, String[] words) {

        int person ;
        int second ;
        int[] answer = {0,0};

        HashMap<String, Integer> map = new HashMap<>();

        map.put(words[0],map.getOrDefault(words[0],0)+1);

        for(int i = 1 ; i < words.length ; i++ ){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
            if(map.get(words[i])==2){
                person = (i+1)%n;
                if(person==0) person=n;
                second = (int) Math.ceil((double) (i+1)/n);
                answer[0] = person;
                answer[1] = second;
                break;
            }

            if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)){
                person = (i+1)%n;
                if(person==0) person=n;
                second = (int) Math.ceil((double) (i+1)/n);
                answer[0] = person;
                answer[1] = second;
                break;
            }

        }

        return answer;
    }
}