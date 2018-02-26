package _2017.June2017.Jun23rd2017._359LoggerRateLimiter;
import java.lang.*;
import java.util.*;
public class Logger {
    HashMap<String,Integer> map;

    public Logger() {
        map=new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        if(!map.containsKey(message)||timestamp-map.get(message)>=10){
            map.put(message,timestamp);
            return true;
        }
        return false;
    }
}