package com.wanghui.guava.multi;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * Multimap可以很容易地把一个键映射到多个值
 * a -> 1 a -> 2 a ->4 b -> 3 c -> 5
 *
 * @author hui.wang
 * @since 19 六月 2018
 */
public class MultiMapuse {

	/**
	 * asMap为Multimap<K, V>提供Map<K,Collection<V>>形式的视图
	 * entries用Collection<Map.Entry<K, V>>返回Multimap中所有”键-单个值映射”——包括重复键。
	 * keySet用Set表示Multimap中所有不同的键。
	 * keys用Multiset表示Multimap中的所有键，每个键重复出现的次数等于它映射的值的个数
	 * values()用一个”扁平”的Collection<V>包含Multimap中的所有值。
	 * @author hui.wang09
	 * @since 2018/6/19
	 */
	public static void main(String[] args) {
		Multimap<String, Integer> multimap = HashMultimap.create();
		multimap.put("a", 1);
		multimap.put("a", 2);
		multimap.put("a", 3);
		multimap.put("b", 4);
		multimap.put("b", 5);

		System.out.println("multimap get: " + multimap.get("a"));
		System.out.println("multimap size: " + multimap.size());
		System.out.println("multimap keyset size: " + multimap.keySet().size());
		System.out.println("multimap entries : " + multimap.entries());
		System.out.println("multimap keys : " + multimap.keys());
		System.out.println("multimap values : " + multimap.values());
		System.out.println("multimap asMap : " + multimap.asMap());
	}
}
