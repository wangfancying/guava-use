package com.wanghui.guava.objects;

import com.google.common.base.Objects;

/**
 * Objects类提供适用于所有对象，提供一些如equals, hashCode等辅助函数
 *
 * @author hui.wang
 * @since 19 六月 2018
 */
public class ObjectsUse {

	/**
	 * objects.equal帮助你执行null敏感的equals判断，从而避免抛出NullPointerException
	 * objects.hashCode(field1, field2, …, fieldn) 用对象的所有字段作散列[hash]运算应当更简单
	 * @author hui.wang09
	 * @since 2018/6/19
	 */
	public static void main(String[] args) {

		Test test1 = new Test(10, "test");
		Test test2 = new Test(10, "test");

		System.out.println(Objects.equal(test1, test2));
		System.out.println(test1.hashCode());

	}

	public static class Test {
		private int id;
		private String name;

		public Test(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(id, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Test)) {
				return false;
			}
			Test that = (Test) obj;
			return Objects.equal(id, that.getId()) && Objects.equal(name, that.getName());
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
	}
}

