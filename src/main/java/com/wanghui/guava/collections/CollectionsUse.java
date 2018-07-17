package com.wanghui.guava.collections;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 关于Lists,Sets,Maps等集合工具类
 *
 * @author hui.wang
 * @since 20 六月 2018
 */
public class CollectionsUse {

	/**
	 * 工具类静态方法：初始化集合，初始化时就指定起始元素，初始化集合大小
	 * @author hui.wang09
	 * @since 2018/6/20
	 */
	public static void main(String[] args) {

		/**静态方法*/
		List<String> list = Lists.newArrayList();
		Set<String> set = Sets.newHashSet("alpha", "beta", "gamma");
		Map<String, String> map = Maps.newHashMapWithExpectedSize(10);

		/**filter*/
		List<String> filterList= Lists.newArrayList("moon","dad","refer","son");
		Collection<String> palindromeList = Collections2.filter(filterList, input -> {
			//找回文串
			return new StringBuilder(input).reverse().toString().equals(input);
		});
		System.out.println("filter list : " + palindromeList);

		/**transform*/
		Set<Long> times= Sets.newHashSet();
		times.add(91299990701L);
		times.add(9320001010L);
		times.add(9920170621L);
		Collection<String> timeStrCol = Collections2.transform(times,
				(input) -> {return new SimpleDateFormat("yyyy-MM-dd").format(input);});
		System.out.println("tranform  list : " + timeStrCol);

		/**functions*/
		Function<String, String> f1 = (s) -> {return s.length() > 5 ? s.substring(0, 5) : s;};
		Function<String, String> f2 = (input -> {return input.toUpperCase();});

		Function<String, String> function = Functions.compose(f1, f2);
		Collection<String> results = Collections2.transform(filterList, function);
		System.out.println(results);

		/**交集，并集，差集*/
		Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5);
		Set<Integer> set2 = Sets.newHashSet(3, 4, 5, 6);
		//交集
		Sets.SetView<Integer> inter = Sets.intersection(set1, set2);
		System.out.println(inter);
		//差集,在A中不在B中
		Sets.SetView<Integer> diff = Sets.difference(set1, set2);
		System.out.println(diff);
		//并集
		Sets.SetView<Integer> union = Sets.union(set1, set2);
		System.out.println(union);
	}
}
