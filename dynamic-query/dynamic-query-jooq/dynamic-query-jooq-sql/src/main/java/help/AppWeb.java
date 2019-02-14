package help;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.example.db.h2.Tables;
import org.jooq.example.db.h2.tables.Ocrd;
import org.jooq.example.db.h2.tables.records.OcrdRecord;
import org.jooq.impl.DSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppWeb
{
	public static void main(String[] args)
	{
		SpringApplication.run(AppWeb.class, args);
	    DSLContext create = DSL.using("jdbc:mysql://localhost:3306/test100?serverTimezone=UTC", "root", "1234");
	    Ocrd b = Tables.OCRD.as("b");

        Result<OcrdRecord> result =
        create.selectFrom(b)
              .fetch();
        System.out.println(result.get(0).getCardcode());
	    
	}
}
