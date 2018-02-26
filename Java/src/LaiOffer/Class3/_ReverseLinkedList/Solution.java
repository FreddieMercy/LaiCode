package LaiOffer.Class3._ReverseLinkedList;

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
        // Write your solution here
        ListNode ans = null;
        while(head!=null){
            ListNode tmp = new ListNode(head.value);
            tmp.next = ans;
            ans = tmp;
            head = head.next;
        }
        return ans;
    }
}
