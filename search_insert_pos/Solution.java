public class Solution {
    public int searchInsert(int[] A, int target) {
        if(target < A[0]) return 0;
		if(target > A[A.length-1]) return A.length;

		int ret = binarySearch(A, 0, A.length-1, target);
		return ret;
    }

	public int binarySearch(int[] A, int start, int end, int target) {
		// base case
		if(start==end) {
			if(A[start] >= target) {
				return start;
			} else {
				return start+1;
			}
		}

		int mid = (start + end)/2;
		if( A[mid] == target ) return mid;
		if( target < A[mid] ) {
			return binarySearch(A, start, mid, target);
		} else {
			return binarySearch(A, mid+1, end, target);
		}
	}
			
}