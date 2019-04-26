package help.mybatis;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import help.mybatis.repo.DynamicSqlMapper;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@RunWith(SpringRunner.class)
@MybatisTest
public class DynamicSqlTest
{
    @Autowired
    private DynamicSqlMapper mapper;
    @Test
    public void returnMapTest() {
        List<Map<String,Object>> users = mapper.findAll();
        assertNotNull(users);
        assertTrue(users.size()>0);
        Assert.assertEquals("name1", users.get(0).get("NAME"));
    }
    
    @Test
    public void dynamicSelectTest() {
    	SelectStatementImpl selectStatement = new SelectStatementImpl("select * from users where id = #{id}");
    	/*select(orderMaster.orderId, orderDate, orderDetail.lineNumber, orderDetail.description, orderDetail.quantity)
                .from(orderMaster, "om")
                .join(orderDetail, "od").on(orderMaster.orderId, equalTo(orderDetail.orderId))
                .build()
                .render(RenderingStrategy.MYBATIS3);*/
    	selectStatement.setParam("id",1);
        List<Map<String,Object>> users = mapper.findBySql(selectStatement);
        assertNotNull(users);
        assertTrue(users.size()>0);
        Assert.assertEquals("name1", users.get(0).get("NAME"));
    }
    
    @Test
    public void sqlBuilderTest() {
    	UsersTable  simpleTable = new UsersTable();
    	SelectStatementProvider  selectStatement = select(simpleTable.id)
                .from(simpleTable, "om").build().render(RenderingStrategy.MYBATIS3);
        List<Map<String,Object>> users = mapper.findBySql(selectStatement);
        assertNotNull(users);
        assertTrue(users.size()>0);
        Assert.assertEquals(1, users.get(0).get("ID"));
    }

}