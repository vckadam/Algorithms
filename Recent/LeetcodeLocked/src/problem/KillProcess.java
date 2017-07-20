package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KillProcess {
	
	public List<Integer> getKilledProcesses(List<Integer> pid, List<Integer> ppid, int kill) {
		Map<Integer,List<Integer>> parentMap = new HashMap<Integer,List<Integer>>();
		for(int i = 0; i < ppid.size(); i++) {
			if(!parentMap.containsKey(ppid.get(i))) {
				parentMap.put(ppid.get(i), new ArrayList<Integer>());
			}
			parentMap.get(ppid.get(i)).add(pid.get(i));
		}
		
		if(!parentMap.containsKey(kill)) return null;
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> ret = new ArrayList<Integer>();
		queue.offer(kill);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			ret.add(temp);
			if(parentMap.containsKey(temp)) {
				queue.addAll(parentMap.get(temp));
			}
		}
		return ret;
	}
}
