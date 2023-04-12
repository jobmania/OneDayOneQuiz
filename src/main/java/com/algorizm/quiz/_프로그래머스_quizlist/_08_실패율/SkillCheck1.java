package com.algorizm.quiz._프로그래머스_quizlist._08_실패율;


import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/42889

public class SkillCheck1 {
    public static void main(String[] args){
        SkillCheck1Solution solution = new SkillCheck1Solution();
        int N = 5;
        int [] stages = {1,2,2,1,3};
        int [] answer = solution.solution(N,stages);
        System.out.println("answer = " + Arrays.toString(answer));

    }
}

class SkillCheck1Solution {
    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        int[] failArray = new int[N];
        Double failRatio;
        int stageCount = stages.length;

        HashMap<Integer, Double> map = new HashMap<>();

        for(int i = 0 ; i < N ; i ++){
            for (int stage : stages) {
                if (stage == (i + 1)) {
                    failArray[i]++;
                }
            }
        }
        System.out.println("failArray = " + Arrays.toString(failArray));

        
        for(int i = 0 ; i< N ; i ++){
            if(stageCount==0){
                map.put(i+1,(double)0);
            }else {
                failRatio = (double) failArray[i]/stageCount;
                map.put(i+1,failRatio);
                stageCount = stageCount-failArray[i];
                System.out.println("stageCount = " + stageCount);
            }

        }
        System.out.println("map = " + map);



        // Map value로 비교 하기 https://velog.io/@dev-easy/Java-Map%EC%9D%84-Key-Value%EB%A1%9C-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        keySetList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));  // o2,o1내림차순  o1,o2오름차순
            }
        });
        System.out.println("keySet = " + keySetList);

        for(int i = 0 ; i < N ; i++){
            answer[i]=keySetList.get(i);
        }

        return answer;
    }
}