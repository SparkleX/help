package cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class Insert {

	public static void main(String[] args) {
		Cluster cluster = null;
		try {
		    cluster = Cluster.builder()
		            .addContactPoint("127.0.0.1")
		            .build();
		    Session session = cluster.connect();
		    ResultSet rs = session.execute("select * from test.emp");
			for(Row row:rs.all())
		    {
		    	System.out.println(row.getString("emp_city"));
		    }
		} finally {
		    if (cluster != null) cluster.close();
		}

	}

}
