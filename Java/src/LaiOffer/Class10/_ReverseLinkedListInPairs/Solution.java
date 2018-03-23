package LaiOffer.Class10._ReverseLinkedListInPairs;



 class ListNode {
   public int value;
   public ListNode next;
   public ListNode(int value) {
     this.value = value;
     next = null;
   }
 }

public class Solution {
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here

        ListNode Dummy = new ListNode(0);

        Dummy.next=head;
        ListNode tail = Dummy;

        while(head!=null && head.next!=null) {

            ListNode tmp = head.next.next;
            head.next.next = null;
            ListNode newHead = head.next;
            newHead.next = head;
            newHead.next.next = null;
            tail.next = newHead;
            tail = tail.next.next;
            head = tmp;

        }

        tail.next=head;

        return Dummy.next;
    }
}
