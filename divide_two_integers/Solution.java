public class Solution {
    public static int divide(int dividend, int divisor) {
        
        
        if(divisor ==0) return Integer.MAX_VALUE;
        
        int result = 0;
        
        // when dividend or divisor exceeds the bounds of integers
        if( dividend == Integer.MIN_VALUE) {
            if(divisor ==-1) {
                return Integer.MAX_VALUE;
            } else if( divisor == 1) {
                return Integer.MIN_VALUE;
            }
            
            if(divisor<0) {
                dividend -= divisor;
            } else {
                dividend += divisor;
            }
            result ++;
        }
        if( divisor == Integer.MIN_VALUE) {
            return result;
        }
        
        int dividend_abs = Math.abs( dividend);
        int divisor_abs = Math.abs( divisor);
        
        while( dividend_abs >= divisor_abs ){
            int num_move = 0;
            while((dividend_abs>>num_move) >= divisor_abs ) {
                num_move ++;
            }
            result += (1 << (num_move-1));
            dividend_abs -= ( divisor_abs<<(num_move-1) );
        }
        
        if((dividend>=0 && divisor>0) || (dividend<0 && divisor<0)){
            return result;
        } else {
            return -result;
        }
    }
}