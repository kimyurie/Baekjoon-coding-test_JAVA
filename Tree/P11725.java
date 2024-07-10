// 트리의 부모찾기
// https://www.acmicpc.net/problem/11725
package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11725 {
    static int N;
    static ArrayList<Integer> list[];
    static StringTokenizer st;
    static boolean[] isVisit;
    static int[] parentNode;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isVisit = new boolean[N + 1];
		list = new ArrayList[N + 1];
		parentNode = new int[N + 1];

        // 초기화 
        for(int i = 0; i < N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken()); // 1
            int b = Integer.parseInt(st.nextToken()); // 6

            list[a].add(b);  
            list[b].add(a); 
            // list[1] -> [6, 4]
            // list[2] -> [4]
            // list[3] -> [6, 5]
            // list[4] -> [1, 2, 7]
            // list[5] -> [3]
            // list[6] -> [1, 3]
            // list[7] -> [4]
        }

        dfs(1);

        for(int i = 2; i < parentNode.length; i++) {
            System.out.println(parentNode[i]);
        }
    }

    private static void dfs(int i) {
        isVisit[i] = true; // isVisit[6] = t

        for(int a : list[i]){ // 1, 3
            if(!isVisit[a]) {
                parentNode[a] = i;  // parentNode[6] = 1  
                dfs(a); // dfs(6) // parentNode[3] = 6
            }
        }

    }

}


