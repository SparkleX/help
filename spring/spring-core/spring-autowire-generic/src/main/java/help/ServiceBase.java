package help;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceBase<T_BoBase extends BoBase<?>>
{
	@Autowired
	T_BoBase businessObject;

}
