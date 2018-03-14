import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static HashMap<String,Long> cache=new HashMap<String,Long>();
    public static Long makeChange(int[] coins, Integer money, Integer size) {
        Long result= new Long(0);
        String temp= Integer.toString(money)+'-'+Integer.toString(size);
        if(size<=0){
           return new Long(0); 
        }
        else{
            if(money==0.0){
                return  new Long(1);
            }
            else if(money <0.0){
                return new Long(0);
            }
            else if(cache.containsKey(temp)){
                return cache.get(temp);
             }
            else{
                result=((money==coins[size-1])?1:makeChange(coins,(money - coins[size-1]),size))+makeChange(coins,money,size-1);
                cache.put(temp,result);  
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        Arrays.sort(coins);
        System.out.println(makeChange(coins, n,  m));
    }
}
