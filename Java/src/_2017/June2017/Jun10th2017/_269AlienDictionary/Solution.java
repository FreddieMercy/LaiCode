/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.June2017.Jun10th2017._269AlienDictionary;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */
//Dont wanna do it because description was unclear
//https://isabella-z.gitbooks.io/al-m/content/113-leetcode/alien-dictionary.html
public class Solution {
    private final int N = 26;
    public String alienOrder(String[] words) {
        //build graph and save the order in adj
        boolean[][] adj = new boolean[N][N];
        //visited[i] = -1. Not even exist.
        //visited[i] = 0. Exist. Non-visited.
        //visited[i] = 1. Visiting.
        //visited[i] = 2. Visited.
        int[] visited = new int[N];
        buildGraph(words, adj, visited);

        //find cycle and generate result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
        {
            if (visited[i] == 0) // unvisited
            {                 
                if (!dfs(adj, visited, sb, i))
                {
                    return "";
                }
            }
        }
        return sb.reverse().toString();
    }
    
    void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);                 // -1 = not even existed
        for (int i = 0; i < words.length; i++) 
        {
            for (char c : words[i].toCharArray())
            {
                visited[c - 'a'] = 0;
            }
            if (i > 0) 
            {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) 
                {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) 
                    {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
    
    boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;                            // 1 = visiting
        for (int j = 0; j < N; j++) 
        {
            if (adj[i][j]) // connected
            {                        
                if (visited[j] == 1)// 1 => 1, cycle 
                {
                    return false;   
                }
                if (visited[j] == 0)  // 0 = unvisited
                {             
                    if (!dfs(adj, visited, sb, j)) 
                    {
                        return false;
                    }
                }
            }
        }
        visited[i] = 2;                           // 2 = visited
        sb.append((char) (i + 'a'));
        return true;
    }
}