public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split(".");
		String[] v2 = version2.split(".");

		System.out.println(v1);

		int n = Math.min(v1.length, v2.length);
		System.out.println(n);
		
		for(int i=0; i<n; i++) {
			int num1 = Integer.parseInt(v1[i]);
			int num2 = Integer.parseInt(v2[i]);

			System.out.println(num1);
			System.out.println(num2);
			if( num1 > num2 ) {
				return 1;
			} else if (num1 <num2) {
				return -1;
			}
		}
		if(v1.length == v2.length ){
			return 0;
		} else if( v1.length>v2.length) {
			return 1;
		} else {
			return -1;
		}
    }
}