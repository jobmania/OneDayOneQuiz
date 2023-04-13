package com.algorizm.quiz._프로그래머스_quizlist._39_네트워크;

public class Network {

    public static void main(String[] args) {
        int n =3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int n2 =3;
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};


        Solution solution = new Solution();

        System.out.println( solution.solution(n, computers)); //2
        System.out.println( solution.solution(n2, computers2));//1
    }

}


/**
 *
 * 방문 리스트를 만들고
 * 처음 0번부터 DFS를 돌려주고
 * 방문한 컴퓨터에다가 체크한다 (처음 방문하는거 횟수 1올려주고 시작)
 * 방문을 하지 않은 컴퓨터를 계속 DFS 돌려줘서
 * DFS를 돌려준 횟수를 센다 (재귀한거 세는게 아니라 처음 실행한 횟수)
 *
 * */

class Solution {
    private int answer =0;
    public int solution(int n, int[][] computers) {
        boolean[] visitList = new boolean[n];

        for (int i = 0; i < n ; i++) {
            if(!visitList[i]){ // false시 미방문
                answer++;
                dfs(i,computers,visitList);
            }
        }
        return answer;
    }

    private void dfs(int index, int[][] computers, boolean[] visitList){
        if(visitList[index]){ // 이미 방문(연결) 했다면.
            return;
        }

        visitList[index] = true; // 방문 표시 = 연결표시

        for(int i = 0; i <  computers[index].length ; i ++){

            if(index == i ){
                continue;
            }

            if(computers[index][i]==1){
                dfs(i, computers, visitList);
            }

        }

    }

}