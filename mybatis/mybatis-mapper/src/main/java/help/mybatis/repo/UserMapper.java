package help.mybatis.repo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import domain.User;


public interface UserMapper extends MapperBase<User, Integer>
{
    @Insert("insert into users(id,name,email) values(#{id},#{name},#{email})")
    //@SelectKey(statement="call identity()", keyProperty="id", before=false, resultType=Integer.class)
    void insert(User user);
    
    @Delete("delete from users where id=#{id}")
    void delete(Integer id);
    
    @Select("select * from users where id=#{id}")
    User findById(Integer id);
    
    @Override
    @Select("select * from users")
    List<User> findAll();
    
    @Select("select * from users where ${column} = #{value}")
    List<User> findByColumn(@Param("column")String column, @Param("value")Object value);
    
    
}