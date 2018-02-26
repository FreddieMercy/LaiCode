/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug05th2017._190ReverseBits;

/**
 *
 * @author junhaozhang
 */
/*
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        if(binaryString.length()>32)
        {
            binaryString = binaryString.substring(binaryString.length() - 32);
        }
        else{
            String s = "";
            for(int i = 0; i < 32-binaryString.length();++i){
                s+="0";
            }
            binaryString = s+binaryString;
        }
        binaryString = new StringBuilder(binaryString).reverse().toString();
        return Integer.parseUnsignedInt(binaryString);
    }
}
*/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        if(binaryString.length()>32)
        {
            binaryString = binaryString.substring(binaryString.length() - 32);
        }
        else{
            String s = "";
            for(int i = 0; i < 32-binaryString.length();++i){
                s+="0";
            }
            binaryString = s+binaryString;
        }
        binaryString = new StringBuilder(binaryString).reverse().toString();
        int ans = 0;
        while(binaryString.length()!=0){
            ans = ans<<1;
            if(binaryString.toCharArray()[0]=='1'){
                ans+=1;
            }
            binaryString = binaryString.substring(1);
            
        }
        
        return ans;
    }
}
/*
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0; 
        for(int i = 0; i < 32; ++i){
            res += (((n >> i) & 1) << (31-i));
        }
        return res;
    }
}
*/