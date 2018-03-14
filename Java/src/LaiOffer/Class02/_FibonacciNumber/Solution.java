package LaiOffer.Class02._FibonacciNumber;
import java.util.*;

public class Solution {
    private static Map<Integer, Long> m = new HashMap<>();
    public long fibonacci(int K) {
        if(m.containsKey(K)){
            return m.get(K);
        }
        if(K<0){
            return 0;
        }
        if (K <= 1) {
            return K;
        }

        m.put(K, fibonacci(K - 1) + fibonacci(K - 2));
        return m.get(K);
    }
}
