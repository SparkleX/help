package help;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;

public class Recv {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv)
	      throws java.io.IOException, Exception {
		  ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("localhost");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();

		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		    
		    Consumer consumer = new DefaultConsumer(channel) {
		    	  @Override
		    	  public void handleDelivery(String consumerTag, Envelope envelope,
		    	                             AMQP.BasicProperties properties, byte[] body)
		    	      throws IOException {
		    	    String message = new String(body, "UTF-8");
		    	    System.out.println(" [x] Received '" + message + "'");
		    	    System.exit(1);
		    	    //channel.basicAck(envelope.getDeliveryTag(), false);
		    	  }
		    };
		    channel.basicConsume(QUEUE_NAME, true, consumer);
	  }
}
