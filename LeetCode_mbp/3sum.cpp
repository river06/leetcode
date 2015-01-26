class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
      sort(num.begin(),num.end());
      vector<vector<int> > res;
      vector<int> t;
      int cki, ckj;
      int n = num.size();
      // If the amount of entries is less than 3 
      if(n<3)return res;
      cki = ckj  = num.at(0) - 1;
      // Must have a number which is less than 0, 
      // set the index of this number is i
      for(int i = 0; i<n-2 && num.at(i)<=0 ; ++i){
          // if the repeated numbers skip this one
          if(i>0 && num.at(i)==num.at(i-1))continue;

          int j = i + 1;
          int k = n - 1;
          while (j<k){
              int sum2 = num.at(i) + num.at(j);
	       if(num.at(k)+sum2<0) {
	              ++j;
	              while(j<k && num.at(j) == num.at(j-1)) ++j;
	          }
	          else if(num.at(k)+sum2>0){
	              --k;
	              while(j<k && num.at(k)==num.at(k+1)) --k;
	          } 
	          else {
	                 t.clear();
	                 t.push_back(num.at(i));
	                 t.push_back(num.at(j));
	                 t.push_back(num.at(k));
	                 cki = num.at(i);
	                 ckj = num.at(j);
	                 res.push_back(t);
                     --k;
                     while(j<k && num.at(k) == num.at(k+1)) --k;
                     ++j;
                     while(j<k && num.at(j) == num.at(j-1)) ++j;
		  }							      
	  }
      }
        return res;
    }
};
