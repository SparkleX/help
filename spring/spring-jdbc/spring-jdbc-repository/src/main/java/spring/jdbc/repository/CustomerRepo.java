package spring.jdbc.repository;

import com.nurkiewicz.jdbcrepository.JdbcRepository;
@Repository
public class CustomerRepo extends JdbcRepository<Customer, String> {

}

public class UserRepository {

	public UserRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "USERS", "user_name");
	}

	public static final RowMapper<User> ROW_MAPPER = //...

	public static final RowUnmapper<User> ROW_UNMAPPER = //...

	@Override
	protected <S extends User> S postUpdate(S entity) {
		entity.setPersisted(true);
		return entity;
	}

	@Override
	protected <S extends User> S postCreate(S entity, Number generatedId) {
		entity.setPersisted(true);
		return entity;
	}
}