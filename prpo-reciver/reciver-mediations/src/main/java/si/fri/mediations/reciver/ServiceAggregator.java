package si.fri.mediations.reciver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class ServiceAggregator {

	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		LOG.info("Initializing ServiceAggregator");
		
		
		initTimer();
	}

	public static final Logger LOG = Logger.getLogger(ServiceAggregator.class.getName());


	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	private class MyRunnable implements Runnable {

		private ServiceConsumer sc;

		public MyRunnable() {
			sc = new ServiceConsumer();
		}

		public void run() {
			LOG.log(Level.INFO, "service called");
			LOG.info("RUN has been executed");
			try {
				sc.getMessageReport();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void initTimer() {
		LOG.info("Starting init timer");

		MyRunnable runnable = new MyRunnable();

		final ScheduledFuture<?> runnableHandle = scheduler.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.SECONDS);

	}

}