package com.wanghui.java8.Optional;

import java.util.Optional;

/**
 * 在我们的开发中，NullPointerException可谓是随时随处可见，为了避免空指针异常，我们常常需要进行一
 * 些防御式的检查，所以在代码中常常可见if(obj != null) 这样的判断。幸好在JDK1.8中，java为我们提供了
 * 一个Optional类，Optional类能让我们省掉繁琐的非空的判断。
 *
 * @author hui.wang09
 * @since 16 七月 2018
 */
public class OptionalTest {
	public static void main(String[] args) throws Exception {
		/**
		 * of 把指定的值封装为Optional对象，如果指定的值为null，则抛出NullPointerException
		 */
		Optional<String> ofOptional = Optional.of("yes");

		/**
		 * empty 创建一个空的Optional对象
		 */
		Optional<String> emptyOptional = Optional.empty();

		/**
		 * ofNullable 把指定的值封装为Optional对象，如果指定的值为null，则创建一个空的Optional对象
		 */
		Optional<String> ofNullOptional = Optional.ofNullable(null);

		/**
		 * get 如果创建的Optional中有值存在，则返回此值，否则抛出NoSuchElementException
		 */
		System.out.println("Optinal.get() -> " + emptyOptional.get());

		/**
		 * orElse 如果创建的Optional中有值存在，则返回此值，否则返回一个默认值
		 */
		System.out.println("Optional.orElse -> " + ofNullOptional.orElse("test"));

		/**
		 * orElseGet 如果创建的Optional中有值存在，则返回此值，否则返回一个由Supplier接口生成的值
		 */
		System.out.println("Optional.orElseGet() -> " + ofNullOptional.orElseGet(() -> "test"));

		/**
		 * orElseThrow 如果创建的Optional中有值存在，则返回此值，否则抛出一个由指定的Supplier接口生成的异常
		 */
		System.out.println(ofNullOptional.orElseThrow(() -> new Exception("test")));

		/**
		 * filter 如果创建的Optional中的值满足filter中的条件，则返回包含该值的Optional对象，否则返回一个空的Optional对象
		 */
		System.out.println("Optional.filter() -> " + ofOptional.filter((s) -> s.equals("yes")));

		/**
		 * map 如果创建的Optional中的值存在，对该值执行提供的Function函数调用
		 */
		System.out.println("Optional.map() -> " + ofOptional.map((s) -> {
			return 1;
		}));

		/**
		 * flagMap 如果创建的Optional中的值存在，就对该值执行提供的Function函数调用，返回一个Optional类型的值，否则就返回一个空的Optional对象
		 */
		System.out.println("Optional.flatMap -> " + ofOptional.flatMap((s) -> {
			return Optional.of("yes") ;
		}));

		/**
		 * isPresent 如果创建的Optional中的值存在，返回true，否则返回false
		 */
		System.out.println("Optional.isPresent() -> " + ofOptional.isPresent());

		/**
		 * ifPresent 如果创建的Optional中的值存在，则执行该方法的调用，否则什么也不做
		 */
		ofOptional.ifPresent((s) -> {
			System.out.println("ifPresent()");
		});
	}
}
