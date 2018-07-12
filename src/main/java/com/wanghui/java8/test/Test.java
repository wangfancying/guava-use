package com.wanghui.java8.test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * TODO completion javadoc.
 *
 * @author hui.wang09
 * @since 11 七月 2018
 */
public class Test {

	static class Yes{
		private int id;
		private String name;
	}

	public static void main(String[] args) {

		List<String > test = Lists.newArrayList();
		test.add("ttest");
		test.add("test");
		test.add("test");

		System.out.println(test.stream().collect(Collectors.toSet()));

		get(test);
		System.out.println(test.size());
	}

	public static void get(List<String> list) {
		Set<String> set = Sets.newHashSet();
		set.add("ttest");
		set.add("test");
		set.addAll(list);
		System.out.println(set);
	}
}
