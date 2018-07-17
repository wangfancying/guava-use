package com.wanghui.guava.ordering;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 排序器[Ordering]是Guava流畅风格比较器[Comparator]的实现，
 * 它可以用来为构建复杂的比较器，以完成集合排序的功能。
 *
 * @author hui.wang
 * @since 19 六月 2018
 */
public class OrderingUse {

	/**
	 * natural() 对可排序类型做自然排序，如数字按大小，日期按先后排序
	 * reverse() 获取语义相反的排序器
	 * nullsFirst() 使用当前排序器，但额外把null值排到最前面。
	 * isOrdered(Iterable) 判断可迭代对象是否已按排序器排序：允许有排序值相等的元素。
	 *
	 * @author hui.wang09
	 * @since 2018/6/19
	 */
	public static void main(String[] args) {



//		List<Integer> number = Lists.newArrayList();
//		number.add(new Integer(12));
//		number.add(new Integer(132));
//		number.add(new Integer(23));
//		number.add(new Integer(52));
//		number.add(new Integer(39));
//		number.add(new Integer(29));
//		number.add(new Integer(43));
//		number.add(new Integer(16));
//		System.out.println("input list : " + number);
//
//		Ordering ordering = Ordering.natural();
//		Collections.sort(number, ordering);
//		System.out.println("order list : " + number);
//
//		System.out.println("list is ordered : " + ordering.isOrdered(number));
//		System.out.println("list max : " + ordering.min(number));
//		System.out.println("list min : " + ordering.max(number));
//
//		Collections.sort(number, ordering.reverse());
//		System.out.println("reverse : " + number);
//
//		number.add(null);
//		System.out.println(number);
//
//		Collections.sort(number, ordering.nullsFirst());
//		System.out.println("Null first Sorted List : " + number);

		/**
		 * natural方法
		 */
		List<People> list = Lists.newArrayList(new People(2, "yes"), new People(3, "ok"),new People(1, "ss"));
		Ordering<People> ordering = Ordering.natural().onResultOf((people) -> people.getId());
		ordering.sortedCopy(list).stream().forEach((o) -> System.out.println(o));

		/**
		 * reverse方法
		 */
		Ordering<People> reverseOrdering = Ordering.natural().reverse().onResultOf((input -> input.getId()));
		reverseOrdering.sortedCopy(list).stream().forEach((people -> System.out.println(people)));

		/**
		 * usingToString方法
		 */
		Ordering<People> stringOrdering = Ordering.usingToString().onResultOf((people ->  people.getName()));
		stringOrdering.sortedCopy(list).stream().forEach((people -> System.out.println(people)));

		/**
		 * from方法,自定义的Comparator比较器来创建Ordering
		 */
		Ordering<People> fromOrdering = Ordering.from((people1, people2) -> {
			return people1.getId() - people2.getId();
		});
		fromOrdering.sortedCopy(list).stream().forEach((people -> System.out.println(people)));
	}

	static class People {
		private int id;
		private String name;

		public People(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public People() {
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "People{" + id +"," + name +"}";
		}
	}
}
