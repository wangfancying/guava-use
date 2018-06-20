package com.wanghui.guava.multi;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * 传统上，实现键值对的双向映射需要维护两个单独的map，并保持它们间的同步。
 * BiMap 可以维护这样的map
 *
 * @author hui.wang
 * @since 19 六月 2018
 */
public class BiMapUse {

	/**
	 * inverse() 返回此bimap，每一个bimap的值映射到其相关联的键的逆视图。
	 * forcePut(key, value) 在BiMap中,如果你想把键映射到已经存在的值，会抛出IllegalArgumentException异常如果对特定值,你想要强制替换它的键，请使用 BiMap.forcePut(key, value)
	 * @author hui.wang09
	 * @since 2018/6/19
	 */
	public static void main(String[] args) {
		BiMap<String, String> biMap = HashBiMap.create();
		biMap.put("sina","sina.com");
		biMap.put("qq","qq.com");
		biMap.put("sina","sina.cn");

		//强制替换key
		biMap.forcePut("tecent","qq.com");
		System.out.println(biMap);
		System.out.println(biMap.inverse().get("sina.com"));
		System.out.println(biMap.inverse().inverse() == biMap);
	}
}
