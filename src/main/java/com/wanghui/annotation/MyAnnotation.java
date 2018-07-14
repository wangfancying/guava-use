package com.wanghui.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解的使用
 *
 * 	1.注解的定义
 * 	注解通过 @interface 关键字进行定义。
 *
 * 	2.元注解
 * 	元注解是可以注解到注解上的注解，标明注解是干嘛的
 * 	元标签有 @Retention、@Documented、@Target、@Inherited、@Repeatable 5 种。
 *  	1.@Retention 当@Retention 应用到一个注解上的时候，它解释说明了这个注解的的存活时间。
 *  	它的取值如下：
 * 			RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
 * 			RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
 * 			RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。
 *		2.@Documented 它的作用是能够将注解中的元素包含到 Javadoc 中去。
 * 		3.@Target @Target 指定了注解运用的地方。
 * 		@ Target 有下面的取值
 *			ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
 *			ElementType.CONSTRUCTOR 可以给构造方法进行注解
 *			ElementType.FIELD 可以给属性进行注解
 *			ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
 *			ElementType.METHOD 可以给方法进行注解
 *			ElementType.PACKAGE 可以给一个包进行注解
 *			ElementType.PARAMETER 可以给一个方法内的参数进行注解
 *			ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
 * 		4.@Inherited Inherited 是继承的意思
 * 		注解 Test 被 @Inherited 修饰，之后类 A 被 Test 注解，类 B 继承 A,类 B 也拥有 Test 这个注解。
 *
 * @author hui.wang09
 * @since 14 七月 2018
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface MyAnnotation {

	/**
	 * 注解中属性可以有默认值，默认值需要用 default 关键值指定
	 */
	int id() default 0;
	String msg() default "default";
}
