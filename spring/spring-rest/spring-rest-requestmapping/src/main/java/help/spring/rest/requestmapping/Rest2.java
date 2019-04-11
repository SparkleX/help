package help.spring.rest.requestmapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/{object}")
public class Rest2 
{
	@RequestMapping("/create")
	public String create(@PathVariable String object)
	{
		return object + ".create";
	}
}
