package spring.jdbc.repository.repository;

import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository;
import org.springframework.data.mapping.PersistentEntity;


//@RequiredArgsConstructor
public class JdbcAddRepositoryImpl<T, ID>  implements JdbcAddRepository<T,ID>
{

	@Override
	public <S extends T> S add(S entity) 
	{
		return null;
	}
}
