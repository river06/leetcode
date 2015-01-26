class Solution {
public:
    int sqrt(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // Use Newton's method f(y) = y^2-x = 0 y = sqrt(x)
        // need to use Newton's method to iterate y
        // y_n+1 = y_n - f(y_n)/f'(y_n) = y_n -(y_n^2 - x)/(2*y_n)
        // z = y - f(y_n)/f'(y_n) = y_n -(y_n^2 - x)/(2*y_n)
        double y, z;
        double err = 0.0001;
        if (x == 0) z = 0;
        else{
          y = x; // initial value
          z = y - 0.1;
	  while(fab(z-y)>err){
	    y = z;
	    z = y -(y*y-x)/(2*y);
	  }       
	}
	return int(z);        
    }
};
