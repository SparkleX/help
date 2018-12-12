package help.jpa;

import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickEntityTransaction implements EntityTransaction
{
	static Logger logger = LoggerFactory.getLogger(QuickEntityTransaction.class);
	QuickEntityTransaction()
	{
		logger.info("QuickEntityTransaction:ctor");
	}
	@Override
	public void begin() 
	{
		logger.info("QuickEntityTransaction:begin");
		
	}

	@Override
	public void commit() {
		logger.info("QuickEntityTransaction:commit");
		
	}

	@Override
	public void rollback() {
		logger.info("QuickEntityTransaction:rollback");
		
	}

	@Override
	public void setRollbackOnly() {
		logger.info("QuickEntityTransaction:setRollbackOnly");
		
	}

	@Override
	public boolean getRollbackOnly() {
		logger.info("QuickEntityTransaction:getRollbackOnly");
		return false;
	}

	@Override
	public boolean isActive() {
		logger.info("QuickEntityTransaction:isActive");
		return false;
	}

}
