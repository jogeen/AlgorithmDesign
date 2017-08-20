package com.jogeen.algorithmdesign.graph;

import com.jogeen.algorithmdesign.graph.api.Graph;
import com.jogeen.algorithmdesign.graph.api.Paths;
import com.jogeen.algorithmdesign.graph.api.Search;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstSearch implements Search, Paths {
	private boolean[] marked;
	private int count;
	private int[] edgeTo;
	private final int s;

	public DepthFirstSearch(Graph graph, int s) {
		marked = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		this.s = s;
		dfs(graph, s);
	}

	private void dfs(Graph graph, int v) {
		marked[v] = true;
		Iterable<Integer> adj = graph.adj(v);
		count++;
		for (Integer w : adj) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(graph, w);
			}
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public int count() {
		return count;
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
