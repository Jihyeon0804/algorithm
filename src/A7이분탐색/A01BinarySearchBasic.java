package A7이분탐색;

import java.util.Arrays;

public class A01BinarySearchBasic {
    public static void main(String[] args) {

        // 이분 탐색은 사전에 데이터가 오름차순 정렬이 되어야 함
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        // binarySearch 메서드 사용
        System.out.println(Arrays.binarySearch(arr, 17));

        // 직접 구현
        int target = 17;
        int answer = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int idx = (end + start) / 2;
            if (arr[idx] < target) {
                start = idx + 1;
            } else if (arr[idx] > target) {
                end = idx - 1;
            } else {
                answer = idx;
                break;
            }
        }
        System.out.println(answer);


        // 응용 case : 배열(탐색의 대상)을 직접 설정
        // target이 arr에 있다면 index 값을 리턴하고 arr에 없다면 있어야 할 자리 index를 return
        int[] arr1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target1 = 2;
        int answer1 = -1;
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int idx = (s + e) / 2;
            if (arr[idx] < target1) {
                s = idx + 1;
                // 조건에 맞는 딱 맞는 값이 없을 수도 있는 경우
//                answer1 = idx;
            } else if (arr[idx] > target1) {
                e = idx - 1;
                // 조건에 맞는 딱 맞는 값이 없을 수도 있는 경우
//                answer1 = idx;
            } else {
                // 조건에 딱 맞는 값을 찾았어도 최대/최소값을 위해 이분 탐색을 계속 진행할 수 있음
                answer1 = idx;
                break;
            }
        }
        System.out.println(answer1);
    }
}
