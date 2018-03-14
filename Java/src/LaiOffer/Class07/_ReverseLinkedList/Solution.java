/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 */
package LaiOffer.Class07._ReverseLinkedList;

/**
 *
@author junhaozhang
 */

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
