package LaiOffer.Class3._MiddleNodeOfLinkedList;

class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int value) {
    this.value = value;
    next = null;
  }
}

public class Solution {
    public ListNode middleNode(ListNode head) {
        // Write your solution here
        ListNode fast = head;
        ListNode slow = head;
        int index = 0;

        while(fast!=null){

            if(index!=0 && index %2 == 0){
                slow = slow.next;
            }

            fast = fast.next;
            index++;
        }
        return slow;
    }
}
