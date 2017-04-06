package com.huawei.component.distribute.redis.lock;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import com.huawei.component.distribute.DistributeLockUtilsEx;
import com.huawei.component.distribute.IDistributeLockProvider;
import com.huawei.component.log.LogUtilsEx;

import lombok.Getter;
import lombok.Setter;

public class DistributeLockProvider4Redis implements IDistributeLockProvider {
	// #region Fields

	@Setter
	@Getter
	private int waitTime;

	@Setter
	@Getter
	private String lockName;

	@Setter
	@Getter
	private RedissonClient redissonClient;

	@Setter
	@Getter
	private RLock rlock;

	@Setter
	private boolean timeout;

	// #endregion

	// #region Construction

	public DistributeLockProvider4Redis(String strLockName, int iTimeoutMs) {
		this.lockName = strLockName;
		this.waitTime = iTimeoutMs;
		this.redissonClient = RedissonClientUtils.getRedissonClient(); // Redisson.create();
	}

	// #endregion

	// #region lock

	@Override
	public void lock() {
		rlock = redissonClient.getLock(lockName);
		try {
			timeout = rlock.tryLock(waitTime, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			timeout = true;
			LogUtilsEx.log("[DistributeLockUtils4Redis]ex:" + e.getMessage(), DistributeLockUtilsEx.IS_DEBUG);
		}
	}

	// #endregion

	// #region unlock

	@Override
	public void unlock() {
		rlock.unlock();
		// shutdown 性能耗时2s
		// redissonClient.shutdown();
	}

	// #endregion

	// #region isTimeout

	@Override
	public boolean isTimeout() {
		return timeout;
	}

	// #endregion
}