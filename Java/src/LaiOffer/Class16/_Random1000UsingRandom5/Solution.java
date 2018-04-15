package LaiOffer.Class16._Random1000UsingRandom5;

import java.util.Map;

class RandomFive{
    public int random5(){
        return 0;
    }
}

public class Solution {
    private RandomFive rdn5 = new RandomFive();
    public int random1000() {
        // Write your solution here.
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.
        int tar = 1000;
        int tmp1 = 0;
        int tmp = 0;
        int counter = 0;

        while (tmp1 < tar) {
            tmp1 += Math.pow(5, counter)*5;
            tmp += Math.pow(5, counter)*rdn5.random5();
            counter++;
        }

        while (true) {
            if (tmp < tar) {
                return tmp ;
            }
            tmp=0;
            for(int i = 0; i <= counter; ++i){
                tmp += Math.pow(5, i)*rdn5.random5();
            }
        }
    }
}
