public class Solution {
    public static int strStr(String haystack, String needle) {
        int result = -1;
        if(haystack==null || (haystack.length()==0 && needle.length()!=0)) return result;
        
        if(needle.length()==0) return 0;
        
        int h_length = haystack.length();
        int n_length = needle.length();
        for( int i =0; i<= h_length - n_length; i++) {
            boolean flag = true;
            for( int j=0; j< n_length; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                result = i;
                break;
            }
        }
        return result;
    }
}