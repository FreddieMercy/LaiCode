/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laiCode;
import com.sun.tools.javac.util.ArrayUtils;
import javafx.util.Pair;

import java.lang.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.DelayQueue;
import LaiOffer.Class6._CombinationsOfCoins.Solution;
/**
 *
 * @author junhao.zhang.freddie
 */

public class laiCode {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        Solution x = new Solution();
        for(List<Integer> i : x.combinations(99, new int[]{1,5,10,25})) {
            for(Integer j : i){
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}