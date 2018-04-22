package LaiOffer.Class26._ImplementLRUCache;

import java.util.HashMap;

public class Solution<K, V> {
    // limit is the max capacity of the cache
    class Node {
        public Node pre = null;
        public Node next = null;
        public V value;
        private final K key;

        public Node(K k, V v) {
            value = v;
            this.key = k;
        }
    }

    private final int limit;
    private HashMap<K, Node> m;
    private Node head = new Node(null, null);
    private Node tail = head;
    private int size = 0;

    private void used(Node n) {

        if (head.next != n) {
            if(tail==n){
                tail=tail.pre;
            }
            n.pre.next = n.next;
            if(n.next!=null) {
                n.next.pre = n.pre;
            }
            n.next = head.next;

            if(head.next!=null) {
                head.next.pre = n;
            }

            n.pre = head;
            head.next = n;
        }
    }

    private void pop() {
        m.remove(tail.key);
        tail = tail.pre;
        tail.next = null;
        size--;
    }

    public Solution(int limit) {
        this.limit = limit;
        m = new HashMap<>();
    }

    private void insert(K k, V v) {
        Node n = new Node(k, v);

        if(tail==head){
            tail=n;
        }

        n.next = head.next;

        if(head.next!=null) {
            head.next.pre = n;
        }
        n.pre = head;
        head.next = n;

        m.put(k, n);
    }

    public void set(K key, V value) {

        Node tmp = m.get(key);
        if (tmp == null) {
            if (size >= limit) {
                pop();
            }
            size++;
            insert(key,value);

        } else {
            used(tmp);
            tmp.value=value;
        }
    }

    public V get(K key) {
        Node tmp = m.get(key);
        if(tmp==null){
            return null;
        }
        used(tmp);
        return tmp.value;
    }
}