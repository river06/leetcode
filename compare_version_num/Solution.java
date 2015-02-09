public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

//		System.out.println(v1);

		int n = Math.min(v1.length, v2.length);
		int m = Math.max(v1.length, v2.length);
//		System.out.println(n);
		
		for(int i=0; i<m; i++) {
			int num1 = 0;
			int num2 = 0;
			if(i <n ) {
				num1 = Integer.parseInt(v1[i]);
				num2 = Integer.parseInt(v2[i]);
			} else {
				if( i<v1.length ) {
					num1 = Integer.parseInt(v1[i]);
				} else if( i<v2.length ) {
					num2 = Integer.parseInt(v2[i]);
				}
			}

//			System.out.println(num1);
//			System.out.println(num2);
			if( num1 > num2 ) {
				return 1;
			} else if (num1 <num2) {
				return -1;
			}
		}
		return 0;
    }
}