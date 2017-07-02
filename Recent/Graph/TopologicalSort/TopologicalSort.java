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
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, List<Integer>> hm = new HashMap<>();
		for(int[] edge : edges) {
			nodes.add(edge[0]);
			nodes.add(edge[1]);
			if(!hm.containsKey(edge[0])) hm.put(edge[0], new ArrayList<Integer>());
			hm.get(edge[0]).add(edge[1]);
		}
		for(Integer node : nodes) {
			if(!visited.contains(node)) dfs(visited, stack, hm, node);
		}
		while(!stack.isEmpty()) ret.add(stack.pop());
		return ret;
	}
	public void dfs(Set<Integer> visited, Stack<Integer> stack, Map<Integer,List<Integer>> hm, int node) {
		visited.add(node);
		List<Integer> neighbours = hm.get(node);
		if(neighbours != null) {
			for(Integer neighbour : neighbours) {
				if(!visited.contains(neighbour)) dfs(visited, stack, hm, neighbour);
			}
		}
		stack.push(node);
	}
}
