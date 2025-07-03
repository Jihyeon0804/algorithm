package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A01TwoPointerBasic {
    public static void main(String[] args) {

        // 아래 배열에서 target이 될 수 있는 두 수의 조합 찾기
        // 중복 X ([1, 9] 와 [9, 1]은 동일)
        // 아래 코드는 복잡도 N^2
        int[] nums = {7, 8, 9, 2, 4, 5, 1, 3, 6};
        int target = 10;
        List<int[]> myList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    myList.add(new int[]{nums[i], nums[j]});
                }
            }
        }
        for (int[] a : myList) {
            System.out.println(Arrays.toString(a));
        }



        // 위 배열 정렬 시 : 1, 2, 3, 4, 5, 6, 7, 8, 9
        // end가 0부터 출발하는 경우와 end가 length - 1 부터 시작하는 경우가 있음(구분하기)
        int start = 0;
        int end = nums.length - 1;
        List<int[]> list = new ArrayList<>();
        // start + end < target => start++;
        // start + end > target => end--;
        // target의 범위를 벗어나면 그 이후의 인덱스는 탐색하지 않으므로 복잡도가 줄어듦
        Arrays.sort(nums);          // O(nlgn)
        // 정렬이 필요한 경우         // 예) 두 수의 합
        // 정렬이 필요하지 않은 경우 - 예) 구간의 합
        while (start < end) {       // start, end가  <= 또는 < 인 경우 2가지 존재; O(N)
            int total = nums[start] + nums[end];
            if (total == target) {
                list.add(new int[]{nums[start], nums[end]});
                start++;            // 또는 end--;
            } else if (total < target) {
                start++;
            } else if (total > target) {
                end--;
            }
        }

        for (int[] a : list) {
            System.out.println(Arrays.toString(a));
        }
    }
}