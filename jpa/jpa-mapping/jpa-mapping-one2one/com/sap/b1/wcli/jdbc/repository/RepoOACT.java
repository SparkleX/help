package com.sap.b1.wcli.jdbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sap.b1.wcli.jpa.domain.entity.BmoOACT;


@Repository
public interface RepoOACT extends RepositoryBase<BmoOACT, Integer>//, QuerydslBinderCustomizer<QBmoORDR>
{
	
//	@Query("select * from OCRD where CardType='C'")
//	List<BmoOACT> findCustomers();
   /* @Override
    default public void customize(QuerydslBindings bindings, QBmoORDR root) {
        bindings.bind(String.class)
        .first((StringPath path, String  value) -> path.containsIgnoreCase(value));
    }*/
	
	
}
