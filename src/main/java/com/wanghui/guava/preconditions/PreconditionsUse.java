package com.wanghui.guava.preconditions;

import com.google.common.base.Preconditions;

/**
 * 前置条件Preconditions提供静态方法来检查方法或构造函数，被调用是否给定适当的参数。
 * 它检查的先决条件。其方法失败抛出IllegalArgumentException。
 * checkElementIndex(int index, int size) 检查index作为索引值对某个列表、字符串或数组是否有效
 * @author hui.wang
 * @since 19 六月 2018
 */
public class PreconditionsUse {

	/**
	 * checkArgument(boolean) 检查boolean是否为true
	 * checkNotNull(T) 检查value是否为null
	 *
	 * @author hui.wang09
	 * @since 2018/6/19
	 */
	public static void main(String[] args) {
		try{
			sqrt(-10);
		}catch (Exception e) {
			e.printStackTrace();
		}

		try{
			sum(null, new Integer(10));
		}catch (Exception e) {
			e.printStackTrace();
		}

		try{
			getValue(10);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static double sqrt(double input) {
		Preconditions.checkArgument(input >= 0.0, "Illegal Argument passed: Negative value %s", input);
		return Math.sqrt(input);
	}

	private static int sum(Integer a, Integer b) {
		Preconditions.checkNotNull(a, "First parameter is Null.");
		Preconditions.checkNotNull(b, "Second parameter is Null.");
		return a + b;
	}

	private static int getValue(int input) {
		int[] data={1,2,3,4,5};
		Preconditions.checkElementIndex(input, data.length, "Invalid index.");
		return data[input];
	}

}
