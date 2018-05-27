package LaiOffer.Class21._MergeKSortedLists;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class Solution {
    private class Pair {
        public final Integer value;
        public final Integer index;

        public Pair(int value, Integer index) {
            this.index = index;
            this.value = value;
        }
    }

    public ListNode merge(List<ListNode> listOfLists) {
        // Write your solution here
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        });
        ListNode[] counter = new ListNode[listOfLists.size()];

        for (int j = 0; j < listOfLists.size(); ++j) {
            if (listOfLists.get(j) != null) {
                pq.add(new Pair(listOfLists.get(j).value, j));
                counter[j] = listOfLists.get(j).next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        while (!pq.isEmpty()) {
            Pair tmp = pq.poll();
            ans.next = new ListNode(tmp.value);

            if (counter[tmp.index] != null) {
                pq.add(new Pair(counter[tmp.index].value, tmp.index));
                counter[tmp.index] = counter[tmp.index].next;
            }
            ans = ans.next;
        }

        return dummy.next;
    }
}