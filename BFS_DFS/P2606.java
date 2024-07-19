// 바이러스
// https://www.acmicpc.net/problem/2606
package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS 사용
// 감염된 컴퓨터의 수 계산
public class P2606 {
    static int node;  // 컴퓨터 수
    static int line; // 직접 연결 컴퓨터수 
    static int[][] arr;  // 연결 컴퓨터 쌍 저장 배열 
    static boolean[] visited; // 방문 여부 저장 배열
    static int birusCnt = 0; // 감염된 컴퓨터 수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine()); // 7
        line = Integer.parseInt(br.readLine());  // 6
        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1]; 
        
        for(int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 1 2
            int a = Integer.parseInt(st.nextToken()); // 1
            int b = Integer.parseInt(st.nextToken()); // 2
            arr[a][b] = arr[b][a] = 1; // 연결된 컴퓨터 표시
        }

        dfs(1);

        System.out.println(birusCnt - 1);
    }

    private static void dfs(int start) {
        visited[start] = true; 
        birusCnt++;

        // 인접한 모든 노드 탐색
        for(int i = 0; i <= node; i++) {
            // 연결되어있고 아직 방문하지 않은 노드를 재귀적으로 탐색
            if(arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }

}
