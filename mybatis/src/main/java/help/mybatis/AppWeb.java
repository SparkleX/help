package help.mybatis;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import help.mybatis.domain.User;
import help.mybatis.repo.UserMapper;

@SpringBootApplication
@MapperScan(basePackageClasses = UserMapper.class)
@RestController
public class AppWeb 
{
	@Autowired
	UserMapper repoUser;
	static public void main(String[]argc)
	{
		SpringApplication.run(AppWeb.class, argc);
	}
	@GetMapping(path="/test")
	public List<User> test()
	{
		return repoUser.findAll();
	}
}
