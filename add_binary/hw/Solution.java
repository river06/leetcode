public class Solution {
    public String addBinary(String a, String b) {
        
        
        if(a==null || a.length() ==0 ) return b;
        if(b==null || b.length() == 0) return a;
        
        StringBuilder result = new StringBuilder();
        
        int pB = b.length()-1;
        int pA = a.length()-1;
        
        int carry = 0;
        
        while(pB>=0 || pA>=0 || carry>0) {
            int numA = 0;
            int numB = 0;
            
            if(pA>=0) {
                if(a.charAt(pA)=='0'){
                    numA = 0;
                }else{
                    numA = 1;
                }
                pA--;
            }
            
            if(pB>=0) {
                if(b.charAt(pB)=='0'){
                    numB = 0;
                }else{
                    numB = 1;
                }
                pB--;
            }
                       
            int current = (numA + numB + carry)%2;
            
            carry = (numA + numB + carry)/2;
            
            result.insert(0,current);
        }
        return result.toString();
    }
}