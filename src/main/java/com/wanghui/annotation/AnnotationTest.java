package com.wanghui.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 使用自己的注解
 * @author hui.wang09
 * @since 14 七月 2018
 */
@MyAnnotation(id = 100, msg = "class")
public class AnnotationTest {

	@MyAnnotation(id = 200, msg = "field")
	private String fileAnnotation;

	@MyAnnotation(id = 300, msg = "method")
	private void methodAnnotation() {
	}

	/**
	 * 注解的提取
	 * 	注解通过反射获取。首先可以通过 Class 对象的 isAnnotationPresent() 方法判断它是否应用了某个注解
	 * 	然后通过 getAnnotation() 方法来获取 Annotation 对象。
	 *
	 */
	public static void main(String[] args) {

		/**
		 * 获取class 的注解
		 */
		boolean haveMyAnnotation = AnnotationTest.class.isAnnotationPresent(MyAnnotation.class);
		if (haveMyAnnotation) {
			MyAnnotation myAnnotation = AnnotationTest.class.getAnnotation(MyAnnotation.class);
			System.out.println(myAnnotation.id());
			System.out.println(myAnnotation.msg());
		}

		/**
		 * 获取method的注解
		 */
		Method[] methods = AnnotationTest.class.getDeclaredMethods();
		Arrays.stream(methods).forEach(method -> {
			MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
			if (myAnnotation != null) {
				System.out.println(myAnnotation.id());
				System.out.println(myAnnotation.msg());
			}
		});


		/**
		 * 获取field注解
		 */
		Field[] fields = AnnotationTest.class.getDeclaredFields();
		Arrays.stream(fields).filter(field -> field.isAnnotationPresent(MyAnnotation.class))
				.forEach(field -> {
					MyAnnotation myAnnotation = field.getAnnotation(MyAnnotation.class);
					System.out.println(myAnnotation.id());
					System.out.println(myAnnotation.msg());
				});
	}
}