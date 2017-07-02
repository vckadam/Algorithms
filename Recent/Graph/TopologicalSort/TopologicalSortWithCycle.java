package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
	public List<Integer> getTopologicalSort(int[][] edges) {
		List<Integer> ret = new ArrayList<Integer>();
		Set<Integer> nodes = new HashSet<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		Set<Integer> done = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, List<Integer>> hm = new HashMap<>();
		for(int[] edge : edges) {
			nodes.add(edge[0]);
			nodes.add(edge[1]);
			if(!hm.containsKey(edge[0])) hm.put(edge[0], new ArrayList<Integer>());
			hm.get(edge[0]).add(edge[1]);
		}
		for(Integer node : nodes) {
			if(!done.contains(node)) 
				if(dfs(visited, done, stack, hm, node)) return null;
		}
		while(!stack.isEmpty()) ret.add(stack.pop());
		return ret;
	}
	public boolean dfs(Set<Integer> visited, Set<Integer> done, Stack<Integer> stack, Map<Integer,List<Integer>> hm, int node) {
		visited.add(node);
		List<Integer> neighbours = hm.get(node);
		if(neighbours != null) {
			for(Integer neighbour : neighbours) {
				if(visited.contains(neighbour)) return true;
				if(done.contains(neighbour)) continue;
				if(dfs(visited, done, stack, hm, neighbour)) return true;
			}
		}
		visited.remove(node);
		done.add(node);
		stack.push(node);
		return false;
	}
}
