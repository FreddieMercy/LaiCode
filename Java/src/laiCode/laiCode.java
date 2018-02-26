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

/**
 *
 * @author junhao.zhang.freddie
 */

public class laiCode {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = new StringBuilder("abc");
        if (a.equals(b)) {
            System.out.println(a.hashCode());
            System.out.println(b.hashCode());
        } else {
            System.out.println("Not equal");
        }
    }
}