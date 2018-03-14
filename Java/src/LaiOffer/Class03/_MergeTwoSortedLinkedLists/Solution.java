/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 */
package LaiOffer.Class03._MergeTwoSortedLinkedLists;
import java.lang.*;

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
    public ListNode merge(ListNode one, ListNode two) {
        // Write your solution here
        ListNode ans = new ListNode(-999);
        ListNode head = ans;
        while (one != null && two != null) {

            if (one.value < two.value) {
                ans.next = one;
                one = one.next;
            } else {
                ans.next = two;
                two = two.next;
            }

            ans = ans.next;

        }

        if (one != null) {
            ans.next = one;
        } else {
            ans.next = two;
        }
        return head.next;
    }
}