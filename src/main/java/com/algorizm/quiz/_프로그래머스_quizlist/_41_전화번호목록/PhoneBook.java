package com.algorizm.quiz._프로그래머스_quizlist._41_전화번호목록;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {

        String[] arr1 = {"119", "97674223", "1195524421"};
        String[] arr2 = {"123","456","789"};
        String[] arr3 = {"12", "123", "1235", "567", "88"};
        Solution solution = new Solution();

        System.out.println( solution.solution3(arr1));
        System.out.println( solution.solution3(arr2));
        System.out.println( solution.solution3(arr3));
    }
}

class Solution {
    //전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
//    phone_book의 길이는 1 이상 1,000,000 이하입니다.
//    각 전화번호의 길이는 1 이상 20 이하입니다.
//    같은 전화번호가 중복해서 들어있지 않습니다
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, (String s1, String s2) -> s1.length() - s2.length());
        //[12, 88, 123, 567, 1235]

        for (int i = 0; i < phone_book.length; i++) {
            String target = phone_book[i];
            for (int j = i+1; j < phone_book.length; j++) {
                if(target.length()==phone_book[j].length()){
                    continue;
                }
                String substring = phone_book[j].substring(0, target.length());

                if(target.equals(substring)){
                    return false;
                }
            }
        }
        return answer;
    }


    public boolean solution2(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book); /// 정렬
        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        return answer;
    }

    public boolean solution3(String[] phone_book){
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++)
            map.put(phone_book[i], i);

        // 하나씩 자르면서 맵에 키 값이 있는지 비교 ..
        for (int i = 0; i < phone_book.length; i++){
            for (int j = 0; j < phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }

        return true;
    }
}