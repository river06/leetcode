public class Solution {
    public double pow(double x, int n) {
        if(n==0) return 1;
		if(x==0) return 0;

		if(n<0) {
			return 1.0/powRec(x, -n);
		}else {
			return powRec(x, n);
		}
    }

	private double powRec(double x, int n) {
		if(n==0) return 1;

		double half = powRec(x, n/2);
		if(n%2 ==0) {
			return half*half;
		} else {
			return half*half*x;
		}
	}
}