class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
      int mergPos = m+n-1;
      int i = m-1;
      int j = n-1;
      while(i>=0 && j>=0){
	if( A[i]>B[j] ){
	  A[mergPos--] = A[i--];
	}else{
          A[mergPos--] = B[j--];
	}
      }

      if( j>=0 ){
        B[mergPos--] = B[j--];
       }
        
    }
};
