/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug02nd2017._149MaxPointsOnALine;
import java.lang.*;
import java.util.*;
/**
 *
 * @author junhaozhang
 */

// Definition for a point.
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution {
    private Map<Point, Map<String,Integer>> m = new HashMap<Point, Map<String,Integer>>(); 
    private String SlopeXY(Point x, Point y){
        if(x.x == y.x || x.y == y.y){
            return "0";
        }
        
        int tmpy = y.y-x.y;
        int tmpx = y.x-x.x;
        int gcd = this.generateGCD(tmpx, tmpy);
        if (gcd!=0){
            tmpx/=gcd;
            tmpy/=gcd;
        }
        return (""+tmpy)+"/"+(""+tmpx);// (double)(tmpy)/(double)(tmpx);
    }
    private int generateGCD(int a,int b){
    
        if (b==0) return a;
        else return generateGCD(b,a%b);
        	
    }
    private int findAll(Point start, Point[] rest){
        int max = 1;
        int zero = 0;
        for(Point x : rest){
            
            if(start.x == x.x && start.y == x.y){
                zero++;
            }
            else{
                String slope = this.SlopeXY(start, x);
                if(slope == "0"){
                    if(x.x == start.x){
                        slope = "POSITIVE_INFINITY";
                    }
                    else{
                        slope = "NEGATIVE_INFINITY";
                    }
                }
                if(!m.containsKey(start)){
                    m.put(start, new HashMap<String,Integer>());
                }
                if(!m.get(start).containsKey(slope)){
                    m.get(start).put(slope, 1);
                }
                m.get(start).put(slope, m.get(start).get(slope)+1);
                max = Math.max(max, m.get(start).get(slope));
            }
        }
        
        if(zero==0){
            return max;
        }
        
        if(m.containsKey(start)){
            for(String slopes : m.get(start).keySet()){
                m.get(start).put(slopes, m.get(start).get(slopes)+zero);
            }
        }
        return max+zero;
    }
    public int maxPoints(Point[] points) {
        int max = 0;
        for(int i = 0; i < points.length;++i){
            max = Math.max(max, this.findAll(points[i], Arrays.copyOfRange(points, i+1, points.length)));
        }
        return max;
    }
}