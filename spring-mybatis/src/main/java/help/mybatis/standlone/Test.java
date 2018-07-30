package help.mybatis.standlone;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test 
{
    public static void main( String[] args ) throws IOException
    {
    	String resource = "help/mybatis/standlone/mybatis-config.xml";
    	InputStream inputStream = Resources.getResourceAsStream(resource);
    	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().addMapper(DaoCustomer.class);
    	SqlSession session = sqlSessionFactory.openSession();
    	DaoCustomer daoCustomer = session.getMapper(DaoCustomer.class);
    	List<Customer> list = daoCustomer.dynamicSql(null);
    	//List<Customer> list = daoCustomer.findAll();
    	//Customer c = daoCustomer.findById(1);
    	//c.setId(100);
    	//c.setName("name");
    	//daoCustomer.insert(c);
    	session.commit();
    	session.close();
    }
}
