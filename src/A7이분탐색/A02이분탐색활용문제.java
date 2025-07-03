package A7이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A02이분탐색활용문제 {
    public static void main(String[] args) {

        // 백준 - 예산(2512)
        // 배열을 주어진 예산요청 금액으로 두면 안되고 1부터 요청 금액 중 최댓값까지의 정수 배열로 설정
        // 120 110 140 150 => [1, 2, 3, ..., 150]
        int[] intArr = {70, 80, 30, 40, 100};
//        Arrays.sort(intArr);
        int answer = -1;
        int max = intArr[intArr.length - 1];
        int total = 450;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = i + 1;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int sum = 0;
            int idx = (start + end) / 2;
            for (int num : intArr) {
                sum += Math.min(num, arr[idx]);
            }
            if (sum == total) {
                answer = idx;
                break;
            } else if (sum > total) {
                end = idx - 1;
            } else {
                start = idx + 1;
                answer = idx;
            }
        }
        System.out.println(arr[answer]);
        
        
        
        // 백준 - 과자 나눠주기(16401) ; answer 찾을 후에도 계속 탐색
        
        // 프로그래머스, 백준 - 입국 심사(3079)

    }
}
