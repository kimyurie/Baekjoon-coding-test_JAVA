package Tree;

public class Tree {
    int count; // 트리에 포함된 노드 수 

    public Tree() {
        count = 0;
    }


    public class Node{
        Object data; // 공간에 넣을 숫자
        Node left; // 왼쪽 자식 넣을 공간 (왼쪽 자식 노드)
        Node right; // 오른쪽 자식 넣을 공간

        
        // 초기화
        public Node(Object data) {
            this.data = data;
            left = null;
            right = null;
        }

        // 현재 노드의 좌측에 노드 연결 정보를 추가
        public void addLeft(Node node){
            left = node;
            count++;
        }

        public void addRight(Node node){
            right = node;
            count++;
        }

        //  현재 노드의 좌측 노드 연결 정보를 삭제
        public void deleteLeft(){
            left = null;
            count--;
        }

        public void deleteRight(){
            right = null;
            count--;
        }
    }




    // 데이터 받아 새로운 노드를 생성
    public Node addNode(Object data){
        Node n = new Node(data);
        return n;
    }

    // 전위순회
    public void preOrder(Node node){
        if(node == null) {
            return;
        }

        System.out.println(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위순회
    public void inOrder(Node node){
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }

    // 후위순회
    public void postOrder(Node node){
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data + " ");
    }

    public static void main(String[] args) {
        // 트리 생성
        Tree tree = new Tree();

        // 노드 생성
        Node node1 = tree.addNode(1);
        Node node2 = tree.addNode(2);
        Node node3 = tree.addNode(3);
        Node node4 = tree.addNode(4);
        Node node5 = tree.addNode(5);
        Node node6 = tree.addNode(6);
        Node node7 = tree.addNode(7);

        // 트리 연결관계 생성
		/*  트리 모양       
		 *        1
		 *     2     3
		 *   4  5  6   7
		 */
        node1.addLeft(node2);
        node1.addRight(node3);
        node2.addLeft(node4);
        node2.addRight(node5);
        node3.addLeft(node6);
        node3.addRight(node7);

        tree.preOrder(node1);
        System.out.println();
        tree.inOrder(node1);
        System.out.println();
        tree.postOrder(node1);
        System.out.println();

        node2.deleteLeft(); // 4 삭제
        node3.deleteRight(); // 7 삭제

        /* 삭제 이후 트리 모양
		 *        1
		 *     2     3
		 *      5  6   
		 */

        System.out.println();
        tree.preOrder(node1);
        System.out.println(); // 1 2 5 3 6
    }
}

