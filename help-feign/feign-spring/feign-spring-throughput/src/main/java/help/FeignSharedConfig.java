package help;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Client;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class FeignSharedConfig 
{
	private ObjectMapper objectMapper;

	FeignSharedConfig()
	{
		objectMapper = new ObjectMapper();
	}

	@Autowired
	CloseableHttpClient httpClient;
	
	@Bean
	public Client client() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException
	{
		return new ApacheHttpClient(httpClient);
	}
	
	@Bean
	public RequestInterceptor basicAuthRequestInterceptor() 
	{
	        return new FeignRequestInterceptor();
	}
	
	@Bean
	Decoder decoder()
	{
		return new JacksonDecoder(objectMapper);
	}
	@Bean
	Encoder encoder()
	{
		return  new JacksonEncoder(objectMapper);
	}
	   
}
