package help.tenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver 
{
    public static final String DEFAULT_TENANT_ID = "test100";
	@Override
    public String resolveCurrentTenantIdentifier() 
    {
        String tenantId = TenantContext.getCurrentTenant();
        if (tenantId != null) {
            return tenantId;
        }
        return DEFAULT_TENANT_ID;
    }
    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}