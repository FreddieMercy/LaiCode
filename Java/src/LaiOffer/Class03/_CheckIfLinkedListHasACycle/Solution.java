/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 */
package LaiOffer.Class03._CheckIfLinkedListHasACycle;

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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean index = true;

        while (fast != null) {

            fast = fast.next;
            index = !index;

            if (index) {
                slow = slow.next;
            }

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}