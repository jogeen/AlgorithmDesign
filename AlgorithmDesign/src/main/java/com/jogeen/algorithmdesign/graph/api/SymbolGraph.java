package com.jogeen.algorithmdesign.graph.api;

public interface SymbolGraph {
	/**
	 * key 是一个顶点吗
	 * @param key
	 * @return
	 */
	public boolean contains(String key);
	/**
	 * Key 的索引
	 * @param key
	 * @return
	 */
	public int index(String key);
	/**
	 * 索引v 的顶点名
	 * @param v
	 * @return
	 */
	public String name(int v);
	/**
	 * 隐藏的Graph 对象
	 * @return
	 */
	public Graph G();
}
