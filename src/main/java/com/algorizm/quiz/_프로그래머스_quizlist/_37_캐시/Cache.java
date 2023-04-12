package com.algorizm.quiz._프로그래머스_quizlist._37_캐시;

import java.util.*;

public class Cache {
    public static void main(String[] args) {
        int size = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};  // 50

        int size2 = 3;
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}; //	21

        int size3 = 2;
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}; // 60

        int size4 = 5;
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}; // 52

        int size5 = 2;
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"}; // 16

        int size6 = 0;
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}; // 25

        int size7 = 2;
        String[] cities7 = {"Jeju", "Jeju", "Jeju", "Jeju"}; // 8

        int size8 = 0;
        String[] cities8 = {"Jeju", "Jeju", "Jeju", "Jeju"}; // 20


        Solution solution = new Solution();
        System.out.println(solution.solution(size, cities));   // 50
        System.out.println(solution.solution(size2, cities2)); // 21
        System.out.println(solution.solution(size3, cities3)); // 60
        System.out.println(solution.solution(size4, cities4)); // 52
        System.out.println(solution.solution(size5, cities5)); // 16
        System.out.println(solution.solution(size6, cities6)); // 25
        System.out.println(solution.solution(size7, cities7)); // 8
        System.out.println(solution.solution(size8, cities8)); // 20

    }
}

class Solution {
    public int solution(int cacheSize, String[] cities) {

        //
        int cacheHit = 0;
        int cacheMiss = 0;

        if(cacheSize==0){
            return cities.length * 5;
        }

        Queue<String> cacheList = new LinkedList<>();

        for (String s : cities) {
            String city = s.toLowerCase();

            Optional<String> find = cacheList.stream().filter(c -> c.equals(city)).findFirst();

            if (find.isEmpty()) { // 없다면
                if (cacheList.size() < cacheSize ) {
                    cacheList.offer(city);
                } else {
                    cacheList.offer(city);
                    cacheList.poll();
                }
                cacheMiss++;

            } else {  // 있따면

                // 기존에 안에 있는 걸 제거해야함!
                cacheList.remove(city);
                cacheList.offer(city);
                cacheHit++;
            }

        }

        return cacheHit + 5 * cacheMiss;
    }
}

class Solution2 {

    private int maxSize;
    private Set<String> cache;

    public int solution(int maxSize, String[] cities) {
        this.maxSize = maxSize;
        this.cache = (maxSize > 0)? new LinkedHashSet<>() : null; // 중복없이 순서를 보장!
        return Arrays.stream(cities)
                .map(city-> city.toLowerCase())
                .mapToInt(this::queryCost)
                .sum();
    }

    private int queryCost(String key) {
        if (cache == null)
            return 5;

        if (cache.contains(key)) {
            touchItem(key);
            return 1;
        }

        if (cache.size() == maxSize)
            removeLRU();
        cache.add(key);
        return 5;
    }

    private void removeLRU() {
        for (String item : cache) {
            cache.remove(item); // LRU item
            break;
        }
    }

    private void touchItem(String key) {
        cache.remove(key);
        cache.add(key);
    }
}