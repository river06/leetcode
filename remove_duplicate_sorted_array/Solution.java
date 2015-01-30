public class Solution {
    public int removeDuplicates(int[] A) {
		if(A.length == 0) return 0;
		if(A.length == 1) return 1;
		
        int p1 = 0;
		int p2 = 0;
		int num_du = 0;

		while(p2<A.length-1) {
			
			if(A[p2] == A[p2+1]) {
				num_du ++;
				p2++;
			} else {
				A[p1] = A[p2];
				p1++;
				p2++;
			}
		}

		// last element

		A[p1] = A[A.length-1];


		return A.length - num_du;
    }
}