package com.mccoy.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mccoy.dto.LoginDto;

@Repository
public class LoginDao {

	public LoginDao() {
		System.out.println(this.getClass().getSimpleName());
	}

	@Autowired
	private SessionFactory factory;

	public void create(LoginDto dto) {
		System.out.println("create() method is running");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			System.out.println("daoid:"+dto.getId());
			session.save(dto);
			tx.commit();
			

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			tx.rollback();
		}
		finally {
			session.close();
		}
		System.out.println("create() method is ended");
	}
	public LoginDto save(LoginDto dto) 
	{
		System.out.println("read() method is running");
		Session session=factory.openSession();
		Query qry=session.createQuery("select e from LoginDto e where e.id=:id and e.pass=:pass");
		qry.setParameter("id", dto.getId());
		qry.setParameter("pass",dto.getPass());
		LoginDto fromDb=(LoginDto)qry.uniqueResult();
		if(fromDb!=null)
		{
			System.out.println("entity exist"+fromDb.getName());
		}
		else
		{
			System.out.println("entity not exist");
		}
		System.out.println("read() method is ended");
		return fromDb;
	}
	
	public LoginDto save1(LoginDto dto) 
	{
		System.out.println("read() method is running");
		Session session=factory.openSession();
		Query qry=session.createQuery("select e from LoginDto e where e.id=:id ");
		qry.setParameter("id", dto.getId());
		LoginDto fromDb=(LoginDto)qry.uniqueResult();
		if(fromDb!=null)
		{
			System.out.println("entity exist"+fromDb.getName());
		}
		else
		{
			System.out.println("entity not exist");
		}
		System.out.println("read() method is ended");
		return fromDb;
	}
	
	public void updateDb(LoginDto dto)
	{
		Session session=factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("emai1="+dto.getEmail());
		

		/*Query qry=session.createQuery("update LoginDto e  set e.name=:name1 ,e.pass=:pass1, e.email=:email1 where e.id=:id1");
		qry.setParameter("id1", dto.getId());
		qry.setParameter("pass1",dto.getPass());
		qry.setParameter("name1",dto.getName());
		qry.setParameter("email1",dto.getEmail());
		
		int res=qry.executeUpdate();
		
	
		if(res>=1) {
			System.out.println("updated");
		}
		else
		{
			System.out.println("not updated");
		}*/
		
		Query qry=session.createQuery("select e from LoginDto e where e.id=:id ");
		qry.setParameter("id", dto.getId());
		//qry.setParameter("pass",dto.getPass());
		LoginDto fromDb=(LoginDto)qry.uniqueResult();
		if(fromDb!=null)
		{
			System.out.println("entity exist"+fromDb.getName());
			fromDb=(LoginDto) session.merge(dto);
			System.out.println("new db="+fromDb.getName());
			session.save(fromDb);
			tx.commit();
		}
		else
		{
			System.out.println("entity not exist");
		}
	}

}
