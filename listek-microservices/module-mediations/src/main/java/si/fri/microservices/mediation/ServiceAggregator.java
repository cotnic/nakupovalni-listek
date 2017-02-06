package si.fri.microservices.mediation;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

import si.fri.microservives.model.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class ServiceAggregator {

	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		LOG.info("Initializing ServiceAggregator");
		
		
		initTimer();
	}

	public static final Logger LOG = Logger.getLogger(ServiceAggregator.class.getName());

	private List<Station> stationList;

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	private List<Station> getStationList() {
		LOG.info("Getting station list");
		
		if (stationList == null) {
			stationList = Collections.synchronizedList(new ArrayList<Station>());
		}

		return stationList;

	}

	private class MyRunnable implements Runnable {

		private String stopStation;
		private List<Station> stationList;
		private ServiceConsumer sc;

		public MyRunnable(String stopStation, List<Station> stationList) {
			this.stopStation = stopStation;
			this.stationList = stationList;
			sc = new ServiceConsumer();
		}

		public void run() {
			LOG.log(Level.INFO, "service called");
			LOG.info("RUN has ben executed");
			Station station = sc.getStationReport(stopStation);
			

			stationList.add(station);
		}
	}

	public void initTimer() {
		LOG.info("Starting init timer");

		MyRunnable runnable = new MyRunnable("bavarski", getStationList());

		final ScheduledFuture<?> runnableHandle = scheduler.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS);

	}

	public List<Station> getAggregatedReport() {

		LOG.info("Getting aggregate report of stations");

		
		return getStationList();

	}

}