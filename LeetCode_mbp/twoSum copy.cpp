class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
      vector<int> res
	for(int i = 0; i < numbers.size()-1; ++i){
	  for(int j = i+1; j < numbers.size(); ++j){
	    if(numbers.at(i) + numbers.at(j) == target){
                res.push_back(i+1);
		res.push_back(j+1);
                return = res;
	    }
	  } 
	}
    }
