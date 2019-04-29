package com.sap.b1.wcli.jdbc.repository;

import java.util.List;
import com.sap.b1.wcli.jpa.domain.entity.BmoOJDT;


public interface RepoOJDTExt
{
	List<BmoOJDT> findSingleLineOrder();
}
