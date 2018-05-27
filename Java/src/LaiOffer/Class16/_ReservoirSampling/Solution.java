package LaiOffer.Class16._ReservoirSampling;

import java.util.Random;

public class Solution {
    private final Integer k;
    private int[] block;
    private int counter = 0;
    private Random rdm = new Random();

    public Solution() {
       this(200);
    }
    public Solution(int K){
        k = K;
        block = new int[k];
    }

    public void read(int value) {
        // Write your implementation here.
        if(counter<k){
            block[counter] = value;
        }else {
            int tmp = rdm.nextInt(counter + 1);
            if (tmp < k) {
                block[tmp] =value;
            }
        }
        counter++;
    }

    public Integer sample() {
        if(counter==0){
            return null;
        }
        return block[rdm.nextInt(Math.min(k, counter)+1)];
    }
}
