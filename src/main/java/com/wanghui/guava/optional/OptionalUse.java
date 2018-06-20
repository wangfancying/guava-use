package com.wanghui.guava.optional;

import com.google.common.base.Optional;

/**
 * 使用optional
 *
 * Guava用Optional用于包含非空对象的不可变对象。一个Optional实例可能包含非null的引用（我们称之为引用存在），
 * 也可能什么也不包括（称之为引用缺失）。它从不说包含的是null值，而是用存在或缺失来表示。但Optional从不会包含null值引用。
 *
 * @author hui.wang
 * @since 30 五月 2018
 */
public class OptionalUse {

	/**
	 * Optional.absent() 返回空引用的Optional的实例
	 * Optional.of(b) 返回包含给定的非空引用Optional的实例。
	 * Optional.fromNullable(如果nullableReference非空)  如果nullableReference非空，返回一个包含引用Optional实例;否则返回absent()。
	 * isPresent() 是否包含非空引用
	 * or(defaultValue) 返回此Optional，如果它有一个值存在; 否则返回默认值
	 * get() 返回所包含的实例，否则抛空指针异常
	 * @author hui.wang09
	 * @since 2018/6/19
	 */
	public static void main(String[] args) {
		Integer a = new Integer(10);
		Integer b = new Integer(1);

//		Optional<Integer> optional1 = Optional.absent();
		Optional<Integer> optional1 = Optional.fromNullable(a);
		Optional<Integer> optional2 = Optional.of(b);

		System.out.println(sum(optional1, optional2));
	}

	public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
		System.out.println("first parameter is present : " + a.isPresent());
		System.out.println("second parameter is present : " + b.isPresent());

		Integer value1 = a.get();
		Integer value2 = b.or(new Integer(0));

		return  value1 + value2;
	}

}
