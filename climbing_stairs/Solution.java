public class Solution {
    public int climbStairs(int n) {
        if(n<4){
            return n;
        }
        
        int a = 2;
        int b = 3;
        int c = 5;
        
        for(int i=4; i<=n;i++) {
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}