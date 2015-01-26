class Solution {
public:
  vector<int> twoSum(vector<int> &numbers, int target) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    
    //this is the n^2 naive solution. 
    //Just to get the ball rolling.
    vector<int> ans(2,0); // is ans the address or the vector? need & to get the address?
    for(int i=0; i<numbers.size()-1; i++){
      if( numbers.at(i) < target ){
	for(int j=i+1; j<numbers.size();j++ ){
	  if (numbers.at(i) + numbers.at(j) == target){
	    ans[0] = i+1;
	    ans[1] = j+1;
	    return ans;
	  }
	}
      }
    }
  }
};
