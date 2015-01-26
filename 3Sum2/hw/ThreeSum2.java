package hw;

public class ThreeSum2{
    public static void main(String[] args) {
        int[] test = {-1 ,2 ,1 ,-4};
        int target = 1;
        int result = Solution.threeSumClosest(test, target);
        System.out.println(result);
    }
}