class Solution {
public:
    int reverse(int x) {
      int temp;
      int res = 0;
      temp = abs(x);
      while(temp > 0){
	res = 10*res + temp%10;
	temp /= temp;
      }
      if(x>0) return res;
      else return -res;        
    }
};
