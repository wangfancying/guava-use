package com.wanghui.guava.rateLimiter;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * 常用的限流算法有漏桶算法和令牌桶算法，guava的RateLimiter使用的是令牌桶算法，
 * 也就是以固定的频率向桶中放入令牌，例如一秒钟10枚令牌，实际业务在每次响应请求之前都从桶中获取令牌，
 * 只有取到令牌的请求才会被成功响应，获取的方式有两种：阻塞等待令牌或者取不到立即返回失败
 *
 * @author hui.wang09
 * @since 18 七月 2018
 */
public class RateLimiterUse {

	/**
	 * RateLimiter的使用，使用acquire()方法完成限流，不过阻塞线程
	 * @author hui.wang09
	 * @since 2018/7/18
	 */
	@Test
	public void testLimit() {
		// 每秒释放0.2个令牌
		RateLimiter limiter = RateLimiter.create(0.2);
		for (int i = 0; i < 10 ; i ++) {
			// 五秒打印一次 ，阻塞线程
			System.out.println("等待时间" + limiter.acquire());
			System.out.println("print");
		}
	}

	/**
	 * 使用tryAcquire() 方法，判断是否抢到令牌，可以快速失败
	 * @author hui.wang09
	 * @since 2018/7/18
	 */
	@Test
	public void testTryAcquire() throws InterruptedException {
		RateLimiter rateLimiter = RateLimiter.create(0.2);
		for (int i = 0; i < 10; i ++) {
			if (!rateLimiter.tryAcquire()) {
				System.out.println("无法获取，快速失败");
				Thread.sleep(1000);
			}
			if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
				System.out.println("一秒钟内无法获取，快速失败");
				Thread.sleep(1000);
				continue;
			}
			System.out.println("print");
			Thread.sleep(1000);
		}
	}

}
