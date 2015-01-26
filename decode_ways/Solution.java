public class Solution {
    public static int numDecodings(String s) {
        int result = 0;
        if(s==null || s.length()==0) return result;
        if(isOneDigitValid(s.charAt(0))) {
            result = 1;
        }
        
                
        if(s.length() ==1) return result;
            
        int preResult0 = 1;
        int preResult1 = result;
        int curResult = 0;
        for(int j=1;j<s.length();j++) {
            curResult = 0;
            if( isOneDigitValid(s.charAt(j))) {
                curResult += preResult1;
            }
            if( isTwoDigitValid(s.charAt(j-1), s.charAt(j))) {
                curResult += preResult0;
            }
            
            preResult0 = preResult1;
            preResult1 = curResult;
        }
        return curResult;
        
    }
    
    private static boolean isOneDigitValid(char c){
        if('0'<c && c<='9') {
            return true;
        } else {
            return false;
        }
    }
    
    private static boolean isTwoDigitValid(char c1, char c2) {
        int num = 10*(c1-'0') + c2-'0';
        if( 10<= num && num <=26) {
            return true;
        } else {
            return false;
        }
    }
}