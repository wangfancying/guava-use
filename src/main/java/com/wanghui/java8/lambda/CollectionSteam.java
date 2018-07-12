package com.wanghui.java8.lambda;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

/**
 * 集合的流 stream
 *
 * @author hui.wang09
 * @since 11 七月 2018
 */
public class CollectionSteam {

	/**
	 * 1.调用stream 方法生成流
	 * 2.map 方法参数是Function类型，会将String 转换成 Integer
	 * 3.filter 方法参数是 Predicate类型，过滤条件
	 * 4.collect 方法收集最终的结果。接受collector类型的参数
	 * @author hui.wang09
	 * @since 2018/7/11
	 */
	public static void main(String[] args) {
		List<String> array = Lists.newArrayList("1", "2", "3", "4", "5", "6");

		List<Integer> a = array.stream().map(s -> Integer.parseInt(s))
				.filter(integer -> integer >= 4)
				.collect(Collectors.toList());

		System.out.println(a);
	}
}
