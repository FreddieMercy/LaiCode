package LaiOffer.Class16._Random7UsingRandom5;

import java.util.Random;

class RandomFive{
    public int random5(){
        return 0;
    }
}

public class Solution {
    private RandomFive rdm5 = new RandomFive();
    public int random7() {
        // write your solution here
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.
        while (true) {
            int tmp = rdm5.random5() * 5 + rdm5.random5();
            if (tmp < 21) {
                return tmp % 7;
            }
        }
    }
}
