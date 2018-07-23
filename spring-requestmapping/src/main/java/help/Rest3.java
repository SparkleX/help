package help;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/@*")
public class Rest3 
{
	@RequestMapping("/create")
	public String create()
	{
		return "rest3.create";
	}
}
