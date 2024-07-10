// 단절점과 단절선
// https://www.acmicpc.net/problem/14675
package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14675 {
    static int N; // 트리의 정점 개수
    static ArrayList<Integer> list[];
    static StringTokenizer st;
    static int Q;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 노드간 연결 정보 
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 정점 a
            int b = Integer.parseInt(st.nextToken()); // 정점 b

            list[a].add(b);
            list[b].add(a);
        }

        Q = Integer.parseInt(br.readLine());

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(t == 1) {
                // 단절점인지 확인
                if(list[k].size() >= 2) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else if(t == 2) {
                // 단절선인지 확인
                System.out.println("yes"); // 트리에서 모든 간선은 단절선이다.
            }
        }
    }
}
