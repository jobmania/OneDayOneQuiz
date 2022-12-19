package com.algorizm.quiz.quizlist.jumpandflash;

public class JumpAndFlash {
    public static void main(String[] args) {

        JumpAndFlashSolution solution = new JumpAndFlashSolution();
        int n1 = 5000;
        System.out.println("answer = " + solution.solution(n1));
    }
}


class JumpAndFlashSolution {
    public int solution(int n) {
        int ans = 0;
//        //에시
//        N이 500일 때
//        500 -> 250 -> 125(ans + 1) -> 62 -> 31(ans + 1) -> 15(ans + 1) -> 7(ans + 1) -> 3(ans + 1) -> 1(ans + 1)
//        따라서 건전지 사용량은 6이 된다.
//
//        N이 5,000일 때
//        5000 -> 2500 -> 1250 -> 625(ans + 1) -> 312 -> 156 -> 78 -> 39(ans + 1) -> 19(ans + 1) -> 9(ans + 1) -> 4 -> 2 -> 1(ans + 1)
//        따라서 건전지 사용량은 5가 된다.

        while(n!=0) {

            if (n % 2 == 0) {
                n = n / 2;
            } else  {
                n--;
                ans++;
            }
        }




        return ans;
    }
}