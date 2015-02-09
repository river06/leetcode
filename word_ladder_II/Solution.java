import java.util.*;
public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // this method uses BFS
		// this method uses container to store the paths

		dict.add(end);

		Queue<String> word_queue = new LinkedList<String>();
		word_queue.add(start); // put the first word in the queue

		// key: node in the dict
		// value: paths to the word
		Map<String, Set<List<String>> > path_map = new HashMap<String, Set<List<String>> >();
		List<String> start_path = new ArrayList<String>();
		start_path.add(start);
		Set<List<String>> start_set = new HashSet<List<String>>();
		start_set.add(start_path);
		path_map.put( start, start_set );

		List<List<String>> ret = new ArrayList<List<String>>();

		// BFS

		while( !word_queue.isEmpty() ) {
			String str = word_queue.poll();

			// base case: when reaches to end
			if( str.equals(end) ) {
				ret.addAll( path_map.get( end ) );
				return ret;
			}

			for( int i=0; i< str.length(); i++) {
				for( char c = 'a'; c<='z'; c++ ) {
					if( c == str.charAt(i) ) continue;

					String new_str = replaceStr(str, i, c);

					// if the dict contains new_str
					if( !dict.contains( new_str) ) continue;
						
					if( !path_map.containsKey( new_str ) ) {
						// the ease case: when new_str is not seen before,
						// put the new_str in queue, and update the paths
						Set<List<String>> pre_paths = path_map.get( str );
						Set<List<String>> new_paths = new HashSet<List<String>>();

						for( List<String> path : pre_paths ) {
							List<String> tmp_path = new ArrayList<String>(path);
							tmp_path.add(new_str);
							new_paths.add(tmp_path);
						}

						path_map.put(new_str, new_paths);
						word_queue.offer( new_str );
					} else {
						// the word is already searched before
						Set<List<String>> pre_paths = path_map.get( str );
						Set<List<String>> new_paths = path_map.get( new_str );

						Iterator<List<String>> preIter = pre_paths.iterator();
						Iterator<List<String>> newIter = new_paths.iterator();

						if(preIter.next().size() +1 == newIter.next().size() ) {
							for(List<String> path : pre_paths ) {
								List<String> tmp_path = new ArrayList<String>( path );
								tmp_path.add( new_str);
								new_paths.add( tmp_path );
							}
						}
								
					}
				}
			}
		}
		return ret;
	}

	public String replaceStr(String s, int i, char c) {
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(i, c);
		return sb.toString();
	}
}