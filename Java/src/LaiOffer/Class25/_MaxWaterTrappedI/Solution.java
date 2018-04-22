package LaiOffer.Class25._MaxWaterTrappedI;

public class Solution {
    public int maxTrapped(int[] array) {
        // Write your solution here

        if(array==null){
            return 0;
        }

        int L = array.length;

        int water = 0;
        int ans = 0;
        int highest = 0;

        for(int i=1; i < L; ++i){
            if(array[i] < array[highest]){
                water+=array[highest]-array[i];
            }
            else{
                ans +=water;
                water = 0;
                highest = i;
            }
        }

        water = 0;
        int end = highest;
        int i = L-2;
        highest = L-1;

        while (i>=end){
            if(array[i] < array[highest]){
                water+=array[highest]-array[i];
            }
            else{
                ans +=water;
                water = 0;
                highest = i;
            }
            i--;
        }

        return ans;
    }
}
