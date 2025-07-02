package A5DP;

import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class A01계단관련 {
    public static void main(String[] args) {
        
        // 프로그래머스 - 멀리 뛰기
        // arr[i] = arr[i - 1] + arr[i - 2]

        // 백준 - 계단 오르기 (2579)
        // arr : 원본 데이터
        // maxArr : 최댓값 배열
        // a = maxArr[n - 2] + arr[n]
        // b =  maxArr[n - 3] + arr[n - 1] + arr[n]
        // maxArr[n] = Math.max(a, b)
        int n = 6;
        int[] arr = {0, 10, 20, 15, 25, 10, 20};
        int[] maxArr = new int[n + 1];
        maxArr[0] = arr[0];
        if (n == 1) {
            maxArr[1] = arr[1];
        } else if (n == 2) {
            maxArr[1] = arr[1];
            maxArr[2] = arr[1] + arr[2];
        } else {
            maxArr[1] = arr[1];
            maxArr[2] = arr[1] + arr[2];
            for (int i = 3; i < maxArr.length; i++) {
                int a = maxArr[i - 2] + arr[i];
                int b = maxArr[i - 3] + arr[i - 1] + arr[i];
                maxArr[i] = Math.max(a, b);
            }
        }
        System.out.println(maxArr[n]);
    }
}
