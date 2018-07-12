package com.wanghui.guava.strings;

import java.util.Arrays;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * 字符串工具类
 * @author hui.wang
 * @since 26 六月 2018
 */
public class StringsUse {

	/**
	 * joiner : 用分隔符把字符串序列连接起来
	 * Splitter 提供了各种方法来处理分割操作字符串，对象等
	 *
	 * @author hui.wang09
	 * @since 2018/6/26
	 */
	public static void main(String[] args) {
		Joiner joiner = Joiner.on(";").skipNulls();
		System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
		System.out.println(Joiner.on("-").join(Arrays.asList(1,5,7)));

		Splitter splitter = Splitter.on(",");
	}
}
