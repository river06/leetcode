public class Solution {
    public static int findPeakElement(int[] num) {
        int result = recurFind(0, num.length-1, num);
        return result;
    }
    
    
    private static int recurFind(int l, int r, int[] num) {
        // special base case
        
        if(l==r) {
            return l;
        }
        
        if(l==r-1) {
            if(num[l]<=num[r]) {
                return r;
            } else {
                return l;
            }
        }
        int result;
        // other cases
        int m = (l+r)/2;
        if( num[m-1]<= num[m] && num[m]>= num[m+1]) {
            return m;
        } else if (num[m-1] > num[m]) {
            result = recurFind(l, m-1, num);
        } else {
            result = recurFind(l+1,r,num);
        }
        return result;
    }
}