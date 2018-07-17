package com.wanghui.guava.multi;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Multiset可统计一个词在文档中出现了多少次
 * 它可以多次添加相等的元素,并可以统计出一个词在文档中出现了多少次
 *
 * @author hui.wang
 * @since 19 六月 2018
 */
public class MultisetUse {

	public static void main(String[] args) {
		Multiset<String> multiset = HashMultiset.create();
		multiset.add("a");
		multiset.add("b");
		multiset.add("a");
		multiset.add("a");
		multiset.setCount("b", 10);

		System.out.println("multi size() : " + multiset.size());
		/**
		 * Multiset 的元素
		 */
		System.out.println("multi elementSet size(): " + multiset.elementSet().size());

		/**
		 * Multiset 的某个元素的数量
		 */
		System.out.println("multi a count : " + multiset.count("a"));
	}
}
