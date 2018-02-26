package LaiOffer.Class2._ClassicalBinarySearch;

public class Solution {
    private int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (array == null || array.length == 0) {
            return -1;
        }

        int mid = (right-left)/2+left;
        if (array[mid] == target) {
            return mid;
        }

        if (array[mid] > target) {
            return binarySearchHelper(array, target, left, mid - 1);
        }

        return binarySearchHelper(array, target, mid + 1, right);

    }

    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        return binarySearchHelper(array, target, 0, array.length-1);
    }
}
