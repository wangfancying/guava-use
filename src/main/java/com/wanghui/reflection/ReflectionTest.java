package com.wanghui.reflection;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

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

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {

		/**
		 * 获取Class对象三种方法
		 * 1.Object.getClass()方法
		 * 2.静态class属性
		 * 3.通过Class类的静态方法：forName(String classPath)
		 */
		// 方法1
//		ReflectionTest reflectionTest = new ReflectionTest();
//		Class getClass = reflectionTest.getClass();
//		System.out.println(getClass.getName());

		// 方法2
		Class nameClass = ReflectionTest.class;
//		System.out.println(getClass == nameClass);

		// 方法3
//		Class forName = Class.forName("com.wanghui.reflection.ReflectionTest");
//		System.out.println(forName == getClass);

		/**
		 * 获取构造方法
		 * 	1.获取所有的公共的构造方法getConstructors();
		 * 	2.获取所有的构造方法getDeclaredConstructors();
		 * 	3.获取paramType类型的构造方法getConstructor(null);-->无参
		 *
		 * 反射创建对象
		 * 	调用构造方法的newInstance方法
		 */
//		Constructor[] constructors = nameClass.getDeclaredConstructors();
//		Constructor constructor = nameClass.getDeclaredConstructor(int.class);
//		constructor.setAccessible(true);
//		Object object = constructor.newInstance(12);
//		ReflectionTest reflectionTest1 = (ReflectionTest) object;
//		System.out.println(reflectionTest1.getId());

		/**
		 * 根据配置文件加载
		 */
		Class propertiesClass = Class.forName(getValue("className"));
		Method method = propertiesClass.getDeclaredMethod(getValue("methodName"));
		method.setAccessible(true);
		method.invoke(propertiesClass.getConstructor().newInstance());
	}

	/**
	 * 获取配置文件属性
	 */
	public static String getValue(String key) throws IOException {
		Properties properties = new Properties();
		FileReader fileReader = new FileReader(System.getProperty("user.dir") + "//test.properties");
		properties.load(fileReader);
		fileReader.close();
		return properties.getProperty(key);
	}
}
