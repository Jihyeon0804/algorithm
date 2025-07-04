package A5DP;

public class A02동전관련 {
    public static void main(String[] args) {

        // 예외인 경우가 있을 수 있기 때문에 아래와 같은 문제들은 dp로 풀기
        // 1, 4, 5의 숫자가 있을 때, 조합하여 13를 만들 수 있는 조합 중 가장 짧은 조합의 길이
        int[] arr = {1, 4, 5};
        int target = 13;
        
        // greedy 문제를 풀 경우 : 5 * 2 + 1 * 3 - > 5개 동전
        // dfs, bfs -> 시간 초과 또는 메모리 초과
        // dp로 문제를 풀 경우 : 4 * 2 + 5 * 1 -> 3개의 동전
        // 13 => 1 + 12, 4 + 9, 5 + 8
        // f(n) = Min(f(n - ni), f(n - n2)) + 1
        int[] minArr = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            int min = Integer.MAX_VALUE;
            for (int a : arr) {
                if (i - a >= 0 && min > minArr[i - a]) {
                    min = minArr[i - a];
                }
            }
            minArr[i] = min + 1;
        }
        System.out.println(minArr[target]);

        // 백준 - 동전 2(2294)



    }
}
