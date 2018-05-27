package LaiOffer.Class26._MajorityNumberI;

public class Solution {
    public int majority(int[] array) {
        // Write your solution here

        int ans = 0;
        int counter = 0;

        for(int i :array){
            if(counter==0){
                ans = i;
                counter++;
            }
            else if(ans==i){
                counter++;
            }
            else{
                counter--;
            }
        }
        return ans;
    }
}
