package si.fri.mediations.reciver;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;


public class ServiceConsumer {
	public static final Logger LOG = Logger.getLogger(ServiceConsumer.class.getName());

	private final static String QUEUE_NAME = "prpo";

	public ServiceConsumer() {

		LOG.info("Constructor for ServiceConsumer created");
	}

	public void getMessageReport() throws IOException, TimeoutException {
		LOG.info("getStationReport from ServiceConsumer run");
		String msg = null;
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	    
	    Consumer consumer = new DefaultConsumer(channel) {
	        @Override
	        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
	            throws IOException {
	          String message = new String(body, "UTF-8");
	          System.out.println(" [x] Received '" + message + "'");
	        }
	      };
	      channel.basicConsume(QUEUE_NAME, true, consumer);

	      channel.close();
	      connection.close();
	}
}
