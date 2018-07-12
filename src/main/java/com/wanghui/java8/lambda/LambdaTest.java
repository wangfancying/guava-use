package com.wanghui.java8.lambda;

/**
 * 关于lambda表达式
 *
 * λ表达式的类型，叫做“目标类型（target type）”。
 * λ表达式的目标类型是“函数接口（functional interface）”，
 * 这是JDK8新引入的概念。它的定义是：一个接口，如果只有一个显式声明的抽象方法，那么它就是一个函数接口。
 *
 * @author hui.wang09
 * @since 11 七月 2018
 */
public class LambdaTest {

	/**
	 * JDK预定义了很多函数接口以避免用户重复定义
	 *
	 * 1.典型的是Function：
	 * public interface Function<T, R> {
	 *		 R apply(T t);
	 * }
	 * 这个接口代表一个函数，接受一个T类型的参数，并返回一个R类型的返回值。
	 *
	 *
	 * 2.预定义函数接口 Consumer
	 * public interface Predicate<T> {
	 *		 boolean test(T t);
	 *	}
	 * 接受一个T类型的参数，没有返回值
	 *
	 *
	 * 3.预定义函数接口 Predicate
	 * public interface Predicate<T> {
	 *		boolean test(T t);
	 * }
	 * 用来判断某项条件是否满足
	 * @author hui.wang09
	 * @since 2018/7/11
	 */
	public static void main(String[] args) {

		Runnable runnable = () -> {
			System.out.println("hello Lambda");
		};

		runnable.run();

	}
}
