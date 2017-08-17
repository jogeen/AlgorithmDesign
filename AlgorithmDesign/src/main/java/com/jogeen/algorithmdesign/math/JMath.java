package com.jogeen.algorithmdesign.math;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class JMath {

	/**
	 * 欧几里德算法、求最大公约数 自然语言描述： 计算两个非负整数p 和q 的最大公约数：若q 是0，则最大公约数为p。 否则，将p 除以q
	 * 得到余数r，p 和q 的最大公约数即为q 和r 的最大公约数。
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}

	public static void main(String[] args) {
		int N = 50;
		double[] a = new double[N];
		for (int i = 0; i < N; i++)
		{
			a[i] = StdRandom.random();
		}
		Arrays.sort(a);
		Arrays.sort(a, 1, 2);
		for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
}
