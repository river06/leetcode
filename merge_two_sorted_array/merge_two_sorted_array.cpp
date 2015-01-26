class Solution {
public:
  void merge(int A[], int m, int B[], int n) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    
    // the computational complexity should be O(m+n) no matter how naive the algorithm is.
    int i = m-1;
    int j = n-1;
    while(i>=0 && j>=0){
      if(A[i] <= B[j]){
	A[i+j+1] = B[j];
	j--;
      }else{
	A[i+j+1] = A[i];
	i--;
      }
    }
    while( j>=0 ){
      A[j] = B[j];
      j--;
    }
};
