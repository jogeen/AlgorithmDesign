package com.jogeen.algorithmdesign.example;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
	/**
	 * 二分查找法非递归实现
	 * @param key  搜索的关键字
	 * @param array  有序数组
	 * @return 返回关键字在数组中的索引，-1代表没有查询到
	 */
	public static int rank(int key, int[] array) {
		int lowIndex = 0;
		int highIndex = array.length - 1;
		while (lowIndex <= highIndex) {
			int mid = lowIndex + (highIndex - lowIndex) / 2;
			if (key == array[mid]) {
				return mid;
			} else if (key > array[mid]) {
				lowIndex = mid + 1;
			} else {
				highIndex = mid - 1;
			}
		}
		return -1;
	}

	/**二分查找法递归实现
	 * @param key
	 * @param array
	 * @param lowIndex
	 * @param highIndex
	 * @return
	 */
	public static int rank(int key, int[] array, int lowIndex, int highIndex) {
		if (lowIndex > highIndex) {
			return -1;
		}
		int mid = lowIndex + (highIndex - lowIndex) / 2;
		if (key == array[mid]) {
			return mid;
		} else if (key > array[mid]) {
			lowIndex = mid + 1;
		} else {
			highIndex = mid - 1;
		}
		return rank(key, array, lowIndex, highIndex);
	}

	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		while (!StdIn.isEmpty()) { // 读取键值，如果不存在于白名单中则将其打印
			int key = StdIn.readInt();
			// if (rank(key, whitelist) < 0)
			if (rank(key, whitelist, 0, whitelist.length - 1) < 0)
				StdOut.println(key);
		}
	}
}
