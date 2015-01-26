class Solution {
public:
    int lengthOfLongestSubstring(string s) {
      // Need two pointers begin and current i
      // A moving window to check the repeated char. and store the longest dist.
      // Creat a table to store the position of the char. last appeared
      // A table position is given by the ASII of different char.
      //      vector<int> pos(265, -1);
      //      int dist = 0;
      //      int begin = 0;
      //      for(int i = 0; i< s.size(); ++i){
      //        begin = max(begin, pos.at(s.at(i)) + 1);
      //	pos.at(s.at(i)) = i;
      //     	dist = max(dist, i-begin+1);
      //     }
      //      return dist;
      vector<int> pos(265,-1);
      int dist = 0;
      int begin = 0;
      int lastAppear;
      for(int i = 0; i<s.size();++i){
	lastAppear = pos.at(s.at(i));// the index of last apprearance
	// check current char inside current window or not
	begin = max(begin,lastAppear + 1);  
	pos.at(s.at(i)) = i;// update the current index
	dist = max(dist, i-begin+1);
      }
      return dist;
    }
};
