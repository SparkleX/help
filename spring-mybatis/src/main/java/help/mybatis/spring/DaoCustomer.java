package help.mybatis.spring;


import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface DaoCustomer 
{
    @Select("select * from Customer")
    public List<Customer> findAll();
                                           
    
    @Select("<script>select * from Customer WHERE 1=1 <if test=\"id != null\"> AND id = #{id}</if></script>")
    public List<Customer> dynamicSql(@Param("id")Integer id); 
    		  
    		  
    @Select("select * from Customer where id=#{idss}")
    public Customer findById(int id);
                                                                                                                                                                                                                                   
    @Select("select * from Customer where id=#{id} and name like #{name}")
    public Customer findByIdAndName(@Param("id")int id,@Param("name")String names);
                                                                                                                                                                                                                                   
    @Insert("insert into Customer(id,name) VALUES(#{id},#{name})")
    public void insert(Customer user);
                                                                                                                                                                                                                                   
    @Delete("delete from Customer where id=#{id}")
    public void delete(int id);
                                                                                                                                                                                                                                   
    @Update("update Customer set id=#{id},name=#{name} where id=#{id}")
    public void update(Customer user);
}