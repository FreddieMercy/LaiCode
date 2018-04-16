package LaiOffer.Class21._DeepCopyLinkedListWithRandomPointer;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int value) {
        this.value = value;
    }
}

public class Solution {
    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        Map<RandomListNode, RandomListNode> rd = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;

        while (head != null) {
            if (rd.get(head) == null) {
                rd.put(head, new RandomListNode(head.value));
            }
            tail.next = rd.get(head);
            if (head.random != null && rd.get(head.random) == null) {
                rd.put(head.random, new RandomListNode(head.random.value));
            }
            tail.next.random = rd.get(head.random);
            tail = tail.next;
            head = head.next;
        }

        return dummy.next;
    }
}