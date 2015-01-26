package hw;

import java.util.*;

public class Solution {
    public static ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
		
		if(strs==null || strs.length ==0) {
			return result;
		}

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for (int i=0; i<strs.length; i++) {
			char[] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			String str = new String(tmp);
			if (map.containsKey(str) ) {
				map.get(str).add(strs[i]);
				
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(str,list);
			}
		}
		
		Iterator<ArrayList<String>>  iter = map.values().iterator();
		while(iter.hasNext()) {
			ArrayList<String> item = iter.next();
			if(item.size()>1){
				result.addAll(item);
			}
		}
		
		return result;
		
    }
}
