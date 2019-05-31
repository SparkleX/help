package mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import domain.User;
@Mapper
public interface UserMapper2 {
	@Select("SELECT USERID,PASSWORD,USER_CODE FROM OUSR WHERE USERID = #{id}")
	User getByKey(@Param("id") Integer id);
	
	@SelectProvider(type=SqlProviderAdapter.class, method="select")
	//@Select("SELECT USERID,PASSWORD,USER_CODE FROM OUSR WHERE USERID = #{id}")
	List<User> getByKey2(@Param("id") List<Integer> a);
	
	@SelectProvider(type=SqlProviderAdapter.class, method="sql")
	List<HashMap<String,Object>> execute(@Param("sql") String sql );
}	
