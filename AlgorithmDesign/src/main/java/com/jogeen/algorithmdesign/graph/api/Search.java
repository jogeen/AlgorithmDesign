package com.jogeen.algorithmdesign.graph.api;

public interface Search {
	/**
	 * 判断v和s是否连通
	 * @param v
	 * @return
	 */
	public boolean marked(int v);
	/**
	 * 与s连接的顶点总数
	 * @return
	 */
	public int count();
	
}
