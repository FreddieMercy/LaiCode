package LaiOffer.Class16._PerfectShuffle;

import java.util.Random;

public class Solution {
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void shuffle(int[] array) {
        // Write your solution here.
        if (array == null || array.length <= 0) {
            return;
        }

        Random rdm = new Random();
        for (int i = array.length - 1; i >=1 ; --i) {
            swap(array, i, rdm.nextInt(i+1));
        }
    }
}