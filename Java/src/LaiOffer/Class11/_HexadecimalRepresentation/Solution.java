package LaiOffer.Class11._HexadecimalRepresentation;

public class Solution {
    public String hex(int number) {
        // Write your solution here
        if(number == 0){
            return "0x0";
        }

        StringBuilder ans = new StringBuilder("");
        String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int shft = 0;
        int getter = 2*2*2*2-1;

        while (shft<32){

            ans.append(hex[(number>>>shft)&(getter)]);
            shft+=4;
        }

        ans.reverse();
        while (ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }

        return "0x"+ans.toString();
    }
}
