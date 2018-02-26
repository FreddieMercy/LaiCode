/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug01st2017._127WordLadder;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    private class Level{
        private String word;
        private int length;
        public Level(String s, int l)
        {
            word = s;
            length =  l;
        }
        public Level(String s)
        {
            word = s;
            length = 1;
        }
        
        public String Word(){
            return word;
        }
        
        public int Length(){
            return length;
        }
    }
    private String _endWord;
    private Set<String> _wordList;
    private Queue<Level> _used = new LinkedList<Level>();
    private boolean getAllCombo(String input, int current){
        char tmp[] = input.toCharArray();
        int index = 0;
        while(index<input.length())
        {
            char origin = tmp[index];
            for(char c = 'a'; c <= 'z'; ++c){
                tmp[index] = c;
                String s = new String(tmp);
                if(_wordList.remove(s)){
                    if(s.equals(_endWord))
                    {
                        return true;
                    }
                    _used.add(new Level(s, current+1));
                }
            }
            tmp[index] = origin;
            index++;
        }
        
        return false;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || !wordList.contains(endWord)){
            return 0;
        }
        _endWord = endWord;
        _wordList = new HashSet<String>(wordList);
        _wordList.remove(beginWord);
        _used.add(new Level(beginWord));
        while(!_used.isEmpty()){
            Level current = _used.poll();
            if(this.getAllCombo(current.Word(), current.Length())){
                return current.Length()+1;
            }
        }
        
        return 0;
    }
}