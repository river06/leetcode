public class Solution {
    public int minCut(String s) {
		int nS = s.length();
		
        boolean[][] isPan = new boolean[nS][nS];
        int[] nCut = new int[nS];
		
		// obtain all panlindrome by DP
		// this solution utilizes two loops to solve the problem
		for(int j=0; j<nS; j++) {
			for(int i=j;i>=0; i--) {
				if( (s.charAt(i) == s.charAt(j)) && (j-i<2 || isPan[i+1][j-1]) ) {
					isPan[i][j] = true;
				} else {
					isPan[i][j] = false;
				}
			}
		}
		
		for(int j=0; j<nS; j++) {
			int minCut = nS;
			if( isPan[0][j] ) {
				nCut[j] = 0;
			} else {
				for( int i=0; i<j; i++) {
					if(isPan[i+1][j]) {
						minCut = Math.min(minCut,nCut[i]+1);
					}
				}
				nCut[j] = minCut;
			}
		}
		return nCut[nS-1];				
    }
}