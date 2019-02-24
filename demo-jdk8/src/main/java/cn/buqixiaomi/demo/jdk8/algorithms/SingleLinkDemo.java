package cn.buqixiaomi.demo.jdk8.algorithms;

/**
 * description
 * 单向链表
 * 只可以向一端遍历
 * @author lishengkai
 * @date 2018-09-19 17:44
 */
public class SingleLinkDemo {

    public static void main(String[] args) {

        SingleLinkDemo singleLinkDemo = new SingleLinkDemo();
        singleLinkDemo.addLast(1);
        singleLinkDemo.addLast(2);
        singleLinkDemo.addLast(3);
        singleLinkDemo.addLast(4);
        singleLinkDemo.addLast(5);
        singleLinkDemo.addLast(6);
        singleLinkDemo.addLast(7);
        singleLinkDemo.addLast(8);
        singleLinkDemo.addLast(9);
        singleLinkDemo.addLast(10);
        singleLinkDemo.toString();
        singleLinkDemo.reverseLink();
        singleLinkDemo.toString();


    }

    /**
     * 反转链表
     */
    public void reverseLink(){
        Node tmp = first;
        last = tmp;
        Node next = first.getNext();
        for (int i = 0;i<size-1;i++){
            Node nextNode = next.getNext();
            next.setNext(tmp);
            tmp = next;
            next = nextNode;
        }
        last.setNext(null);
        first = tmp;
    }


    private int size;
    private Node first;
    private Node last;

    public void addLast(Integer value){
        Node node = new Node(value);
        if(size==0){
            first = node;
            last = node;
        }else{
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

    static class Node {
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
