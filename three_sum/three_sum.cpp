class Solution {
public:
  vector<vector<int> > threeSum(vector<int> &num) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    

    vector<vector<int>> buff;
    vector<int> temp;
   
    if(num.size()<3)
      return buff;

    // first sort the vector
    sort(num.begin(),num.end());
   
    for(int i=0; i< num.size()-2; i++){
      if(i>0 && num[i] == num[i-1])
	continue; // Skip same a
      if(num[i]>0)
	continue; // if a > 0, can also skip?

      class Solution {
      public:
	vector<vector<int> > threeSum(vector<int> &num) {
	  // IMPORTANT: Please reset any member data you declared, as                                  
	  // the same Solution instance will be reused for each test case.                             


	  vector<vector<int>> buff;
	  vector<int>temp;

	  if(num.size()<3)
	    return buff;

	  // first sort the vector                                                                     
	  sort(num.begin(),num.end());

	  for(int i=0; i< num.size()-2; i++){
	    if(i>0 && num[i] == num[i-1])
	      continue; // Skip same a                                                                 
	    if(num[i]>0)
	      continue; // if a > 0, can also skip?                                                    

	    int j = i+1;
	    int k = num.size()-1;
	    while( j < k ){
	      // check if sum to zero                                                                  
	      if( num.at(i) + num.at(j) + num.at(k) == 0){
		// add number at i,j,k to the solution set                                             
		temp.clear();
		temp.push_back(num.at(i));
		temp.push_back(num.at(j));
		temp.push_back(num.at(k));
		buff.push_back(temp);
		j++;
		k--;
	      }else if(num.at(i) + num.at(j) + num.at(k) <0 ){
		j++;
	      }else{
		k--;
	      }
          int j = i+1;
      int k = num.size()-1;
      while( j < k ){
	// check if sum to zero
	if( num.at(i) + num.at(j) + num.at(k) == 0){
	  // add number at i,j,k to the solution set
	  temp.clear();
	  temp.push_back(num.at(i));
	  temp.push_back(num.at(j));
	  temp.push_back(num.at(k));
	  buff.push_back(temp);
	  j++;
	  while(j<k && num.at(j) == num.at(j-1))
	    j++;
	  k--;
	  while(j<k && num.at(k) == num.at(k+1))
	    k--;
	}else if(num.at(i) + num.at(j) + num.at(k) <0 ){
	  j++;
	  while(j<k && num.at(j) == num.at(j-1))
	    j++;
	}else{
	  k--;
	  while(j<k && num.at(k) == num.at(k+1))
	    k--;
	}
      }
    }
    return buff;
  }
};
