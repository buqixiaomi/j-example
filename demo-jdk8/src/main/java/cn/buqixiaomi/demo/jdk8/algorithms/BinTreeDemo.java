package cn.buqixiaomi.demo.jdk8.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * description
 * 二叉树算法
 * @author lishengkai
 * @date 2018-09-13 16:36
 */
public class BinTreeDemo {

    public static void main(String[] args) {
       BinTreeDemo binTreeDemo = new BinTreeDemo();
       Node rootNode = binTreeDemo.root;
        rootNode = new Node(4);
        rootNode.leftNode = new Node(2);
        rootNode.rightNode = new Node(6);
        rootNode.leftNode.leftNode = new Node(1);
        rootNode.leftNode.rightNode = new Node(3);
        rootNode.rightNode.leftNode = new Node(5);
        rootNode.rightNode.rightNode = new Node(7);
        System.out.println("-----------普通前序遍历---------");
        binTreeDemo.commonBefore(rootNode);
        System.out.println("-----------普通中序遍历---------");
        binTreeDemo.commonMid(rootNode);
        System.out.println("-----------普通后序遍历---------");
        binTreeDemo.commonAfter(rootNode);
        System.out.println("-------深度优先-前序递归--------");
        binTreeDemo.recursiveBefore(rootNode);
        System.out.println("-------深度优先-中序递归--------");
        binTreeDemo.recursiveMid(rootNode);
        System.out.println("--------深度优先-后序递归-------");
        binTreeDemo.recursiveAfter(rootNode);
        System.out.println("--------深度优先-前序遍历-------");
        binTreeDemo.traverseBefore(rootNode);
        System.out.println("--------深度优先-中序遍历-------");
        binTreeDemo.traverseMid(rootNode);
        System.out.println("--------深度优先-后序遍历-------");
        binTreeDemo.traverseAfter(rootNode);
        System.out.println("-------广度优先-层序遍历--------");
        binTreeDemo.traverseLevel(rootNode);

        System.out.println("-----------节点总数---------");
        System.out.println(binTreeDemo.countNode(rootNode));
        System.out.println("-----------叶子节点总数---------");
        System.out.println(binTreeDemo.countLeafNode(rootNode));
        System.out.println("-----------树高度/深度---------");
        System.out.println(binTreeDemo.height(rootNode));
        System.out.println("-----------第K层节点树---------");
        System.out.println(binTreeDemo.countLevelNode(rootNode,3));
        System.out.println("-----------两棵树是否结构相等---------");
        System.out.println(binTreeDemo.equalStructure(rootNode.leftNode,rootNode.rightNode));
        System.out.println("-----------树的镜像---------");
        binTreeDemo.mirror(rootNode);
        binTreeDemo.traverseLevel(rootNode);
        System.out.println("-------------还原--------------");
        binTreeDemo.mirror(rootNode);
        binTreeDemo.traverseLevel(rootNode);
        System.out.println("-----------最低公共祖先---------");
        System.out.println(binTreeDemo.lowestCommonAncestor(rootNode,rootNode.leftNode.rightNode,rootNode.rightNode).getValue());
        System.out.println("-----------两个节点之间的最小距离---------");
        System.out.println(binTreeDemo.distance(rootNode,rootNode.leftNode.rightNode,rootNode.rightNode));
        System.out.println("-----------查找所有祖先节点---------");
        binTreeDemo.allAncestor(rootNode,rootNode.leftNode.rightNode);
        System.out.println("-----------判断二叉树是不是完全二叉树---------");
        System.out.println(binTreeDemo.isPerfect(rootNode));

    }

    /**
     * 将二叉树转为双端链表
     * @param root
     * @return
     */
    public Node toList(Node root){
        return null;
    }

    /**
     * 将一个排序的list 转换为平衡二叉树
     * @param list
     * @return
     */
    public Node toTree(List<Integer> list,int startIndex,int endIndex){

        return null;

    }


    /**
     * 判断是否为完全二叉树
     * 若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
     * 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树（Complete Binary Tree）
     * @param root
     * @return
     */
    public boolean isPerfect(Node root){
        if (root == null){
            return true;
        }
        boolean border = false;
        Node tmp;
        LinkedList<Node> list = new LinkedList<>();
        list.push(root);
        while (!list.isEmpty()){
            tmp = list.pop();
            if (tmp.leftNode == null){
                if (tmp.rightNode != null){
                    return false;
                }
            }else {
                if (border){
                    return false;
                }
                list.push(tmp.leftNode);
                if (tmp.rightNode == null){
                    border = true;
                }else {
                    list.push(tmp.rightNode);
                }
            }
        }
        return true;
    }


    /**
     * 查找所有祖先节点
     * @param root
     * @param node
     */
    public boolean allAncestor(Node root,Node node){
        if (root == null){
            return false;
        }
        if (root == node){
            return true;
        }
        if (allAncestor(root.leftNode,node) || allAncestor(root.rightNode,node)){
            System.out.println(root.getValue());
            return true;
        }
        return false;
    }

    /**
     * 求两个节点的最短距离
     * @param node1
     * @param node2
     * @return
     */
    public int distance(Node root,Node node1,Node node2){
        Node nodeLCA = lowestCommonAncestor(root,node1,node2);
        return nodeLevel(nodeLCA,node1) + nodeLevel(nodeLCA,node2);
    }

    /**
     * 计算子节点所在层级
     * @param root
     * @param node
     * @return
     */
    private int nodeLevel(Node root, Node node) {
        if (root == null){
            return -1;
        }
        if (root == node){
            return 0;
        }
        int level = nodeLevel(root.leftNode,node);
        if (level == -1){
            level = nodeLevel(root.rightNode,node);
            if (level == -1){
                return level;
            }
        }
        return level +1;
    }

    /**
     * 求最低公共祖先
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public Node lowestCommonAncestor(Node root,Node node1,Node node2){
        if (root == null){
            return null;
        }
        if (node1 == root || node2 == root){
            return root;
        }
        Node left = lowestCommonAncestor(root.leftNode,node1,node2);
        Node right = lowestCommonAncestor(root.rightNode,node1,node2);
        if (left != null && right != null){
            return root;
        }
        return left == null ? right:left;
    }

    /**
     * 对树进行镜像
     * 对于每个节点，交换它的左右孩子
     * @param root
     */
    public void mirror(Node root){
        if (root == null){
            return;
        }
        Node tmp = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = tmp;
        mirror(root.leftNode);
        mirror(root.rightNode);
    }

    /**
     * 比较两个二叉树结构是否相同
     * @param node1
     * @param node2
     * @return
     */
    public boolean equalStructure(Node node1,Node node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        boolean left = equalStructure(node1.leftNode,node2.leftNode);
        boolean right = equalStructure(node1.rightNode,node2.rightNode);
        return left && right;
    }

    /**
     * 求第K层的节点数目
     * @param root
     * @param k
     * @return
     */
    public int countLevelNode(Node root,int k){
        if (root == null || k<1){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        return countLevelNode(root.leftNode,k-1) + countLevelNode(root.rightNode,k-1);
    }

    /**
     * 求树高度
     * @param root
     * @return
     */
    public int height(Node root){
        if (root == null){
            return 0;
        }
        int leftTreeHeight = height(root.leftNode);
        int rightTreeHeight = height(root.rightNode);
        return leftTreeHeight > rightTreeHeight?leftTreeHeight+1:rightTreeHeight+1;
    }

    /**
     * 求树的叶子节点数
     * @param root
     * @return
     */
    public int countLeafNode(Node root){
        if (root == null){
            return 0;
        }
        if (root.leftNode == null && root.rightNode == null){
            return 1;
        }else {
            int leftTreeCount = countLeafNode(root.leftNode);
            int rightTreeCount = countLeafNode(root.rightNode);
            return  leftTreeCount + rightTreeCount;
        }
    }

        /**
         * 求树的节点数
         * @param root
         * @return
         */
        public int countNode(Node root){
            if (root == null){
                return 0;
            }
            int leftTreeCount = countNode(root.leftNode);
            int rightTreeCount = countNode(root.rightNode);
            return leftTreeCount + rightTreeCount + 1;
        }

    /**
     * 先序遍历，迭代实现
     */
    public void recursiveBefore(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.getValue());
        recursiveBefore(node.leftNode);
        recursiveBefore(node.rightNode);
    }

    /**
     * 中序遍历，迭代实现
     * @param node
     */
    public void recursiveMid(Node node){
        if (node == null){
            return;
        }
        recursiveMid(node.leftNode);
        System.out.println(node.getValue());
        recursiveMid(node.rightNode);
    }

    /**
     * 后序遍历，迭代实现
     * @param node
     */
    public void recursiveAfter(Node node){
        if (node == null){
            return;
        }
        recursiveAfter(node.leftNode);
        recursiveAfter(node.rightNode);
        System.out.println(node.getValue());
    }

    /**
     * 遍历实现 前序
     * @param root
     */
    public void traverseBefore(Node root){
        LinkedList<Node> list = new LinkedList<>();
        Node currentNode = root;
        //从根开始，一只先访问左子树，再访问右子树，退出某一层级时当前栈顶则为根节点
        while (currentNode != null || !list.isEmpty()){
            while (currentNode != null){
                System.out.println(currentNode.getValue());
                list.push(currentNode);
                currentNode = currentNode.leftNode;
            }
            currentNode = list.pop().rightNode;
        }
    }

    /**
     * 遍历实现 中序
     * @param root
     */
    public void traverseMid(Node root){
        LinkedList<Node> list = new LinkedList<>();
        Node currentNode = root;
        //从根开始，一只先访问左子树，再访问父节点，再访问右子树，退出某一层级时当前栈顶则为根节点
        while (currentNode != null || !list.isEmpty()){
            while (currentNode != null){
                list.push(currentNode);
                currentNode = currentNode.leftNode;
            }
            Node self = list.pop();
            System.out.println(self.getValue());
            currentNode = self.rightNode;
        }

    }

    /**
     * 遍历实现 后序
     * @param root
     */
    public void traverseAfter(Node root){
        LinkedList<Node> list = new LinkedList<>();
        //1 标识仅访问了左节点，2标识左右节点都已经访问了
        LinkedList<Integer> visitedState = new LinkedList<>();
        Node currentNode = root;
        //从根开始，一只先访问左子树，再访问右子树，再访问父节点，退出某一层级时当前栈顶则为根节点
        while (currentNode != null || !list.isEmpty()){
            while (currentNode != null){
                //一层层遍历左节点
                list.push(currentNode);
                currentNode = currentNode.leftNode;
                visitedState.push(1);
            }
            while (!list.isEmpty() && visitedState.peek() ==2){
                visitedState.pop();
                System.out.println(list.pop().getValue());
            }
            if (!list.isEmpty()){
                currentNode = list.peek().rightNode;
                visitedState.pop();
                visitedState.push(2);
            }
        }
    }

    /**
     * 层序遍历
     * 广度优先遍历
     * @param root
     */
    public void traverseLevel(Node root){
        if (root == null){
            return;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()){
            Node tmp = list.poll();
            System.out.println(tmp.getValue());
            if (tmp.leftNode != null){
                list.offer(tmp.leftNode);
            }
            if (tmp.rightNode != null){
                list.offer(tmp.rightNode);
            }
        }
    }

    /**
     * 普通前序遍历
     * 不使用栈操作
     * @param node
     */
    public void commonBefore(Node node){
        Node cur = node;
        Node pre;
        while (cur != null){
            if (cur.leftNode == null){
                System.out.println(cur.getValue());
                cur = cur.rightNode;
            }else {
                pre = cur.leftNode;
                while (pre.rightNode != null && pre.rightNode != cur){
                    pre = pre.rightNode;
                }
                if (pre.rightNode == null){
                    System.out.println(cur.getValue());
                    pre.rightNode = cur;
                    cur = cur.leftNode;
                }else {
                    pre.rightNode = null;
                    cur = cur.rightNode;
                }

            }
        }
    }

    /**
     * 普通中序遍历
     * 不使用栈操作
     * @param node
     */
    public void commonMid(Node node){
        Node cur = node;
        Node pre ;
        while (cur != null){
            if (cur.leftNode == null){
                System.out.println(cur.getValue());
                cur = cur.rightNode;
            }else {
                pre = cur.leftNode;
                while (pre.rightNode != null && pre.rightNode != cur){
                    pre = pre.rightNode;
                }
                if (pre.rightNode == null){
                    pre.rightNode = cur;
                    cur = cur.leftNode;
                }else {
                    System.out.println(cur.getValue());
                    pre.rightNode = null;
                    cur = cur.rightNode;
                }

            }
        }
    }

    /**
     * 普通后序
     * 遍历
     * 不使用栈操作
     * @param node
     */
    public void commonAfter(Node node){
        Node virtualNode = new Node(-1);
        virtualNode.leftNode = node;
        Node cur = virtualNode;
        Node pre ;
        while (cur != null){
            if (cur.leftNode == null){
                cur = cur.rightNode;
            }else {
                pre = cur.leftNode;
                while (pre.rightNode != null && pre.rightNode != cur){
                    pre = pre.rightNode;
                }
                if (pre.rightNode == null){
                    pre.rightNode = cur;
                    cur = cur.leftNode;
                }else {
                    pre.rightNode = null;
                    reverseVisit(cur.leftNode,pre);
                    cur = cur.rightNode;
                }

            }
        }
    }

    private void reverseVisit(Node from, Node to) {
        if (from == to){
            System.out.println(from.getValue());
            return;
        }
        reverseVisit(from.rightNode,to);
        System.out.println(from.getValue());
    }


    private Node root;
    /**
     * 节点
     */
    static class Node {

        private Integer value;
        private Node leftNode;
        private Node rightNode;

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
