import java.util.*;
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Use Hashset
		// Use 20bits integers to represent strings
		List<String> ret = new ArrayList<String>();
		if(s==null || s.length()<=9) return ret;

		Map<Character, Integer> nu_map = new HashMap<Character, Integer>();
		nu_map.put('A',0);
		nu_map.put('C',1);
		nu_map.put('G',2);
		nu_map.put('T',3);

		Map<Integer, Integer> DNA_hash_map = new HashMap<Integer, Integer>();

		int seq_hash_val = 0;
		for(int i=0; i<s.length(); i++) {
			if( i<9 ) {
				seq_hash_val = seq_hash_val << 2;
				seq_hash_val += nu_map.get( s.charAt(i) );
			} else {
				seq_hash_val = seq_hash_val << 2;
				seq_hash_val += nu_map.get( s.charAt(i) );
				seq_hash_val &= 0xFFFFF;
				if( !DNA_hash_map.containsKey( seq_hash_val ) ) {
					DNA_hash_map.put(seq_hash_val, 1);
				} else {
					int count =  DNA_hash_map.get(seq_hash_val);
					if(count == 1) {
						ret.add( s.substring( i-9, i+1) );
					}
					DNA_hash_map.put( seq_hash_val, count+1);
				}
			}
		}

		return ret;
    }
}