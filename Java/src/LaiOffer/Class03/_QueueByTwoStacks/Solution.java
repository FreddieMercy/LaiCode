/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class03._QueueByTwoStacks;
import java.util.Stack;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    Stack<Integer> frontStack = new Stack<>();
    Stack<Integer> backeStack = new Stack<>();

    public Integer poll() {
        // Write your solution here
        if (isEmpty()) {
            return null;
        }
        while (!frontStack.empty()) {
            backeStack.push(frontStack.pop());
        }
        Integer ans = backeStack.pop();
        while (!backeStack.empty()) {
            frontStack.push(backeStack.pop());
        }
        return ans;
    }

    public Integer size() {

        return frontStack.size();

    }

    public Boolean isEmpty() {
        return frontStack.empty();
    }

    public void offer(Integer i) {
        frontStack.push(i);
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        while (!frontStack.empty()) {
            backeStack.push(frontStack.pop());
        }
        Integer ans = backeStack.peek();
        while (!backeStack.empty()) {
            frontStack.push(backeStack.pop());
        }
        return ans;
    }
}
