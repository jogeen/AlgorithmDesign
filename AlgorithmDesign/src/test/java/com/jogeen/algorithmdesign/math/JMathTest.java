package com.jogeen.algorithmdesign.math;

import junit.framework.TestCase;

public class JMathTest extends TestCase {

	/**
	 * 欧几里德算法：求最大公约数
	 */
	public void testGcd() {
		assertEquals(3, JMath.gcd(6, 9));
	}
}
