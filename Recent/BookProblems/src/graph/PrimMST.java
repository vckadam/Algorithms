package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PrimMST {
	public List<String> getMST(int n, List<List<Object>> edges) {
		/*
		 * [A,B,3] [C,D,4] [D,E,5]
		 * 
		 */
		 
		Map<Character,String> edgeMap = new HashMap<Character,String>();
		Map<Character,List<Character>> adjNodes = new HashMap<Character,List<Character>>();
		Map<Character,List<Object>> hm = new HashMap<Character, List<Object>>();
		int[][] weight = new int[n][n];
		
		Comparator<List<Object>> comp = new Comparator<List<Object>>() {
			public int compare(List<Object> obj1, List<Object> obj2) {
				int val1 = (int)obj1.get(1);
				int val2 = (int)obj2.get(1);
				return val1-val2;
			}
		};
		PriorityQueue<List<Object>> pq = new PriorityQueue<List<Object>>(comp);
		
		for(List<Object> edge : edges) {
			char start = (char)edge.get(0);
			char end = (char)edge.get(1);
			int dist = (int)edge.get(2);
			if(!adjNodes.containsKey(start)) {
				adjNodes.put(start, new ArrayList<Character>());
				List<Object> node = new ArrayList<Object>();
				node.add(start);
				node.add(Integer.MAX_VALUE);
				hm.put(start, node);
				pq.add(node);
				edgeMap.put(start, "");
			}
			if(!adjNodes.containsKey(end)) {
				adjNodes.put(end, new ArrayList<Character>());
				List<Object> node = new ArrayList<Object>();
				node.add(end);
				node.add(Integer.MAX_VALUE);
				pq.add(node);
				hm.put(end, node);
				edgeMap.put(end, "");
			}
			adjNodes.get(start).add(end);
			adjNodes.get(end).add(start);
			
			weight[end-'A'][start-'A'] = weight[start-'A'][end-'A'] = dist;
		}
		
		//System.out.println(Arrays.deepToString(weight));
		//System.out.println(adjNodes.toString());
		//System.out.println(pq.toString());
		//System.out.println(hm.toString());
		
		while(!pq.isEmpty()) {
			List<Object> curr = pq.poll();
			char currNode = (char)curr.get(0);
			hm.remove(currNode);
			List<Character> neighbours = adjNodes.get(currNode);
			for(Character neighbour : neighbours) {
				if(hm.containsKey(neighbour)) {
					List<Object> neighbourVal = hm.get(neighbour);
					int neighbourDist = (int)neighbourVal.get(1);
					if(weight[currNode-'A'][neighbour-'A'] < neighbourDist) {
						pq.remove(neighbourVal);
						neighbourVal.set(1, weight[currNode-'A'][neighbour-'A']);
						edgeMap.put(neighbour, currNode+""+neighbour);
						pq.add(neighbourVal);
					}
				}
			}
			//System.out.println(currNode);
			//System.out.println(pq.toString());
			//System.out.println(hm.toString());
		}
		
		List<String> ret = new ArrayList<String>();
		for(Character key : edgeMap.keySet()) {
			String currEdge = edgeMap.get(key);
			if(!currEdge.equals("")) {
				ret.add(currEdge);
			}
		}
		return (ret.size() != n-1)? null : ret;
	}
}
