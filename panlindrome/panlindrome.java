public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        
		int nS = s.length();
		// obtain all panlindrome by DP
		boolean[][] isPan = new boolean[nS][nS];
		for(int j=0; j<nS; j++) {
			for(int i=j; i>=0; i--) {
				if( (s.charAt(i) == s.charAt(j)) && (j-i<2 || isPan[i+1][j-1]) ) {
					isPan[i][j] = true;
				} else {
					isPan[i][j] = false;
				}
			}
		}
		
		ArrayList<ArrayList<String>> head = new ArrayList<ArrayList<String>>();
		ArrayList<String> part = new ArrayList<String>();
		
		recurFindPan(s, 0, head, part, isPan);
		
		return head;
    }
	
	private void recurFindPan(String s, int index, ArrayList<ArrayList<String>> head, ArrayList<String> part, boolean[][] isPan) {
		if( index == s.length()) {
			ArrayList<String> temp = new ArrayList<String>(part);
			head.add(temp);
			return;
		} else { 
			for(int i=index; i<s.length(); i++) {
				if(isPan[index][i]) {
				
					String sub_string = s.substring(index,i+1);
					part.add(sub_string);
					recurFindPan(s, i+1, head, part, isPan);
					part.remove(part.size()-1);
				}
			}
		}
	}
}