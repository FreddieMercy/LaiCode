package LaiOffer.Class25._LargestProductOfLength;
import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int largestProduct(String[] dict) {
        // Write your solution here
        int max = 0;
        Map<String, Integer> ans = new HashMap<>();
        for(String s: dict){
            int tmp = 0;
            for(char c:s.toCharArray()){
                tmp|=1<<(c-'a');
            }
            ans.put(s, tmp);
        }

        for (int i = 0; i < dict.length; ++i){
            for(int j = i+1; j<dict.length;++j){
                int tmp = dict[i].length()*dict[j].length();
                if(max>=tmp){
                    continue;
                }
                if((ans.get(dict[i])& ans.get(dict[j]))==0){
                    max=tmp;
                }
            }
        }

        return max;
    }
}
