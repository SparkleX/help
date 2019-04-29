package com.sap.b1.wcli.jdbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sap.b1.wcli.jpa.domain.entity.BmoOJDT;



@Repository
public interface RepoOJDT extends RepositoryBase<BmoOJDT, Integer>,RepoOJDTExt//, QuerydslBinderCustomizer<QBmoORDR>
{

//	@Query("from BmoODT")
//	List<BmoOJDT> findOpenDocument();

//	@Query(value = "select * from ORDR")
//	List<BmoOJDT> findWithUDF();
   /* @Override
    default public void customize(QuerydslBindings bindings, QBmoORDR root) {
        bindings.bind(String.class)
        .first((StringPath path, String  value) -> path.containsIgnoreCase(value));
    }*/
}
