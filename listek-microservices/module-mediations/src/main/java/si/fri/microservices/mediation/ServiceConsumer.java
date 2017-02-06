package si.fri.microservices.mediation;

import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import si.fri.microservives.model.Station;

public class ServiceConsumer {

	public static final Logger LOG = Logger.getLogger(ServiceConsumer.class.getName());
	
	private Client client;
	private WebTarget base;
	private WebTarget stationService;

	public ServiceConsumer() {
		this.client = ClientBuilder.newClient();
		this.base = client.target("https://www.trola.si");
		this.stationService = base.path("/");

		LOG.info("Constructor for ServiceConsumer created");
	}

	public Station getStationReport(String stopStation) {
		LOG.info("getStationReport from ServiceConsumer run");
		
		WebTarget target = stationService.path(stopStation);
		
		Response response = target.request().header("Accept", "application/json").get();
		
		Station station = response.readEntity(Station.class);
		

		return station;

	}

}