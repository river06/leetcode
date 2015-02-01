public class Solution {
    public int[] searchRange(int[] A, int target) {
		int[] result = {-1,-1};
        if(A==null || A.length==0) return result;
		if(A.length == 1) {
			if(A[0] == target) result = new int[] {0,0};
			return result;
		}
		if(A[0] > target || A[A.length-1]<target) return result;
		// binary search
		int idx_1 = binarySearch1(A, 0, A.length-1, target);
		if( idx_1 == -1) return result;
		int idx_2 = binarySearch2(A, 0, A.length-1, target);
		result = new int[] {idx_1, idx_2};
		return result;
    }

	public int binarySearch1(int[] A, int idx_start, int idx_end, int target) {
		if(idx_end-idx_start==1) {
			if(A[idx_start] == target) {
				return idx_start;
			} else if (A[idx_end] == target) {
				return idx_end;
			} else {
				return -1;
			}
		}

		int idx_mid = (idx_start + idx_end)/2;
		if( A[idx_mid] >= target) {
			return binarySearch1(A, idx_start, idx_mid, target);
		} else {
			return binarySearch1(A, idx_mid, idx_end, target);
		}
	}

	public int binarySearch2(int[] A, int idx_start, int idx_end, int target) {
		if(idx_end-idx_start==1) {
			if(A[idx_end] == target) {
				return idx_end;
			} else if (A[idx_start] == target) {
				return idx_start;
			} else {
				return -1;
			}
		}

		int idx_mid = (idx_start + idx_end)/2;
		if( A[idx_mid] > target) {
			return binarySearch2(A, idx_start, idx_mid, target);
		} else {
			return binarySearch2(A, idx_mid, idx_end, target);
		}
	}
}