import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(n<0 || k<0 || n<k) return result;
        
        
        for(int i=1; i<=n-k+1;i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(i);
            dfs(1, n, k, tmp, result);
            tmp.remove(0);
        }
        
        return result;
        
    }
    
    private static void dfs(int i, int n, int k, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> result) {
        // base case
        if (i==k){
            ArrayList<Integer> newTmp = new ArrayList<Integer>(tmp);
            result.add(newTmp);
            return;
        }
        
        for( int j=tmp.get(i-1)+1; j<=n; j++) {
            tmp.add(j);
            dfs(i+1, n, k, tmp, result);
            tmp.remove(i);
        }
        
    }
}