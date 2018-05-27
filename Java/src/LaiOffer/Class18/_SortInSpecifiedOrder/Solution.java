package LaiOffer.Class18._SortInSpecifiedOrder;
import java.util.*;

public class Solution {

    private int isGreater(int o1, int o2, Map<Integer, Integer> order, int size) {
        Integer o = order.get(o1);
        Integer n = order.get(o2);
        if (o != null && n != null) {
            return o - n;
        } else if (o == null && n == null) {
            return o1 - o2;
        } else if (o == null && n != null) {
            return Math.abs(o1) + size;
        } else {
            return 0 - Math.abs(o2) + size;
        }
    }

    public int[] sortSpecial(int[] A1, int[] A2) {
        // Write your solution here
        Map<Integer, Integer> order = new HashMap<>();
        int i = 0;
        if (A2 != null) {
            for (i = 0; i < A2.length; ++i) {
                order.put(A2[i], i + 1);
            }
            i++;
        }
        return quickSort(A1, order, i);
    }

    private void swap(int[] array, int from, int to) {
        if (array == null || from < 0 || to < 0 || from > array.length - 1 || to > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    private int partation(int[] array, int start, int end, Map<Integer, Integer> order, int size) {

        swap(array, (new Random().nextInt(end - start)) + start, end);

        int i = start;
        int j = end;

        while (i < j) {

            while (i < j && isGreater(array[i], array[end], order, size) <= 0) {
                i++;
            }

            while (j > i && isGreater(array[j], array[end], order, size) >= 0) {
                j--;
            }

            if (j > i) {
                swap(array, j, i);
            }
        }

        swap(array, i, end);

        return i;
    }

    private void quickSortHelper(int[] array, int start, int end, Map<Integer, Integer> order, int size) {
        if (start >= end || array == null) {//Error Handling
            return;
        }

        int pivotIndex = partation(array, start, end, order, size);
        quickSortHelper(array, start, pivotIndex - 1, order, size);
        quickSortHelper(array, pivotIndex + 1, end, order, size);

    }

    private int[] quickSort(int[] array, Map<Integer, Integer> order, int size) {
        // Write your solution here
        if (array == null || array.length <= 1) {//Error Handling
            return array;
        }
        quickSortHelper(array, 0, array.length - 1, order, size);
        return array;
    }
}