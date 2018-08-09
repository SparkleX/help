package help.client.openfeign;


import feign.RequestLine;

public interface Client 
{
	@RequestLine("GET /test")
    ClientBean test();
}