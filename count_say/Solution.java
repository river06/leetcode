import java.util.*;

public class Solution {
    public static String countAndSay(int n) {
        
        if(n<=0) return "";
        String result ="1";
        if(n==1) return result;

        for(int i=2;i<=n;i++) {
            StringBuilder tmpString = new StringBuilder();
            char tmpChar=result.charAt(0);
            int tmpNum=0;
            for(int j=0;j<result.length();j++){
                if(j>0 && result.charAt(j)!=tmpChar){
                    tmpString.append(tmpNum);
                    tmpString.append(tmpChar);
                    tmpNum=1;
                    tmpChar = result.charAt(j);
                } else{
                    tmpNum++;
                }
            }
            // append the last char and num
            tmpString.append(tmpNum);
            tmpString.append(tmpChar);
            
            result = tmpString.toString();
        }
        
        return result;
        
    }
}