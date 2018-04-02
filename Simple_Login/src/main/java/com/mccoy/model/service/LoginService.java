package com.mccoy.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mccoy.dto.LoginDto;
import com.mccoy.model.dao.LoginDao;

@Service
public class LoginService {
	public LoginService() {

		System.out.println(this.getClass().getSimpleName());
	}

	@Autowired
	private LoginDao dao;

	public void createService(LoginDto dto) {
		System.out.println("createservice() is running.....");
		System.out.println("service id:"+dto.getId());

		dao.create(dto);
		System.out.println("createservice() is ended.....");
	}

	public LoginDto saveService(LoginDto dto) {
		System.out.println("saveService() is running.....");
		LoginDto fromDb = dao.save(dto);
		System.out.println("service id:"+fromDb.getId());
		if (fromDb != null) {
			System.out.println("entity exist");
		} else {
			System.out.println("entity not exist");
		}
		System.out.println("saveService() is ended.....");
		return fromDb;
	}
	
	public LoginDto saveService1(LoginDto dto) {
		System.out.println("saveService() is running.....");
		LoginDto fromDb = dao.save1(dto);
		System.out.println("service id:"+fromDb.getId());
		if (fromDb != null) {
			System.out.println("entity exist");
		} else {
			System.out.println("entity not exist");
		}
		System.out.println("saveService() is ended.....");
		return fromDb;
	}

	
	public void updateService(LoginDto dto)
	{
		System.out.println("update started");
		dao.updateDb(dto);
		System.out.println(" update service ended");
	}
	
	}
