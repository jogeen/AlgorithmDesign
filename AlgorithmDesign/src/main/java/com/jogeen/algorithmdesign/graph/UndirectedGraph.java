package com.jogeen.algorithmdesign.graph;

import com.jogeen.algorithmdesign.graph.api.Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class UndirectedGraph implements Graph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	UndirectedGraph(int v) {
		this.V = v;
		this.E = 0;
		adj = new Bag[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new Bag<Integer>();
		}
	}

	UndirectedGraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);

	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public String toString() {
		String s = V + " vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (int w : this.adj(v)){
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
}
