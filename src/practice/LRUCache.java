package practice;

import java.util.HashMap;

//class LRUCache {
//    HashMap<Integer, Node> map = new HashMap<>();
//    int capacity;
//    Node head, tail;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        head = new Node(-1, -1);
//        tail = new Node(-1, -1);
//        head.next = tail;
//        tail.pre = head;
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            Node node = map.get(key);
//            cutNode(node);
//            insertHead(node);
//            return node.val;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            Node node = map.get(key);
//            node.val = value;
//            cutNode(node);
//            insertHead(node);
//        } else {
//            Node node = new Node(key, value);
//            map.put(key, node);
//            insertHead(node);
//            if (map.size() > capacity) {
//                // 插入新节点才有可能超了，从链表尾巴切断，记住更新map
//                Node delNode = cutTail();
//                map.remove(delNode.key);    // 节点必须绑定key才能找到对应的k-v对
//            }
//        }
//    }
//
//    private void cutNode(Node node) {   // 切掉node连接并连接前后节点
//        node.pre.next = node.next;
//        node.next.pre = node.pre;
//        node.pre = null;
//        node.next = null;
//    }
//
//    private Node cutTail() {    // 切掉最后一个节点，并返回被删除的节点
//        Node last = tail.pre;
//        last.pre.next = tail;
//        tail.pre = last.pre;
//        last.pre = null;
//        last.next = null;
//        return last;
//    }
//
//    private void insertHead(Node node) {   // 将某个无连接节点插入头结点
//        Node next = head.next;
//        node.next = next;
//        node.pre = head;
//        next.pre = node;
//        head.next = node;
//    }
//
//    // 双向链表类
//    class Node {
//        int key;
//        int val;
//        Node next;
//        Node pre;
//        public Node(int _key, int _val) {
//            key = _key;
//            val = _val;
//        }
//    }
//}


// 官方题解
class LRUCache {
    private int capacity;
    private int n;
    private DoubleLinkedList pHead,pTail;
    private DoubleLinkedList[] hash;

    private class DoubleLinkedList{
        int key, val;
        DoubleLinkedList prev, next;
        public DoubleLinkedList(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.n = 0;
        hash = new DoubleLinkedList[10001];
        pHead = new DoubleLinkedList(-1,0);
        pTail = new DoubleLinkedList(-2,0);
        pHead.next = pTail;
        pTail.prev = pHead;
    }

    public int get(int key) {
        DoubleLinkedList node = hash[key];
        if(node==null){
            return -1;
        }
        moveFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        DoubleLinkedList node = hash[key];
        if(node == null && n < capacity){
            node = new DoubleLinkedList(key,value);
            hash[key] = node;
            addFront(node);
            n++;
            return;
        }
        if(node ==null && n==capacity){
            node = pTail.prev;
            hash[node.key] = null;
            hash[key] = node;
        }
        node.key = key;
        node.val = value;
        moveFront(node);
    }

    // 删除节点在原始列表中的位置并插入到头节点之后
    private void moveFront(DoubleLinkedList node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addFront(node);
    }

//   在头节点之后插入节点
    private void addFront(DoubleLinkedList node){
        node.prev = pHead;
        node.next = pHead.next;
        pHead.next.prev = node;
        pHead.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
