package help.mybatis.repo;

import java.util.List;

public interface MapperBase<T,ID> {
	List<T> findAll();
	T findById(ID id);
	void insert(T object);
	
	void update(ID id, T object);
}
