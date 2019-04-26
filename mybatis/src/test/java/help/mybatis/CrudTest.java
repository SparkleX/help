package help.mybatis;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import help.mybatis.domain.User;
import help.mybatis.repo.MapperBase;
import help.mybatis.repo.UserMapper;

@RunWith(SpringRunner.class)
@MybatisTest
public class CrudTest
{
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test() {
        List<User> users = userMapper.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }
    @Test
    public void baseTest() 
    {
    	MapperBase<User, Integer> base = userMapper;
        List<User> users = base.findAll();
        Assert.assertTrue("record loaded", users.size()>0);
    }
    @Test
    public void insertTest() 
    {
    	User user = new User();
    	user.setId(100);
        userMapper.insert(user);        
        Assert.assertTrue("inserted", true);
        
        userMapper.delete(user.getId());
    }
    @Test
    public void findByIdTest() 
    {
        User user = userMapper.findById(1);
        Assert.assertTrue("record loaded", user.getId()==1);
        
        user = userMapper.findById(-1);
        Assert.assertTrue("record not loaded", user==null);

    }
    
    @Test
    public void findByColumnTest() 
    {
        List<User> users = userMapper.findByColumn("id", 1);
        Assert.assertTrue("record loaded", users.size()>0);
    }
}