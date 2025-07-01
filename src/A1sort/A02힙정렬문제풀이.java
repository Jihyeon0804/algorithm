package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class A02힙정렬문제풀이 {
    public static void main(String[] args) {
        // 프로그래머스 - 명예의 전당
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int[] result = new int[score.length];
        // result : [10, 10, 10, 20, 20, 100, 100]
        Queue<Integer> pq = new PriorityQueue<>();

        if (k <= score.length) {
            for (int i = 0; i < k; i++) {
                pq.add(score[i]);
                result[i] = pq.peek();
            }

            for (int i = k; i < score.length; i++) {
                if (score[i] > pq.peek()) {
                    pq.add(score[i]);
                    pq.poll();
                }
                result[i] = pq.peek();
            }
        } else {
            for (int i = 0; i < score.length; i++) {
                pq.add(score[i]);
                result[i] = pq.peek();
            }
        }
        System.out.println(Arrays.toString(result));

        // 프로그래머스 - 야근 지수


    }
}