package spring.jdbc.repository.repository;

import java.util.Optional;

import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


public class JdbcRepositoryImpl<T,ID> 
extends SimpleJdbcRepository<T,ID> implements JdbcRepository<T,ID>
{
	public JdbcRepositoryImpl(JdbcAggregateOperations entityOperations,
			PersistentEntity<T, ?> entity) {
		super(entityOperations, entity);
	}

	@Override
	public <S extends T> S add(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
