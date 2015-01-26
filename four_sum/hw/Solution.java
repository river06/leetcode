public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        for( int i=0; i<num.length-3; i++) {
            for(int j=i+1; j<num.length-2; j++) {
                int k = j+1;
                int l = num.length-1;
                
                while(k<l) {
                    int sum = num[i]+num[j]+num[k]+num[l];
                    
                    if(sum==target) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[k]);
                        tmp.add(num[l]);
                        
                        if(!hashSet.contains(tmp)) {
                            hashSet.add(tmp);
                            result.add(tmp);
                        }
                        k++;
                        l--;
                    } else if (sum>target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        
        
        return result;
    }
}