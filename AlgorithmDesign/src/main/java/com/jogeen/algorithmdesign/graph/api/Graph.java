package com.jogeen.algorithmdesign.graph.api;

public interface Graph {

	/**
	 * 获取顶点数.
	 * @return
	 */
	public int V();

	/**
	 * 边数.
	 * @return
	 */
	public int E();

	/**
	 * 添加一条边
	 * @param v
	 * @param W
	 */
	public void addEdge(int v, int w);

	/**
	 * 和定点V相领的所有顶点
	 * @param v
	 */
	public Iterable<Integer> adj(int v);

	/**
	 * 字符串表示
	 * @return
	 */
	public String toString();
}
