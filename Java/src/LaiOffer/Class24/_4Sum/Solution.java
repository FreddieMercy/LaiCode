package LaiOffer.Class24._4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private boolean _2sum(int[] array, int target, int head) {

        int i = head + 1;
        int j = array.length - 1;

        int sum;
        while (i < j) {
            sum = array[i] + array[j];
            if (sum == target) {
                return true;

            } else if (sum > target) {
                j--;
            } else {
                i++;
            }

            while (i > head + 1 && i < array.length && array[i] == array[i - 1]) {
                i++;
            }
            while (j >= head + 1 && j < array.length - 1 && array[j + 1] == array[j]) {
                j--;
            }
        }
        return false;
    }

    public boolean exist(int[] array, int target) {

        if (array == null) {
            return false;
        }
        Arrays.sort(array);
        return exist(array, target, -1, 4);
    }

    private boolean exist(int[] array, int target, int head, int num) {

        if (num <= 2) {
            return _2sum(array, target, head);
        }

        for (int i = head+1; i <= array.length-num; ++i) {
            if (i > head+1 && array[i] == array[i - 1]) {
                continue;
            }
            if (exist(array, target - array[i], i, num - 1)) {
                return true;
            }

        }

        return false;
    }
}

/*


public class Solution {
    private boolean _2sum(int[] array, int target, int head) {

        int i = head + 1;
        int j = array.length - 1;

        int sum;
        while (i < j) {
            sum = array[i] + array[j];
            if (sum == target) {
                return true;

            } else if (sum > target) {
                j--;
            } else {
                i++;
            }

            while (i > head+1 && i < array.length && array[i] == array[i - 1]) {
                i++;
            }
            while (j >= head+1 && j < array.length - 1 && array[j + 1] == array[j]) {
                j--;
            }
        }
        return false;
    }

    public boolean exist(int[] array, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        if (array != null) {
            Arrays.sort(array);
            for (int i = 0;i < array.length;++i) {
                if (i > 0 && array[i] == array[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < array.length; ++j) {
                    if(j > i+1 && array[j] == array[j-1]){
                        continue;
                    }
                    if(_2sum(array, target - array[i]-array[j], j)){
                        return  true;
                    }
                }
            }
        }
        return false;
    }
}

 */