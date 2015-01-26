

public class InterInterval {
	public static void main(String[] args) {
		String s1 = "aabc";
		String s2 = "dbbca";
		String s3 = "aadbbbacc";
		boolean result = Solution.isInterleave(s1,s2,s3);
		System.out.println(result);
	}
}