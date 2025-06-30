package A1sort;

import java.util.Arrays;

// 트리 탐색 + 재귀적 호출
public class A01HeapSort구현 {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        // 최초 힙 구성 : 복잡도 - O(n * log(n))
        // 부모 노드부터 확인
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // 루트 노드와 최하위 노드를 자리 change 해 가면서 재 heapify
        for (int i = arr.length - 1; i >= 0; i--) {
            // 0번째 index와 마지막 index의 자리 change
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }

        // 내림차순 정렬
        System.out.println(Arrays.toString(arr));
    }

    static void heapify(int[] arr, int parent, int length) {
        // 매개변수 parent는 바뀐 자리의 자식 노드의 index
        // 자식 노드와의 비교 : 왼쪽 자식 노드 (parent * 2 + 1), 오른쪽 자식 노드 (parent * 2 + 2)
        // 자식 노드 없을 수 있으니 확인해야 함
        int left_node = parent * 2 + 1;
        int right_node = parent * 2 + 2;
        int smallest = parent;

        // 자식이 더 작으면 자리 change
        if (left_node < length && arr[smallest] > arr[left_node]) {     // 오름차순 : arr[smallest] < arr[left_node]
            smallest = left_node;
        }

        if (right_node < length && arr[smallest] > arr[right_node]) {     // 오름차순 : arr[smallest] < arr[right_node]
            smallest = right_node;
        }

        // 만약 자리 change가 발생하면 재귀적 호출
        if (smallest != parent) {
            int temp = arr[parent];
            arr[parent] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, smallest, length);
        }
    }
}