package com.wanghui.guava.throwables;

import java.io.IOException;
import java.sql.SQLException;

import com.google.common.base.Throwables;

/**
 * guava类库中的Throwables提供了一些异常处理的静态方法.
 * 这些方法的从功能上分为两类，一类是帮你抛出异常，另外一类是帮你处理异常。
 * @author hui.wang09
 * @since 17 七月 2018
 */
public class ThrowablesUse {
	public static void main(String[] args) throws SQLException {
		try {
			throw new IOException("this is exception");
		} catch (Throwable throwable) {
			/**
			 * 如果异常的类型是SQLException，那么抛出这个异常
			 */
			Throwables.propagateIfPossible(throwable, SQLException.class);
			/**
			 * 获得异常堆栈的字符串
			 */
			System.out.println(Throwables.getStackTraceAsString(throwable));
		}
	}
}
