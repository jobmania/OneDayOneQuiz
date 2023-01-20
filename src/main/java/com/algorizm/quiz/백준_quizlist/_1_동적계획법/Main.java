package com.algorizm.quiz.백준_quizlist._1_동적계획법;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] staticAr = {1,1,2,2,2,8};

        int a = 0;

        for (int j : staticAr) {
            a = scanner.nextInt();
            System.out.println(j - a);
        }




    }
}
