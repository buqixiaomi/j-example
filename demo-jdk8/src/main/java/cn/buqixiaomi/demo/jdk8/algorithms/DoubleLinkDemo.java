package cn.buqixiaomi.demo.jdk8.algorithms;

/**
 * description
 * 双向链表
 * 可以双向遍历
 * @author lishengkai
 * @date 2018-09-20 9:36
 */
public class DoubleLinkDemo {

    public static void main(String[] args) {
        DoubleLinkDemo doubleLinkDemo = new DoubleLinkDemo();
        doubleLinkDemo.addLast(1);
        doubleLinkDemo.addLast(2);
        doubleLinkDemo.addLast(4);
        doubleLinkDemo.addLast(5);
        doubleLinkDemo.addLast(6);
        doubleLinkDemo.addLast(7);
        doubleLinkDemo.addLast(8);
        doubleLinkDemo.addLast(9);
        doubleLinkDemo.addLast(10);
        doubleLinkDemo.add(1,3);
        System.out.println(doubleLinkDemo);

    }


    public void addLast(Integer value){
        Node node = new Node(value);
        if(size==0){
            first = node;
            last = node;
        }else{
            node.setPre(last);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    public void addFirst(Integer value) {
        Node node = new Node(value);
        if(size==0){
            first = node;
            last = node;
        }else{
            first.setPre(node);
            node.setNext(first);
            first = node;
        }
        size++;
    }

    public void add(int index,Integer value){
        if (index <size){
            if (size == 0){
                Node node = new Node(value);
                first = node;
                last = node;
                size++;
            }else if (index == 0){
                addFirst(value);
            }else if (index ==size -1){
                addLast(value);
            }else{
                Node node = new Node(value);
                Node tmp = getNode(index);
                node.setPre(tmp);
                node.setNext(tmp.getNext());
                tmp.setNext(node);
                size++;
            }
        }else {
            throw new IndexOutOfBoundsException("插入位置无效或超出链表长度");
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = first;
        while (node != null){
            System.out.println(node.getValue());
            node = node.getNext();
        }
        return stringBuilder.toString();
    }

    public Node getNode(int index) {
        if (index > size -1){
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        Node node = first;
        for (int i=0;i<index;i++){
            node = node.getNext();
        }
        return node;
    }


    private int size = 0;
    private Node first;
    private Node last;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    class Node{
        private int value;
        private Node pre;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
