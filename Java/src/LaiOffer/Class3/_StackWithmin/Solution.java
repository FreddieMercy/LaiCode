/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaiOffer.Class3._StackWithmin;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    List<Integer> l = new ArrayList<>();
    public int pop() {
        if(l.size() == 0){

            return -1;
        }
        // Write your solution here
        Integer i = l.get(l.size()-1);
        l.remove(l.size()-1);
        return i;
    }

    public int top(){
        if(l.size() == 0){

            return -1;
        }
        // Write your solution here
        Integer i =l.get(l.size()-1);
        return i;

    }

    public int min(){

        if(l.size() == 0){

            return -1;
        }
        // Write your solution here
        Integer i = l.get(0);

        for(int j : l){
            if(i >  j){
                i = j;
            }
        }

        return i;

    }

    public void push(Integer i){
        if(i== null){

            return;
        }
        l.add(i);
    }
}
