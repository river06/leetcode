

public class Solution {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if( s1.length() + s2.length() != s3.length() ) return false;
        if( s1.length() == 0) {
        	if(s2.equals(s3)) {
        		return true;
        	} else {
        		return false;
        	}
        }
        if( s2.length() == 0 ) {
        	if( s1.equals(s3) ) {
        		return true;
        	} else {
        		return false;
        	}
        }
        int[][] table = new int[s1.length()+1][s2.length()+1]; 
        
        table[0][0] = 1;
        
        for( int j = 0; j<s2.length(); j++ ){
        	if( s2.charAt(j) == s3.charAt(j) ) {
        		table[0][j+1] = table[0][j];
        	} else {
        		table[0][j+1] = 0;
        	}
			//System.out.println(table[0][j+1]);
        }
        
        for( int i = 0; i<s1.length(); i++ ){
        	if( s1.charAt(i) == s3.charAt(i) ) {
        		table[i+1][0] = table[i][0];
        	} else {
        		table[i+1][0] = 0;
        	}
			//System.out.println(table[i+1][0]);
        }

		
        for( int i=1; i<=s1.length(); i++ ) {
        	for( int j=1; j<=s2.length(); j++){
        		if(s3.charAt(i+j-1)!=s1.charAt(i-1) && s3.charAt(i+j-1)!=s2.charAt(j-1)) {
					table[i][j] = 0;
				} else if (s3.charAt(i+j-1)==s1.charAt(i-1) && s3.charAt(i+j-1)!=s2.charAt(j-1)) {
					table[i][j] = table[i-1][j];
				} else if (s3.charAt(i+j-1)!=s1.charAt(i-1) && s3.charAt(i+j-1)==s2.charAt(j-1)) {
					table[i][j] = table[i][j-1];
				} else {
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
				//System.out.println(table[i][j]);
        	}
        }

		if(table[s1.length()][s2.length()] == 1) {
			return true;
		} else {
			return false;
		}
    }
}
