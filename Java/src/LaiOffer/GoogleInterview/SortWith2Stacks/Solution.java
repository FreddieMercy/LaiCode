package LaiOffer.GoogleInterview.SortWith2Stacks;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    public void sort(LinkedList<Integer> s1) {

        // Write your solution here.
        Deque<Integer> s2 = s1;
        Deque<Integer> right = new LinkedList<>();

        int len = s2.size();

        while(right.size()<len){

            if(right.size()==0||s2.peek() >= right.peek()){
                right.offerFirst(s2.poll());
                continue;
            }

            int tmp = s2.pop();

            while(right.size()!=0&&right.peek()>tmp){
                s2.offerFirst(right.poll());
            }
            right.offerFirst(tmp);
        }

        while(right.size()!=0){
            s2.offerFirst(right.poll());
        }


    }
}
