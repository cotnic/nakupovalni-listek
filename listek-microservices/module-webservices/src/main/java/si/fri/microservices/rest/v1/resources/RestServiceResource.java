package si.fri.microservices.rest.v1.resources;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import si.fri.microservices.mediation.ServiceAggregator;
import si.fri.microservives.model.Station;


@RequestScoped
@Path("stations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestServiceResource {
	
	public static final Logger LOG = Logger.getLogger(RestServiceResource.class.getName());

	@Inject
    private ServiceAggregator serviceAggregator;


    @GET
    public Response getStation(){
    	LOG.info("Starting web service getStation");

        List<Station> station = serviceAggregator.getAggregatedReport();


        return Response.ok().entity(station).build();

    }
	
}