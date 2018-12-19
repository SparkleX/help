package help;

import java.util.Map;

import org.eclipse.persistence.jpa.metadata.MetadataSourceAdapter;
import org.eclipse.persistence.logging.SessionLog;

public class MetaRepo extends MetadataSourceAdapter
{

	@Override
	public Map<String, Object> getPropertyOverrides(Map<String, Object> arg0, ClassLoader arg1, SessionLog arg2) 
	{
		
		return null;
	}

}
