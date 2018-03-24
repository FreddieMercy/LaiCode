package LaiOffer.Class11._AllUniqueCharactersII;

public class Solution {
    public boolean allUnique(String word) {
        // Write your solution here
        int [] ascii = new int[8];
        for (char c : word.toCharArray()){
            if(((ascii[c/32]>>>(c%32))&1)==1){
                return false;
            }
            ascii[c/32] += (1 << c%32);
        }

        return true;
    }
}
