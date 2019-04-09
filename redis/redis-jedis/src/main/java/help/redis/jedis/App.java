package help.redis.jedis;

import redis.clients.jedis.Jedis;

public class App {

	public static void main(String[] args) 
	{
		Jedis jedis = new Jedis("172.29.190.162");
		jedis.sadd("test", "123");
	
	}

}
