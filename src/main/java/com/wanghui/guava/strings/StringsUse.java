package com.wanghui.guava.strings;

import java.util.Arrays;
import java.util.HashMap;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

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

		/**
		 * 判断字符是不是为空
		 */
		System.out.println(Strings.isNullOrEmpty(null));
		/**
		 * 如果字符为null转换成空串
		 */
		System.out.println(Strings.nullToEmpty(null));

		/**
		 * 获取两个字符串相同的前缀
		 */
		System.out.println(Strings.commonPrefix("test", "test"));
		/**
		 * 获取两个字符串相同的后缀
		 */
		System.out.println(Strings.commonSuffix("test", "test"));

		/**
		 * 补全字符串
		 */
		System.out.println(Strings.padEnd("Strings", 10, 'g'));
		System.out.println(Strings.padStart("String", 10, 's'));

		/**
		 * 重复
		 */
		System.out.println(Strings.repeat("guava", 2));

		/**
		 * rimResults()方法去掉子串的空格，以及omitEmptyStrings()方法去掉空的子串
		 * limit(int limit)方法，当分割的子字符串达到了limit个时，则停止分割
		 */
		Splitter splitter = Splitter.onPattern("[,]{1,}").trimResults().omitEmptyStrings();
		System.out.println(splitter.split("hello,,,,,,world,java"));  //[hello, world，java]
		System.out.println(splitter.limit(3).split("hello,,,,,,world,java,,,,spring"));	//[hello, world, java,,,,spring]

		/**
		 * Splitter类可以在结果中继续分割,直接返回Map的键值对
		 */
		System.out.println(splitter.withKeyValueSeparator("=").split("a=1,b=3,,c=4"));		//{a=1, b=3, c=4}

		/**
		 * joiner : 用分隔符把字符串序列连接起来，skipNulls()跳过空串
		 */
		Joiner joiner = Joiner.on(";").skipNulls();
		System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
		System.out.println(Joiner.on("-").join(Arrays.asList(1,5,7)));

		/**
		 * Joiner也可以将Map<String,String>做合并
		 */
		HashMap<String, String> hashMap = Maps.newHashMap();
		hashMap.put("a","1");
		hashMap.put("b", "23");
		System.out.println(Joiner.on(";").withKeyValueSeparator("=").join(hashMap));

	}
}
