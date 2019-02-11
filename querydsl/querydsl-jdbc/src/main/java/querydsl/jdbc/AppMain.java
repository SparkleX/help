package querydsl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.SQLTemplates;

import gen.bean.Ocrd;
import gen.query.QOcrd;

public class AppMain {

	public static void main(String[] args) throws Exception 
	{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","1234");
		
		SQLTemplates dialect = MySQLTemplates.builder()				
				.build();
		SQLQuery<Ocrd> query = new SQLQuery<>(conn, dialect); 
		
		QOcrd t0 = new QOcrd("t0");
		List<Ocrd> bps = query.select(t0)				
				.from(t0).fetch();
		
		for(Ocrd o:bps)
		{
			System.out.println(o.getCardCode());
		}
	}

}
