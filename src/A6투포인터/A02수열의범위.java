package A6투포인터;

import java.util.*;

public class A02수열의범위 {
    public static void main(String[] args) {
        
        // 프로그래머스 - 숫자의 표현
        int n = 15;
        int start = 1;
        int end = 1;
        int total = 1;
        int count = 0;
        // start <= end 조건 없어도 됨 -> start가 end를 넘어가게 되면 total 값이 0이 되기 때문에 두번째 조건에 걸림
        while (start <= end && end <= n) {
            if (total == n) {
                count++;
                end++;
                total += end;
            } else if (total < n) {
                end++;
                total += end;
            } else {
                total -= start;
                start++;
            }
        }
        System.out.println(count);


        // 프로그래머스 - 연속된 부분 수열의 합
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;       // => [6, 6]
        // return [start, end]
        List<int[]> list = new ArrayList<>();
        int s = 0;
        int e = 0;
        int total1 = sequence[s];
        while (s <= e && e < sequence.length - 1) {
            if (total1 == k) {
                list.add(new int[]{s, e});
                s++;
                e = s;
                total1 = sequence[s];
            } else if (total1 < k) {
                e++;
                if (e == sequence.length - 1) {
                    list.add(new int[]{e, e});
                }
                total1 += sequence[e];
            } else if (total1 > k) {
                s++;
                total1 = sequence[s];
                e = s;
            }
        }

        for (int[] a : list) {
            System.out.println(Arrays.toString(a));
        }
    }
}
