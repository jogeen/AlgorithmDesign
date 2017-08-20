package com.jogeen.algorithmdesign.graph.api;

public interface Paths {
	/**
	 * 是否存在从s 到v 的路径
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v);

	/**
	 * s 到v 的路径，如果不存在则返回null
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v);
}
