package com.algorizm.quiz._프로그래머스_quizlist._38_타겟_넘버;

import java.util.LinkedList;
import java.util.Queue;

public class Target {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;

        Solution solution = new Solution();

//        System.out.println(solution.solution(numbers,target)); // 5
        System.out.println(solution.solution(numbers2,target2)); // 2


    }
}


class Solution {
     int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs2(numbers,target,0,0);

        return answer;

    }

    private  void dfs2(int[] numbers, int target, int current, int sum){
        if(current == numbers.length) { // 마지막 노드까지 탐색한 경우
            if(target == sum) answer++;
        }else {
            dfs2(numbers, target, current + 1, sum + numbers[current]); // 해당 노드의 값을 더하고 다음 깊이 탐색
            dfs2(numbers, target, current + 1, sum - numbers[current]); // 해당 노드의 값을 빼고 다음 깊이 탐색
        }

    }

    private static int dfs(int[] numbers, int target, int sum, int current) { // 재귀
        int ans = 0;

        if (current == numbers.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        ans += dfs(numbers, target, sum + numbers[current], current + 1);
        ans += dfs(numbers, target, sum - numbers[current], current + 1);

        return ans;
    }

    private static int bfs(int[] numbers, int target) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, numbers[0]));
        q.add(new Pair(0, numbers[0] * -1));

        int answer = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.position == numbers.length - 1) {
                if (p.sum == target) {
                    answer++;
                }
                continue;
            }

            int nPosition = p.position + 1;
            if (nPosition >= numbers.length) {
                continue;
            }

            q.add(new Pair(nPosition, p.sum + numbers[nPosition]));
            q.add(new Pair(nPosition, p.sum + numbers[nPosition] * -1));
        }

        return answer;
    }
    private static class Pair {
        int position;

        int sum;
        public Pair(int position, int sum) {
            this.position = position;
            this.sum = sum;
        }

    }

}