package LaiOffer.Class11._PowerOfTwo;

public class Solution {
    public boolean isPowerOfTwo(int number) {
        // Write your solution here
        if (number <= 0) {
            return false;
        }

        int counter = 0;

        while (number != 0) {
            if ((number & 1) == 1) {
                counter++;
            }
            number >>>= 1;
        }

        return counter == 1;
    }
}