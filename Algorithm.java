
package algorithm; //ALGORITHMS

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

//CEREN BULBUL 
//20160808052


public class Algorithm{
    
    static LinkedList<int[][]> linkedList = new LinkedList<>();
    static long initialTime;
    static long lastTime;
    static double time;
    static int toplam=0;
    
    static Map<String, Integer> lookup = new HashMap<>();
    
    public static void main(String[] args) {
        
        
        
        int set[] = {3, 34, 4, 12, 5, 2}; 
        int set2[] = {5, 10, 15, 20, 20, 40, 4, 50, 2, 7, 68, 43, 28, 56, 24, 98, 56, 90, 12, 34, 66 , 36 ,
                        76, 123, 456, 76, 98, 80, 16};
        
        int set3[] = {76, 123, 456, 76, 98, 80, 16, 34, 43 , 1, 10, 13, 45, 23, 15, 56, 34, 26, 87, 98, 6, 56, 34, 90, 87, 
                        56, 37, 76, 98, 100, 168};
        
        int[] set4 = new int[3000];
        
        for(int i=0; i<set4.length-1; i++){
            
            Random rand = new Random();
            
            set4[i] = rand.nextInt(101);
            toplam += set4[i];
            
            
        }
        
        int sum = 10000;
        
        System.out.println("\nSum: " +sum + "\n");
        
        System.out.println("Array size " + set.length + " : ");
        initialTime= System.currentTimeMillis();
        int result = Recursion(set, set.length, sum);
        lastTime = System.currentTimeMillis();
        time = (double)(lastTime - initialTime)/1000;
        System.out.println("Recursion: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        initialTime= System.currentTimeMillis();
        result = Dynamic(set, set.length,sum);
        lastTime = System.currentTimeMillis();
        time = (double)(lastTime - initialTime)/1000;
        System.out.println("Dynamic: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        
        initialTime= System.currentTimeMillis();
        result = Memoized(set, set.length-1, sum , lookup);
        lastTime = System.currentTimeMillis();
        time = (double)(lastTime - initialTime)/1000;
        System.out.println("Memorized: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        
        
        System.out.println("\n--------------------------------\n");
        System.out.println("\nSum: " +sum + "\n");
        System.out.println("Array size " + set2.length + " : ");
        initialTime= System.currentTimeMillis();
        result = Recursion(set2, set2.length, sum);
        lastTime = System.currentTimeMillis();
         time = (double)(lastTime - initialTime)/1000;
        System.out.println("Recursion: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        
        initialTime= System.currentTimeMillis();
        result = Dynamic(set2, set2.length,sum);
        lastTime = System.currentTimeMillis();
        time = (double)(lastTime - initialTime)/1000;
        System.out.println("Dynamic: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        
        initialTime= System.currentTimeMillis();
        result = Memoized(set2, set2.length-1, sum , lookup);
        lastTime = System.currentTimeMillis();
        time = (double)(lastTime - initialTime)/1000;
        System.out.println("Memorized: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        
        System.out.println("\n--------------------------------\n");
        System.out.println("\nSum: " +sum + "\n");
        System.out.println("Array size " + set3.length + " : ");
        initialTime= System.currentTimeMillis();
        result = Recursion(set3, set3.length, sum);
        lastTime = System.currentTimeMillis();
        time = (double)(lastTime - initialTime)/1000;
        System.out.println("Recursion: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        
        initialTime= System.currentTimeMillis();
        result = Dynamic(set3, set3.length,sum);
        lastTime = System.currentTimeMillis();
        time = (double)(lastTime - initialTime)/1000;
        System.out.println("Dynamic: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        
        initialTime= System.currentTimeMillis();
        result = Memoized(set3, set3.length-1, sum , lookup);
        lastTime = System.currentTimeMillis();
        time = (double)(lastTime - initialTime)/1000;
        System.out.println("Memorized: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        
        System.out.println("\n--------------------------------\n");
        System.out.println("\nSum: " +sum + "\n");
        System.out.println("Array size " + set4.length + " : ");
        initialTime= System.currentTimeMillis();
        result = Dynamic(set4, set4.length,sum);
        lastTime = System.currentTimeMillis();
        time = (double)(lastTime - initialTime)/1000;
        System.out.println("Dynamic: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        
        initialTime= System.currentTimeMillis();
        result = Memoized(set4, set4.length-1, sum , lookup);
        lastTime = System.currentTimeMillis();
        time = (double)(lastTime - initialTime)/1000;
        System.out.println("Memorized: \t" + "Value = " + result + "\t" + "Time = " + time );
        
        
    }
    
    private static int Recursion(int[] Array , int n , int sum) {
        
        if (sum == 0 || n ==0) {
            return 0;
        }
        
        else if(Array[n-1] > sum) {
            return Recursion(Array, n-1, sum);
            
        }
        
        else {  
        int max = Math.max(Array[n-1] + Recursion(Array , n-1 , sum - Array[n-1]) , Recursion(Array, n-1, sum));
        return max;
        }
        
         
    }

    private static int Dynamic(int[] Array , int size , int sum) {
        
        int subset[][] = new int[sum+1][size+1]; 
        
        for (int i = 1; i <= sum; i++) { 
            
            for (int b = 1; b <= size; b++) { 
                
                if (Array[b-1] <= i ) 
                    subset[i][b] =  Math.max(Array[b-1] + subset[i-Array[b-1]][b-1] , subset[i][b-1] );
                else
                subset[i][b] = subset[i][b-1]; 
            } 
        } 
        return subset[sum][size]; 
        
    }

    private static int Memoized(int[] Array , int size , int sum , Map<String, Integer> map) {
        
        if(sum ==0) {
            return sum;
        }
        if (size < 0 || sum < 0) {
            return 0;
        }
        String key = size + "|" + sum;
        if(map.containsKey(key))
            return map.get(key);

		if (!map.containsKey(key)){
                        if(Array[size] > sum) {
                            int exclude = Memoized(Array, size - 1, sum, map);
                            map.put(key, exclude);
                            return exclude;
                        }
                        else {
                            int include = Math.max(Array[size] + Memoized(Array, size - 1, sum - Array[size], map), 
                                    Memoized(Array, size - 1, sum - Array[size], map)); 
                            map.put(key, include);
                            return include;
                        }
		}
		return map.get(key);
        
    }
    
    
}