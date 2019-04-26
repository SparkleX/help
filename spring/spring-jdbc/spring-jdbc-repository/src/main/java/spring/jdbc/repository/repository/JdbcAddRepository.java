package spring.jdbc.repository.repository;

import org.springframework.data.jdbc.repository.query.Query;

public interface JdbcAddRepository<T,ID>
{
	@Query(value = "")
	public <S extends T> S add(S entity);
}
