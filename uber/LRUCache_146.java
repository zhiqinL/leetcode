package leetcode.uber;

import java.util.*;

public class LRUCache_146 {

    private Map<Integer, Node> map;
    private int cap;
    private Node head, tail;
    public LRUCache_146(int capacity) {
        map = new HashMap();
        cap = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void moveNodeToHead(Node node, boolean isNewNode) {
        if(!isNewNode) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private int deleteTailNode() {
        Node last = tail.prev;
        tail.prev = last.prev;
        last.prev.next = tail;

        return last.key;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveNodeToHead(node, false);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = null;
        boolean isNewNode = false;
        if(!map.containsKey(key)) {
            map.put(key, new Node(key, value));
            isNewNode = true;

            if(cap == 0) {
                int lastKey = deleteTailNode();
                map.remove(lastKey);
            }
            else cap--;
        }

        node = map.get(key);
        node.value = value;
        moveNodeToHead(node, isNewNode);
    }

    class Node {
        Node next, prev;
        int key, value;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}
