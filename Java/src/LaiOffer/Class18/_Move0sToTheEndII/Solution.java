package LaiOffer.Class18._Move0sToTheEndII;

public class Solution {
    public int[] moveZero(int[] array) {
        // Write your solution here
        if(array==null||array.length<=1){
            return array;
        }
        int end = 0;
        while (end <array.length && array[end]!=0){
            end++;
        }

        for(int cur = end; cur < array.length; ++cur){
            if(array[cur]!=0){
                swap(array,cur,end);
                end++;
            }
        }
        return array;
    }

    private void swap(int[] array, int i , int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
