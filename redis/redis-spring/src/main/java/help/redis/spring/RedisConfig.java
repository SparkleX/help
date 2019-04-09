package help.redis.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
	@Bean
	RedisConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory("172.29.190.162",6379);
	}
	@Bean
	RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
	    template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
	    template.setKeySerializer(new StringRedisSerializer());
	    template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
	    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());		
		return template;
	}
}
