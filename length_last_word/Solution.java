public class Solution {
    public static int lengthOfLastWord(String s) {
        if(s == null || s.length()==0 ) return 0;
        String s1 = s.trim();
        int result = s1.length();
        for(int i=s1.length()-1; i>=0; i-- ) {
            if(s1.charAt(i) == ' ') {
                result = s1.length() - i -1;
                break;
            }
        }
        
        return result;
    }
}