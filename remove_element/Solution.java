public class Solution {
    public int removeElement(int[] A, int elem) {
		if(A==null || A.length == 0) return 0;
		int idx1 = 0;
		int num_re = 0;
		for(int i=0; i<A.length; i++) {
			if( A[i] != elem ) {
				A[idx1] = A[i];
				idx1++;
			} else {
				num_re++;
			}
		}
		return A.length-num_re;				
    }
}