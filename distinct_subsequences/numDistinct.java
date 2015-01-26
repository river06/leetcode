public class Solution {
    public int numDistinct(String S, String T) {
        int[][] dp = new int[T.length() + 1][S.length()+1];
		for(int j=0; j<=T.length(); j++){ dp[j][0]=0; }
		for(int i=1; i<=S.length(); i++){ dp[0][i]=1; }
		
		for(int i=1; i<=T.length(); i++){
			for(int j=1; j<=S.length(); j++) {
				// S en-longed, the result is at least dp[i][j-1]
				dp[i][j] = dp[i][j-1];
				// if T[i]==S[j], then the result should be added by dp[i-1][j-1]
				if(S.charAt(i-1) == T.charAt(j-1)) {
					dp[i][j] += dp[i-1][j-1];
				}
			}
		}
		return dp[T.length()+1][S.length()+1];
    }
}