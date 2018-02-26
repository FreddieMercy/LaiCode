/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug04th2017._141LinkedListCycle;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
 // Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> tmp = new HashSet<ListNode>();
        while(head!=null)
        {
            if(tmp.contains(head)){
                return true;
            }
            tmp.add(head);
            head = head.next;
        }
        return false;
    }
}