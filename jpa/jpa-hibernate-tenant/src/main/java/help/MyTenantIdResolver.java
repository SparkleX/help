package help;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class MyTenantIdResolver implements CurrentTenantIdentifierResolver
{
	public MyTenantIdResolver()
	{
		System.out.println("123");
	}
	@Override
	public String resolveCurrentTenantIdentifier() 
	{
		return "T1.dbo";
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		// TODO Auto-generated method stub
		return false;
	}

}
