/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.June2017.Jun10th2017._126WordLadderII;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
public class Solution {
    private static final char[] charSet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new LinkedList<List<String>>();
        Set<String> dict = new HashSet(wordList);
        if(!dict.contains(endWord)) return res;
        
        Set<String> a = new HashSet();
        a.add(beginWord);
        
        Set<String> b = new HashSet();
        b.add(endWord);
        
        Map<String, Set<String>> map = new HashMap();
        buildMap(a,b,dict,map, true);
        
        generatePath(beginWord, endWord, new ArrayList<String>(Arrays.asList(beginWord)), res, map);
        
        return res;
    }
    
    private boolean buildMap(Set<String> a, Set<String> b, Set<String> dict, Map<String, Set<String>> map, boolean flip){
        if(a.size() == 0) return false;
        if(a.size() > b.size()) return buildMap(b, a, dict, map, !flip);
        boolean done = false;
        dict.removeAll(a);
        dict.removeAll(b);
        Set<String> nextLayer = new HashSet();
        for(String source : a){
            char[] cur = source.toCharArray();
            for(int i = 0 ; i < cur.length ; i ++){
                char old = cur[i];
                for(char rep : charSet){
                    if(rep == old) continue;
                    cur[i] = rep;
                    String child = new String(cur);
                    if(b.contains(child)){
                        done = true;
                        String key = flip ? source : child;
                        String val = flip ? child : source;
                        Set<String> children = map.containsKey(key) ? map.get(key) : new HashSet();
                        children.add(val);
                        map.put(key, children);
                        nextLayer.add(child);
                    }
                    if(!done && dict.contains(child)){
                        String key = flip ? source : child;
                        String val = flip ? child : source;
                        Set<String> children = map.containsKey(key) ? map.get(key) : new HashSet();
                        children.add(val);
                        map.put(key, children);
                        nextLayer.add(child);
                    }
                } 
                cur[i] = old;
            }
        }
        return done || buildMap(nextLayer, b, dict, map, flip);
    }
    
    private void generatePath(String start, String end, List<String> path, List<List<String>> res, Map<String, Set<String>> map){
        if(start.equals(end)){
            res.add(new ArrayList(path));
            return;
        }
        if(map.containsKey(start)){
            for(String next : map.get(start)){
                path.add(next);
                generatePath(next, end, path, res, map);
                path.remove(path.size() - 1);
            }
        }
    }
}
/*
public class Solution {
    private List<List<String>> ans = new ArrayList<List<String>>();
    private Queue<Stack<String>> m = new LinkedList<Stack<String>>();
    private Queue<List<String>> n = new LinkedList<List<String>>();
    private String end = "";
    
    private boolean findOneDifFrom() {
		boolean push = false;
		Stack<String> q = (Stack<String>)m.peek().clone();
		m.poll();
		List<String> v = new ArrayList<String>(n.peek());
		if (m.size() == 0 || q.size() != m.peek().size()) {
			n.poll();
		}
		if (ans.size() == 0 || q.size() + 1 <= ans.get(0).size()) {
			for (int i = 0; i < q.peek().length(); ++i) {
				for (char c = 'a'; c <= 'z'; ++c) {
					if (c != q.peek().toCharArray()[i]) {
						String tmp = new StringBuilder(q.peek().substring(0, i)+c+q.peek().substring(i+1)).toString();
						if (tmp.equals(end)) {
							List<String> j = Pop((Stack<String>)q.clone());
							if (ans.size()==0 || j.size() <= ans.get(ans.size() - 1).size()) {
								ans.add(new ArrayList<String>(j));
								if (push) {
									n.add(new ArrayList<String>(v));
								}
								return true;
							}
							else {
								return false;
							}
						}
						else if (v.contains(tmp)) {
							Stack<String> q1 = (Stack<String>)q.clone();
							q1.push(new StringBuilder(tmp).toString());
							m.add((Stack<String>)q1.clone());
                                                        v.remove(tmp);
							push = true;
						}
					}
				}
			}
			if (push) {
				n.add(new ArrayList<String>(v));
			}
			return true;
		}
		else {
			return false;
		}
	}
    
    private List<String> Pop(Stack<String> q) {
		List<String> sth = new ArrayList<String>();
                sth.add(new StringBuilder(end).toString());
		while (q.size()>0)
		{
			String tmp = q.peek();
			q.pop();
			sth.add(new StringBuilder(tmp).toString());
		}
		return sth;
	}
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> words) {
		end = beginWord;
		Stack<String> s = new Stack<String>();
		s.add(new StringBuilder(endWord).toString());
		m.add((Stack<String>)s.clone());
		words.remove(beginWord);
		if (!words.remove(endWord)) {
			return ans;
		}
		n.add(new ArrayList<String>(words));
		while (m.size()>0&& findOneDifFrom()) {
		}
		return ans;
    }
}
*/