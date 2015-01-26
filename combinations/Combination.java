
import java.util.*;

public class Combination {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        ArrayList<ArrayList<Integer>> result = Solution.combine(n,k);
        
        System.out.println(result);
    }
}