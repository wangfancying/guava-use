package com.wanghui.guava.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * Guava Cache是一个全内存的本地缓存实现，它提供了线程安全的实现机制。
 * 整体上来说Guava cache 是本地缓存的不二之选，简单易用，性能好。
 *
 * CacheLoader和Callable通过这两种方法创建的cache
 *
 * LoadingCache查询的正规方式是使用get(K)方法。这个方法要么返回已经缓存的值，要么使用CacheLoader向缓存原子地加载新值。
 * Callable不管有没有自动加载功能，都支持get(K, Callable<V>)方法。这个方法返回缓存中相应的值，或者用给定的Callable运算并把结果加入到缓存中。
 *
 * @author hui.wang
 * @since 20 六月 2018
 */
public class CacheUse {

	/** LoadingCache 使用方式*/
	private static LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().refreshAfterWrite(3, TimeUnit.HOURS)
			.expireAfterAccess(3, TimeUnit.HOURS)
			.maximumSize(1000).build(new CacheLoader<String, String>() {
				/** 当本地缓存命没有中时，调用load方法获取结果并将结果缓存 **/
				@Override
				public String load(String key) throws Exception {
					System.out.println("添加缓存。。。");
					return "loadingCache";
				}
			});

	/** Callable 使用方式 */
	private static Cache<String, String> cache = CacheBuilder.newBuilder().build();

	public static void main(String[] args) throws ExecutionException {
		System.out.println("loadingCache : " + loadingCache.get("test"));

		System.out.println("callable : " + cache.get("test", new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("callable 加载缓存...");
				return "callable";
			}
		}));
	}
}
