// 완전 이진 트리
// https://www.acmicpc.net/problem/9934
package Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// - 중위 순회 문제 
public class P9934 {
    static int K; // 트리 깊이 // 2
    static int size; // 트리 노드 수 
    static int[] num; // 초기 중위 순회 결과 저장
    static ArrayList<Integer>[] tree; // 각 레벨별로 노드를 저장할 리스트

    public static void main(String[] args) throws IOException{
        // 입력값 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 결과값 출력 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        K = Integer.parseInt(br.readLine()); // 2

        StringTokenizer st = new StringTokenizer(br.readLine()); // 2 1 3

        // 1. 트리 총 노드수 계산
        size = (int) (Math.pow(2, K) - 1); // 3 

        // num 초기화 // 2 1 3 들어가야함 
        num = new int[size + 1];

        // 3. 레벨별로 노드를 저장할 리스트 초기화
        tree = new ArrayList[K + 1]; // 레벨 1, 레벨 2 ..
        for(int i = 0; i <= K; i++) {
            tree[i] = new ArrayList<>();
        }

        // 2. 중위 순회 결과 저장 [2 , 1, 3]
        int index = 1;
        while(st.hasMoreTokens()){
            num[index++] = Integer.parseInt(st.nextToken());
        }


        // 4. 중위 순회 결과를 이용해 트리 구성 및 각 레벨에 노드 추가
        search(1,1, size);

        // 각 레벨에 있는 빌딩 정보 bw에 저장
        for(int i = 1; i <= K; i++) {
            for(int j = 0; j < tree[i].size(); j++) {
                bw.write(tree[i].get(j) + " ");
            }
            bw.newLine();
        }

        // 결과 출력
        bw.flush();

        bw.close();
        br.close();
    }

    // 중위 순회 특성을 이용 트리를 구성 / 각 레벨에 맞는 빌딩 값들을 저장
    private static void search(int depth, int start, int end) {
        int mid = (start + end) / 2; // 현재 서브트리의 루트 노드 위치(중간 지점)
        tree[depth].add(num[mid]); // 현재 레벨에 루트 노드 추가 

        // 단말 노드(자식이 없는 노드)일 때 재귀 종료
        if(depth == K) return;

        // 왼쪽 서브트리 구성
        search(depth + 1, start, mid - 1);

        // 오른쪽 서브트리 구성
        search(depth + 1, mid + 1, end);
    }
  
}