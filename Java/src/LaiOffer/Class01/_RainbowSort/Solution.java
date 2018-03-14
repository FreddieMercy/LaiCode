package LaiOffer.Class01._RainbowSort;

public class Solution {
    private void swap(int[] array, int i, int j){
        if (array == null || array.length==0||i<0||j<0||i>= array.length||j>=array.length) {
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private void rainbowSortHelper(int[] array){
        if (array == null || array.length==0) {
            return;
        }

        int i=0,j=0,k= array.length-1;

        while(j<=k) {
            switch (array[j]) {
                case -1:
                    swap(array, i, j);
                    i++;
                    j++;
                    break;
                case 1:
                    swap(array, j, k);
                    k--;
                    break;
                case 0:
                    swap(array, i, j);
                    j++;
                    break;
                default:
                    j++; //I chose to ignore it
                    break;
            }
        }
    }
    public int[] rainbowSort(int[] array) {
        // Write your solution here.
        rainbowSortHelper(array);
        return array;
    }
}
