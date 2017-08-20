package com.jogeen.algorithmdesign.graph;

import com.jogeen.algorithmdesign.graph.api.ConnComponent;
import com.jogeen.algorithmdesign.graph.api.Graph;

public class ConnectedComponent implements ConnComponent {
	private int count;
	private boolean marked[];
	private int[] id;

	public ConnectedComponent(Graph graph) {
		marked = new boolean[graph.V()];
		id = new int[graph.V()];
		for (int v = 0; v < graph.V(); v++) {
			if (!marked[v]) {
				dfs(graph, v);
				count++;
			}
		}
	}

	private void dfs(Graph graph, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : graph.adj(v)) {
			if (!marked[w]) {
				dfs(graph, w);
			}
		}
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int count() {
		return count;
	}

	public int id(int v) {
		return id[v];
	}

}
