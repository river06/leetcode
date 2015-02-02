public class Solution {
    public void sortColors(int[] A) {
        int idx_red = 0;
		int idx_blue = A.length-1;
		int i=0;
		while(i<=idx_blue) {
			if(A[i] == 0) {
				int tmp = A[idx_red];
				A[idx_red] = A[i];
				A[i] = tmp;
				i++;
				idx_red++;
				continue;
			} else if(A[i] == 2) {
				int tmp = A[idx_blue];
				A[idx_blue] = A[i];
				A[i]=tmp;
				idx_blue--;
				continue;
			} else {
				i++;
			}
		}
    }
}