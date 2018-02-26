/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;
import _2017.June2017.Jun10th2017._126WordLadderII.Solution;
import javafx.util.Pair;

import java.lang.*;
import java.util.*;
/**
 *
 * @author junhao.zhang.freddie
 */
public class pq {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return (o1[1]-o1[0])-(o2[1]-o2[0]);
                }

                return o1[0]-o2[0];
            }
        });

        q.add(new int[] {1, 2});

        q.add(new int[] {2, 2});

        q.add(new int[] {3, 2});

        q.add(new int[] {10, 2});

        while(!q.isEmpty()) {
            System.out.print(q.peek()[0]);
            System.out.print(" ");
            System.out.println(q.peek()[1]);
            q.poll();
        }
    }

}