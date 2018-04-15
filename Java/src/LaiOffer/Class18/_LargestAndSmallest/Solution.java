package LaiOffer.Class18._LargestAndSmallest;

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;


public class Solution {

    private int large(List<Integer> a) {
        if (a.size() <= 2) {
            return (a.get(0) > a.get(a.size() - 1)) ? a.get(0) : a.get(a.size() - 1);
        }

        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < a.size() - 1; i += 2) {
            if (a.get(i) < a.get(i + 1)) {
                g.add(a.get(i + 1));
            } else {
                g.add(a.get(i));
            }
        }
        g.add(a.get(a.size() - 1));

        return large(g);
    }

    private int small(List<Integer> a) {
        if (a.size() <= 2) {
            return (a.get(0) < a.get(a.size() - 1)) ? a.get(0) : a.get(a.size() - 1);
        }

        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < a.size() - 1; i += 2) {
            if (a.get(i) < a.get(i + 1)) {
                g.add(a.get(i));
            } else {
                g.add(a.get(i + 1));
            }
        }
        g.add(a.get(a.size() - 1));

        return small(g);
    }

    public int[] largestAndSmallest(int[] array) {
        // Write your solution here
        if (array == null) {
            return array;
        }
        if (array.length <= 2) {
            Arrays.sort(array);
            return new int[]{array[array.length - 1], array[0]};
        }
        List<Integer> g = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < array.length - 1; i += 2) {
            if (array[i] < array[i + 1]) {
                g.add(array[i + 1]);
                l.add(array[i]);
            } else {
                g.add(array[i]);
                l.add(array[i + 1]);
            }
        }
        g.add(array[array.length - 1]);
        l.add(array[array.length - 1]);

        return new int[]{large(g), small(l)};
    }
}

/*
class ArrayRef{
    public int [] array;

    public ArrayRef(int[] a){
        array = a;
    }
}

public class Solution {

    private void radixSortPos(ArrayRef input, int exp) {
        int[] counter = new int[10];
        int[] tmp = new int[input.array.length];
        int[] digits = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : input.array) {
            counter[(i / exp) % 10]++;
        }

        for (int i : digits) {
            counter[i] += counter[i - 1];
        }
        for (int i = input.array.length - 1; i >= 0; --i) {
            tmp[(counter[(input.array[i] / exp) % 10]--) - 1] = input.array[i];
        }

        input.array = tmp;
    }

    private int[] radixSort(int[] array) {
        int[] exps = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        ArrayRef input = new ArrayRef(array);
        for (int exp : exps) {
            radixSortPos(input, exp);
        }
        return new int[]{input.array[input.array.length - 1], input.array[0]};
    }

    public int[] largestAndSmallest(int[] array) {
        // Write your solution here
        return radixSort(array);
    }
}
*/