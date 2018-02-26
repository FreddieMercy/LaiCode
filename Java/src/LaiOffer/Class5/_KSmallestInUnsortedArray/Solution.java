/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
 */
package LaiOffer.Class5._KSmallestInUnsortedArray;
import java.util.Arrays;
/**
 *
@author junhaozhang
 */

public class Solution {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        Arrays.sort(array);

        return Arrays.copyOfRange(array, 0, k);
    }
}
