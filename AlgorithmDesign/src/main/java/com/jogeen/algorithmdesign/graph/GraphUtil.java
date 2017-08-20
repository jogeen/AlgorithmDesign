package com.jogeen.algorithmdesign.graph;

import com.jogeen.algorithmdesign.graph.api.Graph;

import edu.princeton.cs.algs4.StdRandom;

public class GraphUtil {
	public static int degree(Graph graph,int v){
		int degree=0;
		Iterable<Integer> adj = graph.adj(v);
		for (Integer integer : adj) {
			 degree++;
		}
		return degree;
	}
	public static int maxDegree(Graph graph){
		int max=0;
		int v = graph.V();
		for (int i = 0; i < v; i++) {
			int degree = degree(graph,i);
			if(degree>max){
				max=degree;
			}
		}
		return max;
	}
	public static double avgDegree(Graph graph){
		return graph.E()*2/graph.V();
	}
	
	public static int numberOfSelfLoops(Graph graph){
		int v = graph.V();
		int count=0;
		for (int i = 0; i <v; i++) {
			Iterable<Integer> adj = graph.adj(i);
			for (Integer w : adj) {
				if(i==w){
					count++;
				}
			}
		}
		return count/2;
	}
	
	public static Graph getUndirectedGraph(int v,int degree){
		Graph graph=new UndirectedGraph(v);
		for (int i = 0; i < v; i++) {
			for (int j = 0; j <degree; j++) {
				int uniform = StdRandom.uniform(0,v);
				if(i==uniform){
					continue;
				}
				graph.addEdge(i,uniform);
			}
		}
		return graph;
	}
	public static void main(String[] args) {
		Graph undirectedGraph = getUndirectedGraph(7,2);
		System.out.println(undirectedGraph.toString());
	}
}
