package help.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
@SuppressWarnings("rawtypes")
public class QuickEntityManagerFactory implements EntityManagerFactory {

	@Override
	public EntityManager createEntityManager() {
		return new QuickEntityManager();
	}

	
	@Override
	public EntityManager createEntityManager(Map map) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public EntityManager createEntityManager(SynchronizationType synchronizationType) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public EntityManager createEntityManager(SynchronizationType synchronizationType, Map map) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public Metamodel getMetamodel() {
		return new QuickMetamodel();
	}

	@Override
	public boolean isOpen() {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public void close() {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public Map<String, Object> getProperties() {
		return new HashMap<String, Object>();
	}

	@Override
	public Cache getCache() {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public PersistenceUnitUtil getPersistenceUnitUtil() {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public void addNamedQuery(String name, Query query) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public <T> T unwrap(Class<T> cls) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public <T> void addNamedEntityGraph(String graphName, EntityGraph<T> entityGraph) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

}
