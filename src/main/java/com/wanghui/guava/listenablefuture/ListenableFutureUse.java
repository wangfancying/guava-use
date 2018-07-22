package com.wanghui.guava.listenablefuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import javax.annotation.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * ListenableFuture是可以监听的Future，它是对java原生Future的扩展增强。Future表示一个异步计算任务，当任务完成时可以得到计算结果。
 * 如果希望计算完成时马上就拿到结果展示给用户或者做另外的计算，就必须使用另一个线程不断的查询计算状态。
 * 这样做会使得代码复杂，且效率低下。如果使用ListenableFuture，
 * Guava会帮助检测Future是否完成了，如果完成就自动调用回调函数，这样可以减少并发程序的复杂度。
 *
 * @author hui.wang
 * @since 26 六月 2018
 */
public class ListenableFutureUse {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));

		// 创建任务
		Callable<Object> callable = () -> {
			System.out.println("this is ok");
			return null;
		};

		// 提交任务
		ListenableFuture expression = listeningExecutorService.submit(callable);

		// 添加回调函数
		Futures.addCallback(expression, new FutureCallback<Object>() {
			@Override
			public void onSuccess(@Nullable Object result) {
				System.out.println("this is success");
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println("this is fail");
			}
		}, listeningExecutorService);

		System.out.println(expression.get());

		/**
		 * 同时Guava中Futures对于Future扩展还有：
		 * transform：对于ListenableFuture的返回值进行转换。
		 * allAsList：对多个ListenableFuture的合并，返回一个当所有Future成功时返回多个Future返回值组成的List对象。注：当其中一个Future失败或者取消的时候，将会进入失败或者取消。
		 * successfulAsList：和allAsList相似，唯一差别是对于失败或取消的Future返回值用null代替。不会进入失败或者取消流程。
		 * immediateFuture/immediateCancelledFuture： 立即返回一个待返回值的ListenableFuture。
		 * makeChecked: 将ListenableFuture 转换成CheckedFuture。CheckedFuture 是一个ListenableFuture ，其中包含了多个版本的get 方法，方法声明抛出检查异常.这样使得创建一个在执行逻辑中可以抛出异常的Future更加容易
		 * @author hui.wang09
		 * @since 2018/6/26
		 */

		// 创建future
		ListenableFuture future1 = listeningExecutorService.submit(() -> {
			System.out.println("call future 1.");
			return 1;
		});
		ListenableFuture future2 = listeningExecutorService.submit(() -> {
			System.out.println("call future 2.");
			return 2;
		});

		// allAsList()方法
		final ListenableFuture allFutures = Futures.allAsList(future1, future2);

		// 添加回调函数
		Futures.addCallback(allFutures, new FutureCallback<Object>() {
			@Override
			public void onSuccess(@Nullable Object result) {
				System.out.println("this is success");
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println("this is fail");
			}
		}, listeningExecutorService);

		System.out.println(allFutures.get());
	}
}
