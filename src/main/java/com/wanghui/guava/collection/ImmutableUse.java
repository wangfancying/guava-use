package com.wanghui.guava.collection;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;

/**
 * 当你不希望修改一个集合类，或者想做一个常量集合类的时候，使用immutable集合类就是一个最佳的编程实践。
 *
 * @author hui.wang
 * @since 19 六月 2018
 */
public class ImmutableUse {

	/**
	 * copyOf() 创建Immutable集合
	 * of() 创建Immutable集合
	 * Builder() 创建Immutable集合
	 * @author hui.wang09
	 * @since 2018/6/19
	 */
	public static void main(String[] args) {
		List<String> list = Lists.newArrayList();
		list.add("a");
		list.add("c");
		list.add("b");
		list.add("f");

		System.out.println("list: " + list);
		ImmutableList immutableList = ImmutableList.copyOf(list);

		System.out.println("immutableList : " + immutableList);

		ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry", "harry");
		System.out.println("imOflist：" + imOflist);

		ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
		System.out.println("imSortList：" + imSortList);

		list.add("test");
		System.out.println("list add item : " + list);
		System.out.println("list add item after : " + immutableList);

		ImmutableSet<String> immutableSet = ImmutableSet.<String>builder()
				.add("test")
				.add("c")
				.build();

		System.out.println("immutableSet : " + immutableSet);

	}
}
