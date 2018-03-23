package LaiOffer.Class11._NumberOfDifferentBits;

public class Solution {
    public int diffBits(int a, int b) {
        // Write your solution here

        int counter = 0;
        int sum = a^b;

        while (sum!=0){
            if((sum&1)==1){
                counter++;
            }
            sum>>>=1;
        }

        return counter;
    }
}
