package com.jogeen.algorithmdesign.graph;

import com.jogeen.algorithmdesign.graph.api.Graph;
import com.jogeen.algorithmdesign.graph.api.Paths;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths implements Paths {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	public BreadthFirstPaths(Graph graph, int s) {
		this.s = s;
		edgeTo = new int[graph.V()];
		marked = new boolean[graph.V()];
		bfs(graph, s);
	}

	private void bfs(Graph graph, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while (!queue.isEmpty()) {
			Integer v = queue.dequeue();
			for (Integer w : graph.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					edgeTo[w] = v;
					queue.enqueue(w);
				}
			}
		}
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
