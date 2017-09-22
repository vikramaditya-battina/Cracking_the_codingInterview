package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;

public class RouteBetweenNodes {
	public class DirectedGraphNode{
		int label;
		ArrayList<DirectedGraphNode> neighbors;
		DirectedGraphNode(int x){
			this.label = x;
			this.neighbors = new ArrayList<DirectedGraphNode>();
		}
	}
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
		HashMap<DirectedGraphNode, Boolean> visitedMap = new HashMap<DirectedGraphNode, Boolean>();
		return hasRoute(graph, s, t, visitedMap);
	}
	
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t, HashMap<DirectedGraphNode, Boolean> visitedMap) {
		if(s == t) {
			return true;
		}
		visitedMap.put(s,true);
		ArrayList<DirectedGraphNode> neighbours = s.neighbors;
		for(DirectedGraphNode node : neighbours) {
			if(visitedMap.containsKey(node)) {
				continue;
			}
			if(hasRoute(graph, node, t, visitedMap)) {
				return true;
			}
		}
		return false;
	}
	
}
