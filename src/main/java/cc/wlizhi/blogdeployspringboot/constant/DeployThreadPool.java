package cc.wlizhi.blogdeployspringboot.constant;

import java.util.concurrent.*;

/**
 * @author Eddie
 */
public class DeployThreadPool {
	private static int deploySinglePoolThreadNameCounter;
	public static ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(200);
	private static final ThreadPoolExecutor DEPLOY_SINGLE_POOL = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS,
			queue, new DeployThreadFactory());

	public static ExecutorService getDeploySinglePool() {
		return DEPLOY_SINGLE_POOL;
	}

	static class DeployThreadFactory implements ThreadFactory {

		@Override
		public Thread newThread(Runnable r) {
			return new Thread("deploy-thread-" + ++deploySinglePoolThreadNameCounter);
		}
	}
}
