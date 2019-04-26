package help.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

public class SelectStatementImpl implements SelectStatementProvider{

	private String sql;
	HashMap<String,Object> params = new HashMap<String,Object>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	Integer id = 1;
	

	public SelectStatementImpl(String sql)
	{
		this.sql = sql;
	}
	@Override
	public Map<String, Object> getParameters() 
	{
		return params;
	}

	@Override
	public String getSelectStatement() {
		return sql;
	}
	public void setParam(String key, Object value) {
		params.put(key, value);
		
	}

}
