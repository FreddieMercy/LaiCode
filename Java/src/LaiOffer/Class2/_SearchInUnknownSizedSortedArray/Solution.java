package LaiOffer.Class2._SearchInUnknownSizedSortedArray;

  interface Dictionary {
    public Integer get(int index);
  }

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
    private int binarySearchHelper(Dictionary array, int target, int left, int right) {
        if (array == null) {
            return -1;
        }
        if (left > right) {
            return -1;
        }

        int mid = (right - left) / 2 + left;

        if (array.get(mid) != null) {
            if ((int) array.get(mid) == target) {
                return mid;
            }

            if ((int) array.get(mid) > target) {
                return binarySearchHelper(array, target, left, mid - 1);
            }

            return binarySearchHelper(array, target, mid + 1, right);

        }

        return binarySearchHelper(array, target, left, mid - 1);
    }

    public int search(Dictionary dict, int target) {

        int index = 0;

        while (dict.get(index) != null && (int) dict.get(index) < target) {
            if (index == 0) {
                index = 1;
            } else {
                index *= 2;
            }
        }

        return binarySearchHelper(dict, target, index / 2, index);

    }
}