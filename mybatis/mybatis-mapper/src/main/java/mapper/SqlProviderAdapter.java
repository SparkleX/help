package mapper;

import java.util.Map;

public class SqlProviderAdapter {
	public String select(Map parameters) {
		
		Object id =  parameters.get("id");
        return "SELECT USERID,PASSWORD,USER_CODE FROM OUSR";
	}
	
	public String sql(Map parameters) {
		String sql =  (String) parameters.get("sql");
        return sql;
	}
}
