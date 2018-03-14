package LaiOffer.Class03._ReOrderLinkedList;
import java.util.*;

class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int value) {
    this.value = value;
    next = null;
  }
}

public class Solution {
    public ListNode reorder(ListNode head) {
        // Write your solution here

        if(head == null){
            return null;
        }
        boolean odd = true;
        Stack<ListNode> left = new Stack<>();
        ListNode right = head, mid=null;

        while(head!=null){
            head = head.next;
            odd = !odd;
            if(odd){
                left.push(right);
                right = right.next;
            }
        }
        if(!odd){
            mid = right;
            right = right.next;
            mid.next = null;
        }

        while(!left.empty()){
            left.peek().next = right;
            right = right.next;
            left.peek().next.next = mid;
            mid = left.pop();
        }

        return mid;
    }
}
