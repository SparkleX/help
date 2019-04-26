package help.mybatis.repo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

public interface DynamicSqlMapper 
{
    @Select("select * from users")
    List<Map<String, Object>> findAll();
    
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    List<Map<String, Object>> findBySql(SelectStatementProvider selectStatement);
}
