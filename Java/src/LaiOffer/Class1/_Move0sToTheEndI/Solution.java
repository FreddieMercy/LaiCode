package LaiOffer.Class1._Move0sToTheEndI;

public class Solution {
    private void swap(int[] array, int i, int j){
        if (array == null || array.length==0||i<0||j<0||i>= array.length||j>=array.length) {
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private void moveZeroHelper(int[] array){
        if (array == null || array.length==0) {
            return;
        }

        int i=0,k= array.length-1;

        while(i<=k) {

            switch (array[i]) {
                case 0:
                    swap(array, i, k);
                    k--;
                    break;
                default:
                    i++;
                    break;
            }
        }
    }
    public int[] moveZero(int[] array) {
        // Write your solution here.
        moveZeroHelper(array);
        return array;
    }
}
