public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int nS = s.length();
		
		boolean[] possible = new boolean[nS];
		
		for(int i=0; i<nS; i++) {
			possible[i] = false;
		}
		
		possible[0] = dict.contains( s.substring(0,1));
		
		for(int i =1; i<nS; i++) {
			
			possible[i] = dict.contains( s.substring(0,i+1));
			
			if( possible[i] == false ) {
				for(int j=0; j<i; j++) {
					possible[i] = ( possible[j] & dict.contains( s.substring(j+1,i+1) ) );
				
					if(possible[i]) break;
				}
			}
		}
		
		return possible[nS-1];
		
    }
}