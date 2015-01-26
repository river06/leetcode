public class Solution {
    public static int firstMissingPositive(int[] A) {
		int result =0;

		if(A==null || A.length == 0) return 1;

		for(int i=0;i<A.length;i++){
			while(A[i] != i+1) {
				if(A[i]>0 && A[i]<=A.length) {
					if(A[A[i]-1] != A[i]) {
						// switch
						int tmp = A[A[i]-1];
						A[A[i]-1] = A[i];
						A[i] = tmp;
					} else {
						break;
					}
				} else {
					break;
				}
			}
		}
		result = A.length+1;
		for(int i=0;i<A.length;i++){
			if(A[i] != i+1) {
				result = i+1;
				break;
			}
		}

		
		return result;
    }
}