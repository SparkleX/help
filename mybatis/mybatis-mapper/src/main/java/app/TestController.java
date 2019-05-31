package app;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mapper.UserMapper;

@RestController
@Slf4j
public class TestController {
	@Resource
	UserMapper userMapper;
	
	@Resource
	SqlSession sqlSession;
	
	@GetMapping(path="/test")
	public Object test()
	{
		log.info("test");
		Object o = userMapper.execute("SELECT USERID,PASSWORD,USER_CODE FROM OUSR");
		return o;
	}
	
	@GetMapping(path="/test2")
	public Object test2()
	{
		Object o = sqlSession.selectList("mapper.UserMapper2.getByKey", 1);
		return o;
	}
	
	@GetMapping(path="/test3")
	public Object test3()
	{
		ResultHandler rowBound = new MyResultHandler();
		HashMap param = new HashMap();
		param.put("sql", "SELECT USERID,PASSWORD,USER_CODE FROM OUSR");
		sqlSession.select("mapper.UserMapper2.execute", param  , rowBound );
		
		return null;
	}
}
