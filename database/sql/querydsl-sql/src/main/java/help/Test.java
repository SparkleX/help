package help;

import java.sql.Connection;
import java.util.List;

import com.querydsl.sql.HSQLDBTemplates;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.SQLTemplates;

public class Test {

	public static void main(String[] args)
	{
		QCustomer customer = new QCustomer("c");

		SQLTemplates dialect = new HSQLDBTemplates(); // SQL-dialect
		Connection connection;
		SQLQuery<?> query = new SQLQuery<Void>(connection, dialect);
		List<String> lastNames = query.select(customer.lastName)
		    .from(customer)
		    .where(customer.firstName.eq("Bob"))
		    .fetch();
		
	}

}
