package A5DP;

import java.util.Arrays;

public class A04문자열수열 {
    public static void main(String[] args) {
        // 가징 긴 증가하는 부분 수열 (11053)
//        int[] arr = {10, 20, 10, 30, 20, 50};
        int[] arr = {30, 10, 20, 40, 50, 10};
        int n = 6;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            boolean check = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] > max) {
                    max = dp[j];
                    check = true;
                }
            }
            if (check) {
                dp[i] = max + 1;
            }
        }
//        System.out.println(Arrays.stream(dp).max().getAsInt());

        System.out.println(Arrays.toString(dp));

        // 가장 긴 증가하는 부분 수열 4 (14002)


    }
}
