package spring.jdbc.repository.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
//@NoRepositoryBean
public interface JdbcRepository<T,ID> extends /*JdbcAddRepository<T,ID>,*/ CrudRepository<T,ID>  {
	public <S extends T> S add(S entity);
}
