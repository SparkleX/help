package com.sap.b1.wcli.jdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sap.b1.wcli.jpa.domain.entity.BmoOJDT;

public class RepoOJDTImpl implements RepoOJDTExt
{
	@Autowired
    RepoOJDT repoOJDT;

	//@Autowired
   // EntityManager em;
	@Override
	public List<BmoOJDT> findSingleLineOrder()
	{
		/*SQLQuery<BmoORDR> query = new SQLQuery<BmoORDR>((Connection)null, (SQLTemplates)null); 
		QBmoOrdr tORDR = QBmoOrdr.ordr;
		QBmoOcrd tOCRD = QBmoOcrd.ocrd;

		SQLQuery<QBmoOcrd> subQuery = SQLExpressions.selectFrom(tOCRD) .where(tOCRD.cardCode.startsWith("C2"));
		
		List<BmoORDR> oOrder = query.select(tORDR)
				.from(tORDR)
				.where(tORDR.cardCode.in(subQuery.select(tOCRD.cardCode)))
				.orderBy(tORDR.docEntry.desc()).fetch();

		return oOrder;*/
		return null;
	}
}
