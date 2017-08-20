package com.jogeen.algorithmdesign.math;

import com.jogeen.algorithmdesign.graph.BreadthFirstPaths;
import com.jogeen.algorithmdesign.graph.ConnectedComponent;
import com.jogeen.algorithmdesign.graph.DepthFirstSearch;
import com.jogeen.algorithmdesign.graph.GraphUtil;
import com.jogeen.algorithmdesign.graph.api.ConnComponent;
import com.jogeen.algorithmdesign.graph.api.Graph;
import com.jogeen.algorithmdesign.graph.api.Paths;
import com.jogeen.algorithmdesign.graph.api.Search;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

public class GraphTest extends TestCase {

	public void testSearch() {
		Graph G = GraphUtil.getUndirectedGraph(7, 1);
		System.out.println(G.toString());
		Search search = new DepthFirstSearch(G, 2);
		for (int v = 0; v < G.V(); v++) {
			if (search.marked(v)) {
				StdOut.print(v + " ");
			}
		}
		StdOut.println();
		if (search.count() != G.V()) {
			StdOut.print("NOT ");
		}
		StdOut.println("connected");
	}

	public void testPaths() {
		Graph G = GraphUtil.getUndirectedGraph(7, 1);
		System.out.println(G.toString());
		int s = 2;
		Paths search = new DepthFirstSearch(G, s);
		for (int v = 0; v < G.V(); v++) {
			StdOut.print(s + " to " + v + ": ");
			if (search.hasPathTo(v))
				for (int x : search.pathTo(v))
					if (x == s)
						StdOut.print(x);
					else
						StdOut.print("-" + x);
			StdOut.println();
		}
	}

	public void testBreadthFirstPaths() {
		Graph G = GraphUtil.getUndirectedGraph(7, 2);
		System.out.println(G.toString());
		int s = 2;
		Paths search = new BreadthFirstPaths(G, s);
		for (int v = 0; v < G.V(); v++) {
			StdOut.print(s + " to " + v + ": ");
			if (search.hasPathTo(v))
				for (int x : search.pathTo(v))
					if (x == s)
						StdOut.print(x);
					else
						StdOut.print("-" + x);
			StdOut.println();
		}
	}

	public void testCC() {
		Graph G = GraphUtil.getUndirectedGraph(20, 1);
		ConnComponent cc = new ConnectedComponent(G);
		int count = cc.count();
		StdOut.println(count + " components");
		Bag<Integer>[] components;
		components = (Bag<Integer>[]) new Bag[count];
		for (int i = 0; i < count; i++) {
			components[i] = new Bag<Integer>();
		}
		for (int v = 0; v < G.V(); v++) {
			components[cc.id(v)].add(v);
		}
		for (int i = 0; i < count; i++) {
			for (int v : components[i]) {
				StdOut.print(v + " ");
			}
			StdOut.println();
		}
	}
}
