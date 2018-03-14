package LaiOffer.Class03._InsertInSortedLinkedList;

class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int value) {
    this.value = value;
    next = null;
  }
}

public class Solution {
    public ListNode insert(ListNode head, int value) {
        // Write your solution here
        ListNode ans = head;
        if(ans==null){
            return new ListNode(value);
        }
        else{
            if(ans.value >= value){
                ListNode tmp = new ListNode(value);
                tmp.next = ans;
                return tmp;
            }
            while(ans!=null && ans.next != null){
                if(ans.value <= value && ans.next.value >= value){
                    ListNode tmp = new ListNode(value);
                    tmp.next = ans.next;
                    ans.next = tmp;
                    return head;
                }

                ans = ans.next;
            }

            ans.next = new ListNode(value);
            return head;
        }
    }
}
