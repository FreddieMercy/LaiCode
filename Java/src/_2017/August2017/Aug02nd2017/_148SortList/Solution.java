/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug02nd2017._148SortList;
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
    ListNode(int x) { val = x; }
}

public class Solution {
    private ListNode MergeSort(ListNode head, ListNode tail, int length){
        if(length == 0){
            return null;
        }
        if(length == 1){
            head.next = null;
            return head;
        }
        
        int left = 0;
        ListNode root = head;
        while(left<length/2 && root != null){
            left++;
            root = root.next;
        }
        ListNode front = this.MergeSort(head, root, left);
        ListNode end = this.MergeSort(root, tail, length-left);
        ListNode Smaller = null;
        ListNode Bigger = null;
        if(front.val > end.val){
            Smaller = end;
            Bigger = front;
        }
        else{
            Bigger = end;
            Smaller = front;
        }
        root = Smaller;
        
        while(Bigger!=null){
            while(Smaller.next!=null && Smaller.next.val<Bigger.val){
                Smaller = Smaller.next;
            }
            ListNode tmp = Smaller.next;
            Smaller.next = Bigger;
            Smaller = Smaller.next;
            Bigger = Bigger.next;
            Smaller.next = tmp;
        }
        
        return root;
    }
    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode root = head;
        while(root!=null){
            root=root.next;
            length++;
        }
        return MergeSort(head,null, length);
    }
}