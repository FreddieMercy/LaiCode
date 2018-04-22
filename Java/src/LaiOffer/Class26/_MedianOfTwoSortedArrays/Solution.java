package LaiOffer.Class26._MedianOfTwoSortedArrays;

public class Solution {
    public double median(int[] a, int[] b) {
        // Write your solution here
        int[] A = (a == null) ? new int[0] : a;
        int[] B = (b == null) ? new int[0] : b;
        if((A.length+B.length)%2==0){
            return (double)(kth(A, B, (A.length+B.length)/2+1) +kth(A, B, (A.length+B.length)/2))/2;
        }
        return kth(A, B, (A.length+B.length)/2+1);
    }
    private int kth(int[] a, int[] b, int k) {
        // Write your solution here
        int[] A = (a == null) ? new int[0] : a;
        int[] B = (b == null) ? new int[0] : b;
        if (A.length + B.length < k) {
            return Integer.MIN_VALUE;
        }
        return kth(A, B, k, 0, 0);
    }

    private int kth(int[] a, int[] b, int k, int Astart, int Bstart) {

        if (Astart >= a.length) {
            return b[Bstart - (Astart - a.length + 1)+k];
        }

        if (Bstart >= b.length) {
            return a[Astart - (Bstart - b.length + 1)+k];
        }
        if (k == 1) {
            return (a[Astart] < b[Bstart]) ? a[Astart] : b[Bstart];
        }
        int index = k/2-1;
        int B = (Bstart + index < b.length) ? b[Bstart + index] : Integer.MAX_VALUE;
        int A = (Astart + index < a.length) ? a[Astart + index] : Integer.MAX_VALUE;
        index++;
        if (A > B) {
            return kth(a, b, k -index, Astart, Bstart + index);
        } else {
            return kth(a, b, k - index, Astart + index, Bstart);
        }
    }
}
