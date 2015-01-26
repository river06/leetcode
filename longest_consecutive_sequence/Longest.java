public class Solution {
    public int longestConsecutive(int[] num) {
		// construct the unsorted map 
		// query time for unsorted map is O(1) 
        HashMap<int,int> unsortMap = new HashMap<int,int>();
		
		int[] visited = new int[num.length()];
		
		for(int i=0; i<num.length(); i++1) {
			unsortMap.put(i, num[i]);
			visited[i] = 0;
		}
		
		int longestLength = 0;
		for(int i=0; i<num.length();i++) {
			if(visited[i]==0){
				visited[i] = 1;
				
				// left sequence
				int tmpKey = num[i] - 1;
				int leftLength = 0;
				while( unsortMap.containsKey( tmpKey ) ){
					leftLength ++;
					visited[unsortMap.get(tmpKey)] = 1;
					tmpKey --;
				}
				
				// right sequence
				tmpKey = num[i] + 1;
				int rightLength = 0;
				while( unsortMap.containsKey( tmpKey ) ){
					rightLength ++;
					visited[unsortMap.get(tmpKey)] = 1;
					tmpKey ++;
				}
				
				if( leftLength + rightLength + 1 > longestLength) {
					longestLength = leftLength + rightLength + 1;
				}
			}
		}
		return longestLength;
    }
}