package com.jogeen.algorithmdesign.graph.api;

public interface ConnComponent {
	/**
	 * v和w是否连通
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean connected(int v,int w);
	/**
	 * 连通分量数
	 * @return
	 */
	public int count();
	/**
	 * v 所在的连通分量的标识符（0~count()-1）
	 * @param v
	 * @return
	 */
	public int id(int v);
}
