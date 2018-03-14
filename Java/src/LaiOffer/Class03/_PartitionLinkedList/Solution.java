/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 */
package LaiOffer.Class03._PartitionLinkedList;

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
    public ListNode partition(ListNode head, int target) {
        // Write your solution here
        ListNode left = null, right = null, leftTail = null, rightTail = null;

        while(head!=null){

            ListNode tmp = head.next;
            head.next = null;

            if(head.value < target){
                if(left == null){
                    leftTail = head;
                    left = leftTail;
                }
                else{
                    leftTail.next = head;
                    leftTail = leftTail.next;

                }

            }
            else{
                if(right == null){
                    rightTail = head;
                    right = rightTail;
                }
                else{
                    rightTail.next = head;
                    rightTail = rightTail.next;
                }
            }

            head = tmp;
        }

        if(left == null || right == null){
            return (left == null)?right:left;
        }
        leftTail.next = right;
        return left;
    }
}
