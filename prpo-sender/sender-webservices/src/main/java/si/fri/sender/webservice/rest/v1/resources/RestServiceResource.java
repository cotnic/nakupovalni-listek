package si.fri.sender.webservice.rest.v1.resources;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import si.fri.sender.model.Sporocilo;

@RequestScoped
@Path("send")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestServiceResource {

	public static final Logger LOG = Logger.getLogger(RestServiceResource.class.getName());

	private final static String QUEUE_NAME = "prpo";

	@POST
	@Path("/")
	public Response setSporocilo(Sporocilo sporocilo) throws IOException, TimeoutException {
		LOG.info("Starting web service setSporocilo");

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		channel.basicPublish("", QUEUE_NAME, null, sporocilo.getVsebina().getBytes());
		LOG.info("Poslano sporocilo: " + sporocilo.getVsebina());

		channel.close();
		connection.close();

		return Response.ok().build();

	}

}