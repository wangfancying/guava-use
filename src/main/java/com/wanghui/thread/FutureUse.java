package com.wanghui.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.junit.Test;

/**
 * 先上一个场景：假如你突然想做饭，但是没有厨具，也没有食材。网上购买厨具比较方便，食材去超市买更放心。
 * 实现分析：在快递员送厨具的期间，我们肯定不会闲着，可以去超市买食材。
 *
 * @author hui.wang09
 * @since 18 七月 2018
 */
public class FutureUse {

	@Test
	public void testFuture() throws InterruptedException, ExecutionException {
		// 网购
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("callable is doing work");
				Thread.sleep(2000);
				System.out.println("callable done");
				return "this is ok";
			}
		};

		FutureTask<String> task = new FutureTask<>(callable);
		new Thread(task).start();

		Thread.sleep(1000);
		System.out.println("main thread is ok");
		if (!task.isDone()) {
			System.out.println("callable is not ok");
		}

		Thread.sleep(1000);
		String result = task.get();
		System.out.println(result);

	}
}
