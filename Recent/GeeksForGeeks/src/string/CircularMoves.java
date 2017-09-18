package string;

import java.util.HashMap;
import java.util.Map;

public class CircularMoves {
	/* Check if given set of moves is circular or not
	 * Check if given set of moves is circular or not. 
	 * The move is circular if its starting and ending coordinates are the same. 
	 * The moves can contain instructions to move one unit in same direction (M), 
	 * to change direction to left of current direction (L) and 
	 * to change direction to right of current direction (R).
	 * 
	 * Set of moves MRMRMRM is circular
	 * 
	 * Set of moves MRMLMRMRMMRMM is circular
	 */
	public boolean isCircularTrip(String str) {
		if(str == null)
			throw new IllegalArgumentException("Illegal Argument");
		int[] pos = new int[2];
		int dir = 0, step = 1;
		Map<String,Integer> next = populateMap();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'M') 
				pos[dir] += step;
			else {
				step = next.get(dir+"#"+step+"#"+str.charAt(i));
				dir ^= 1;
			}
		}
		return pos[0] == 0 && pos[1] == 0;
	}
	
	
	public Map<String,Integer> populateMap() {
		Map<String,Integer> hm = new HashMap<String,Integer>();
		hm.put("0#1#R", -1);
		hm.put("0#1#L", 1);
		hm.put("0#-1#R", 1);
		hm.put("0#-1#L", -1);
		hm.put("1#1#R", 1);
		hm.put("1#1#L", -1);
		hm.put("1#-1#R", -1);
		hm.put("1#-1#L", 1);
		return hm;
	}
}
