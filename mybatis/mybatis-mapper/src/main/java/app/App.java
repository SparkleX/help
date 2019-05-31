package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mapper.UserMapper;

@SpringBootApplication
@MapperScan(basePackageClasses = UserMapper.class)
public class App {


	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}
