public class EditDistance {
	public static void main(String[] args) {
		String word1 ="zoologicoarchaeologist";
		String word2 ="zoogeologist";

		int result = Solution.minDistance(word1, word2);
		System.out.println(result);
	}
}