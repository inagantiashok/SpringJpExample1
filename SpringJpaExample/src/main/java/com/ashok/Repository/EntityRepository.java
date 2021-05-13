package com.ashok.Repository;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashok.Exceptions.NESLException;
import com.ashok.entity.Roles;

@Repository
public class EntityRepository {

	@Autowired
	private EntityManager manager;

	public String getRolesdata() throws NESLException {
		List resultList = null;
		try {
			Query query = manager.createNativeQuery("SELECT * FROM ROLE");
			resultList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NESLException("problem While Retriving Results");
		}
		for (int i = 0; i < resultList.size(); i++) {
			Object[] objData = (Object[]) resultList.get(i);
			System.out.println(objData[1].toString());
		}
		return "true";
	}
	
	@SuppressWarnings("unchecked")
	public String getRolesdata1() throws NESLException {
		try {
		    Query query = manager.createNativeQuery("SELECT * FROM ROLE1",Roles.class);
		    Stream<Roles> streamrst = query.getResultStream();
		    streamrst.forEach(c->System.out.println(c.getDescription()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new NESLException("problem While Retriving Results");
		}
		
		return "true";
	}
	
    @Transactional
	public String getSequence() throws NESLException {
		String singleResult;
		try {
			Query createNativeQuery = manager.createNativeQuery("select nextval from dual");
			singleResult = (String) createNativeQuery.getSingleResult();
		} catch (Exception e) {			
			e.printStackTrace();
			throw new NESLException("problem While Retriving Results");
		}
		return singleResult;
	}
}
