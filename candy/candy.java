public class Solution {
    public int candy(int[] ratings) {
        int nChild = ratings.length;
		int nCandy = 0;
		int[] candy = new int[nChild];
		
		candy[0] = 1;
		
		for(int i=1; i<nChild; i++) {
			if(ratings[i] > ratings[i-1]) {
				candy[i]= candy[i-1]+1;
			}else{
				candy[i]= 1;
			}
		}
		
		for(int i=nChild-1; i>0; i--) {
			if( ratings[i] < ratings[i-1] && candy[i-1] <= candy[i] ) {
				candy[i-1] = candy[i]+1;
			}
		}
		
		for(int i=0; i<nChild; i++) {
			nCandy += candy[i];
		}
		
		return nCandy;
    }
}