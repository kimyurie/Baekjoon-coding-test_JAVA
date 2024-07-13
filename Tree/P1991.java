// 트리 순회
// https://www.acmicpc.net/problem/1991
package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1991 {
    static int N;
    static StringTokenizer st;
    static Map<String, Node> nodeMap = new HashMap<>();

    public static class Node{
        // Object data;
        String data;
        Node left;
        Node right;

        // 초기화
        public Node(String data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

     // 전위순회
     public static void preOrder(Node node) {
        if(node == null) return;
        System.out.printf(node.data);
        preOrder(node.left);
        preOrder(node.right);
     }

     // 중위순회
     public static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.printf(node.data);
        inOrder(node.right);
     }

     // 후위순회
     public static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.printf(node.data);
     }

    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // ABC
            String parent = st.nextToken(); // A
            String left = st.nextToken(); // B
            String right = st.nextToken(); // C

            // 부모 노드가 이미 존재하면 가져오고, 없으면 새로 생성
            Node parentNode = nodeMap.getOrDefault(parent,new Node(parent));
            // 부모 노드를 맵에 추가
            nodeMap.put(parent,parentNode);

            // 왼쪽 자식 노드가 '.'이 아니면 노드를 생성 또는 가져와서 부모 노드에 연결
            if(!left.equals(".")){
                Node leftNode = nodeMap.getOrDefault(left, new Node(left));
                parentNode.left = leftNode;
                nodeMap.put(left, leftNode);
            }

            // 오른쪽 자식 노드가 '.'이 아니면 노드를 생성 또는 가져와서 부모 노드에 연결
            if(!right.equals(".")) {
                Node rightNode = nodeMap.getOrDefault(right, new Node(right));
                parentNode.right = rightNode;
                nodeMap.put(right, rightNode);
            }  
        }

        Node root = nodeMap.get("A");

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }
}
