package A2dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A02Dfs모든경우의수 {

    static List<List<Integer>> adjList;
    static List<List<Integer>> answer;

    public static void main(String[] args) {
        // 1 ~ 10까지의 노드가 존재
        int[][] nodes = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {4, 9}, {5, 10}};
        adjList = new ArrayList<>();

        // 1부터 시작할 경우 인접 리스트를 1개 더 넉넉하게 생성
        for (int i = 0; i < 11; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // 여기서는 1번이 루트 노드라고 정해졌기 때문에, visited 제외하고 단방향 노드로 설계
        for (int i = 0; i < nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]);
        }

        for (int i = 0; i < adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        answer = new ArrayList<>();
        dfs(1, new ArrayList<>());
        System.out.println(answer);
    }

    static void dfs(int start, List<Integer> temp) {
        temp.add(start);  // 루트 노드 담고 시작
        // 더이상 자식 노드가 없는 경우 출력
        if (adjList.get(start).isEmpty()) {
            answer.add(new ArrayList<>(temp));
        }

        for (int a : adjList.get(start)) {
            dfs(a, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
