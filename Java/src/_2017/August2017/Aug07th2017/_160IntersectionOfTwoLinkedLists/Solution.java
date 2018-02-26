/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug07th2017._160IntersectionOfTwoLinkedLists;
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        while(A!=null){
            s1.push(A);
            A = A.next;
        }
        
        while(B!=null){
            s2.push(B);
            B = B.next;
        }
        
        ListNode tmp = null;
        
        while(!s1.empty() && !s2.empty() && s1.peek() == s2.peek()){
            tmp = s1.pop();
            s2.pop();
        }
        
        return tmp;
    }
}