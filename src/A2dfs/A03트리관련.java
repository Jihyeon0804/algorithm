package A2dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A03트리관련 {

    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        // 트리의 부모 찾기 (11725)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] nodes = new int[n - 1][2];
        int[] result = new int[6];

        for (int i = 0; i < n - 1; i++) {
            String[] temp = br.readLine().split(" ");
            nodes[i][0] = Integer.parseInt(temp[0]);
            nodes[i][1] = Integer.parseInt(temp[1]);
        }

        adjList = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]);
            adjList.get(nodes[i][1]).add(nodes[i][0]);
        }
        System.out.println(adjList);

        dfs(1);
    }

    static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int a : adjList.get(start)) {
            if (!visited[a]) {
                dfs(a);
            }
        }
    }
}
