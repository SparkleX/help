package help.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
@SuppressWarnings("rawtypes")
public class QuickEntityManager implements EntityManager {

	@Override
	public void persist(Object entity) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public <T> T merge(T entity) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public void remove(Object entity) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public <T> T getReference(Class<T> entityClass, Object primaryKey) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public void flush() {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public void setFlushMode(FlushModeType flushMode) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public FlushModeType getFlushMode() {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public void lock(Object entity, LockModeType lockMode) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public void refresh(Object entity) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public void refresh(Object entity, Map<String, Object> properties) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public void refresh(Object entity, LockModeType lockMode) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public void clear() {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public void detach(Object entity) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public boolean contains(Object entity) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public LockModeType getLockMode(Object entity) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public void setProperty(String propertyName, Object value) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public Map<String, Object> getProperties() {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public Query createQuery(String qlString) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public Query createQuery(CriteriaUpdate updateQuery) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public Query createQuery(CriteriaDelete deleteQuery) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public Query createNamedQuery(String name) {
		return new QuickQuery(name);
		
	}

	@Override
	public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public Query createNativeQuery(String sqlString) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public Query createNativeQuery(String sql, Class resultClass) {
		return new QuickQuery(sql, resultClass);
		
	}

	@Override
	public Query createNativeQuery(String sqlString, String resultSetMapping) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class... resultClasses) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public void joinTransaction() {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public boolean isJoinedToTransaction() {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public <T> T unwrap(Class<T> cls) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public Object getDelegate() {
		return this;
		
	}

	@Override
	public void close() 
	{


	}

	@Override
	public boolean isOpen() {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public EntityTransaction getTransaction() {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public Metamodel getMetamodel() {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public <T> EntityGraph<T> createEntityGraph(Class<T> rootType) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public EntityGraph<?> createEntityGraph(String graphName) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public EntityGraph<?> getEntityGraph(String graphName) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

	@Override
	public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {
		throw new RuntimeException("NOT IMPLEMENTED");
		
	}

}
