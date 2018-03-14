package LaiOffer.Class03._ReverseLinkedList;

 class ListNode {
     public int value;
     public ListNode next;

     public ListNode(int value) {
         this.value = value;
         next = null;
     }
 }

public class Solution {
    public ListNode reverse(ListNode head) {

        ListNode newHead =null;

        while(head!=null){

            ListNode tmpHead = head.next;

            head.next = newHead;
            newHead = head;

            head = tmpHead;
        }

        return newHead;
    }
}


 /*
public class Solution {
    public ListNode reverse(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = head.next;

        head.next = null;

        ListNode newHead = reverse(tmp);
        tmp.next = head;

        return newHead;

    }
}


 */

