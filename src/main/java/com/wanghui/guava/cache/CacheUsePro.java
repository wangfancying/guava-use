package com.wanghui.guava.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalCause;
import org.junit.Test;

/**
 * 了解cache一些用法
 *
 * @author hui.wang09
 * @since 17 七月 2018
 */
public class CacheUsePro {
	static class CreateCacheLoader extends CacheLoader<String, String>{
		@Override
		public String load(String key) throws Exception {
			System.out.println("查询的key : " + key);
			return key + "cache";
		}
	}

	@Test
	public void testSize() {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(3)
				.build(new CreateCacheLoader());

		System.out.println(cache.getUnchecked("hui.wang"));
		System.out.println(cache.getUnchecked("wangda"));
		System.out.println(cache.getUnchecked("fancyig"));
		System.out.println(cache.size());

		System.out.println(cache.getUnchecked("darnia"));
		System.out.println(cache.getIfPresent("hui.wang"));
		// 打印 null ，缓存已经清理
		System.out.println(cache.getIfPresent("darnia"));
		// 打印正常

	}

	/**
	 *  权重（感觉用的比较少）不同的缓存项有不同的“权重”（weights）——例如，如果你的缓存值，占据完全不同的内存空间，
	 *  你可以使用CacheBuilder.weigher(Weigher)指定一个权重函数，并且用CacheBuilder.maximumWeight(long)指定最大总重。
	 *
	 *  要注意回收也是在重量逼近限定值时就进行了，还要知道重量是在缓存创建时计算的，因此要考虑重量计算的复杂度
	 */
	@Test
	public void testWeight() throws ExecutionException {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.maximumWeight(16)
				.weigher((key, value) -> {
					int weigh = String.valueOf(key).length() + String.valueOf(value).length();
					System.out.println("weigh : " + weigh + " , key=" + key + ", value=" + value);
					return weigh;
				})
				.build(new CreateCacheLoader());

		System.out.println(cache.getUnchecked("hui.wang09"));
		System.out.println(cache.getUnchecked("da"));
		System.out.println(cache.getUnchecked("fancyi"));
		System.out.println(cache.size());
		System.out.println(cache.getUnchecked("yes"));
		System.out.println(cache.getUnchecked("no"));
		System.out.println(cache.getUnchecked("world"));
		System.out.println(cache.size());
	}

	/**
	 * 定时回收
	 */
	@Test
	public void testAcessTime() throws ExecutionException, InterruptedException {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.expireAfterAccess(2, TimeUnit.SECONDS)
				.build(new CreateCacheLoader());

		cache.get("hui.wang09");
		TimeUnit.SECONDS.sleep(3);

		System.out.println(cache.getIfPresent("hui.wang09"));
	}

	/**
	 * 通过使用弱引用的键、或弱引用的值、或软引用的值，Guava Cache可以把缓存设置为允许垃圾回收
	 */
	@Test
	public void testWeakKey() throws InterruptedException {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.weakValues()
				.weakKeys()
				.softValues()
				.build(new CreateCacheLoader());

		cache.getUnchecked("hui.wang");
		cache.getUnchecked("darnia");

		System.gc();
		TimeUnit.MILLISECONDS.sleep(5);
		System.out.println(cache.getIfPresent("hui.wang09"));
	}

	/**
	 * 你可以声明一个监听器，以便缓存项被移除时做一些额外操作。
	 * 缓存项被移除时，RemovalListener会获取移除通知[RemovalNotification]，其中包含移除原因[RemovalCause]、键和值。
	 */
	@Test
	public void testListener() {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(3)
				.removalListener(notification -> {
					if (notification.wasEvicted()) {
						RemovalCause cause = notification.getCause();
						System.out.println("remove cacase is " + cause.toString());
						System.out.println("key: " + notification.getKey() + " ,value: " + notification.getValue());
					}
				})
				.build(new CreateCacheLoader());

		cache.getUnchecked("hui.wang");
		cache.getUnchecked("darnia");
		cache.getUnchecked("guava");
		cache.getUnchecked("wanfancying");
	}

	/**
	 * 使用CacheBuilder构建的缓存不会”自动”执行清理和回收工作，也不会在某个缓存项过期后马上清理，也没有诸如此类的清理机制。
	 * 相反，它会在写操作时顺带做少量的维护工作，或者偶尔在读操作时做——如果写操作实在太少的话。
	 *
	 * 刷新和回收不太一样。正如LoadingCache.refresh(K)所声明，
	 * 刷新表示为键加载新值，这个过程可以是异步的。在刷新操作进行时，缓存仍然可以向其他线程返回旧值，而不像回收操作，读缓存的线程必须等待新值加载完成。
	 */
	@Test
	public void testCacheRefresh() throws InterruptedException {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.refreshAfterWrite(2, TimeUnit.SECONDS)
				.build(new CreateCacheLoader());

		cache.getUnchecked("hui.wang09");
		TimeUnit.SECONDS.sleep(3);
		System.out.println(cache.getIfPresent("hui.wang09"));
	}
}
