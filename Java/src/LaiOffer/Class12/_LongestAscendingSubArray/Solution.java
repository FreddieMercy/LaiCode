package LaiOffer.Class12._LongestAscendingSubArray;

public class Solution {
    public int longest(int[] array) {
        // Write your solution here

        if(array==null||array.length==0){
            return 0;
        }

        if(array.length==1){
            return 1;
        }

        int ans = 1;
        int tmp = 1;

        for(int i = 1; i < array.length;++i){
            if(array[i]>array[i-1]){
                tmp++;
            }
            else{
                ans = Math.max(ans, tmp);
                tmp=1;
            }
        }

        return Math.max(ans, tmp);
    }
}
