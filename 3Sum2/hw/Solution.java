package hw;

import java.util.*;

public class Solution {
    public static int threeSumClosest(int[] num, int target) {
        
        int length = num.length;
        
        Arrays.sort( num); // sort array?
        
        int result = num[0] + num[1] + num[length-1];
        
        for(int i=0;i<length-2;i++) {
            int item1 = num[i];
            
            int j = i+1;
            int k = length - 1;
            
            while( j<k ) {
                int item2 = num[j];
                int item3 = num[k];
                
                int sum = item1 + item2 + item3;
                
                if(Math.abs(target-sum)<Math.abs(target-result)){
                    result = sum;
                }
                
                if(sum==target) {
                    return target;
                } else if(sum>target) {
                    // maybe can skip a few steps here?
                    k--;
                } else {
                    j++;
                }
            }
            
        }
        return result;
        
    }
}