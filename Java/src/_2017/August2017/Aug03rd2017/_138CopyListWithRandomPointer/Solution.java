/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug03rd2017._138CopyListWithRandomPointer;

/**
 *
 * @author junhaozhang
 */
import java.lang.*;
import java.util.*;
//  Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode root = head;
        RandomListNode ans = new RandomListNode(root.label);
        if(root.random != null){
            ans.random = new RandomListNode(root.random.label);
        }
        RandomListNode tmp = ans;
        Set<RandomListNode> visited = new HashSet<RandomListNode>();
        Set<RandomListNode> added = new HashSet<RandomListNode>();
        added.add(root);
        if(root.random!=null){
            visited.add(root.random);
        }
        while(root.next!=null){
            root = root.next;
            ans.next = new RandomListNode(root.label);
            ans = ans.next;
            if(root.random != null){
                ans.random = new RandomListNode(root.random.label);
            }
            added.add(root);
            if(root.random!=null){
                visited.add(root.random);
            }
        }

        for(RandomListNode x : visited){
            if(!added.contains(x)){
                ans.next = new RandomListNode(x.label);
                ans = ans.next;
                if(x.random != null){
                    ans.random = new RandomListNode(x.random.label);
                }
            }
        }
        
        
        return tmp;
    }
}