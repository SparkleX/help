package help;

import java.sql.Connection;
import java.sql.SQLException;

import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.springframework.stereotype.Component;
@Component
public class MyInitCallback implements Callback
{

	@Override
	public boolean canHandleInTransaction(Event evt, Context ctx)
	{
		return true;
	}

	@Override
	public void handle(Event evt, Context ctx)
	{
		try
		{
			Connection conn = ctx.getConnection();
			conn.createStatement();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public boolean supports(Event evt, Context ctx)
	{
		if(evt.equals(Event.BEFORE_MIGRATE))
		{
			return true;
		}
		return false;
	}

}
