/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug06th2017._234PalindromeLinkedList;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        Queue<ListNode> q = new LinkedList<ListNode>();
        Stack<ListNode> s = new Stack<ListNode>();
        
        while(head!=null){
            q.add(head);
            s.push(head);
            head = head.next;
        }
        
        while(!s.empty()){
            if(q.peek().val!=s.peek().val){
                return false;
            }
            s.pop();
            q.poll();
        }
        
        return true;
    }
}