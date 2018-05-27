package LaiOffer.Practise._Quiz_LargestSubArraySum;
import java.lang.*;
import java.util.*;
/*
public class Solution {
    public int[] largestSum(int[] array) {

        // Write your solution here
        int []dp = new int[array.length];
        int ans = array[0];
        int left = 0;
        int right = 0;
        int tmpLeft = 0;
        int tmpRight = 0;
        dp[0] = array[0];
        for(int i = 1; i < array.length;++i){
            if(dp[i-1] <0){
                dp[i] = array[i];

                tmpLeft = i;
                tmpRight = i;

            }
            else{
                dp[i] = dp[i-1]+array[i];
                if(dp[i]>dp[i-1]){
                    tmpRight = i;
                }
            }

            if(ans < dp[i]){
                ans = dp[i];
                left = tmpLeft;
                right = tmpRight;
            }
        }
        return new int[]{ans, left, right};
    }
}
*/


public class Solution {

    private void addParenthesesByLeftOrRight(String s, List<String> ans, int openParethesis, int openBracket, int openCurly, int closeParethesis, int closeBracket, int closeCurly, int numP, int numB, int numC, int index){
        if(openParethesis >= numP && closeParethesis >=numP && openBracket >=numB && closeBracket >= numB && openCurly >= numC && closeCurly >= numC){
            ans.add(s);
            return;
        }

        if(openParethesis<numP){
            addParenthesesByLeftOrRight(s+"(", ans, openParethesis+1, openBracket, openCurly, closeParethesis,closeBracket, closeCurly, numP,numB,numC, s.length());
        }
        if(closeParethesis<openParethesis && s.charAt(index)=='('){
            addParenthesesByLeftOrRight(s+")", ans, openParethesis, openBracket, openCurly, closeParethesis+1,closeBracket, closeCurly, numP,numB,numC,index-1);
        }

        if(openBracket<numB){
            addParenthesesByLeftOrRight(s+"[", ans, openParethesis, openBracket+1, openCurly, closeParethesis,closeBracket, closeCurly, numP,numB,numC,s.length());
        }
        if(closeBracket<openBracket&&s.charAt(index)=='['){
            addParenthesesByLeftOrRight(s+"]", ans, openParethesis, openBracket, openCurly, closeParethesis,closeBracket+1, closeCurly, numP,numB,numC,index-1);
        }

        if(openCurly<numC){
            addParenthesesByLeftOrRight(s+"{", ans, openParethesis, openBracket, openCurly+1, closeParethesis,closeBracket, closeCurly, numP,numB,numC,s.length());
        }
        if(closeCurly<openCurly &&s.charAt(index)=='{'){
            addParenthesesByLeftOrRight(s+"}", ans, openParethesis, openBracket, openCurly, closeParethesis,closeBracket, closeCurly+1, numP,numB,numC,index-1);
        }
    }
    public List<String> validParentheses(int a,int b, int c) {
        // Write your solution here
        List<String> ans = new ArrayList<>();
        addParenthesesByLeftOrRight("", ans, 0,0,0,0,0,0,a,b,c, 0);
        return ans;
    }
}