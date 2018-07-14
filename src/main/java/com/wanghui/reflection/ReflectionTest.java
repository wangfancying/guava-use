package com.wanghui.reflection;

/**
 * 1.反射的概念
 * 	JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；
 * 	这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
 * 	想要剖析一个类，必须要先获取到该类的字节码文件对象，而解剖使用的就是Class类中的方法.
 * 	所以先要获取到每一个字节码文件对应的Class类型的对象
 *
 * 	反射就是把Java类中的各个成分映射成一个个Java对象，然后操作这些对象
 *
 * @author hui.wang09
 * @since 14 七月 2018
 */
public class ReflectionTest {

	private int id;

	private void test() {
		System.out.println("this is private method");
	}

	public ReflectionTest() {
	}

	public ReflectionTest(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void main(String[] args) throws ClassNotFoundException {

		/**
		 * 获取Class对象三种方法
		 * 1.Object.getClass()方法
		 * 2.静态class属性
		 * 3.通过Class类的静态方法：forName(String classPath)
		 */
		// 方法1
		ReflectionTest reflectionTest = new ReflectionTest();
		Class getClass = reflectionTest.getClass();
		System.out.println(getClass.getName());

		// 方法2
		Class nameClass = ReflectionTest.class;
		System.out.println(getClass == nameClass);

		// 方法3
		Class forName = Class.forName("com.wanghui.reflection.ReflectionTest");
		System.out.println(forName == getClass);
	}
}
