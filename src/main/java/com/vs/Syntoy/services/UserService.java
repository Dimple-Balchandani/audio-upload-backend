package com.vs.Syntoy.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.Syntoy.dao.UserDao;
import com.vs.Syntoy.dbentities.UserEntity;
import com.vs.Syntoy.model.UserRequest;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserDao obj;
	
	public void addUser(UserRequest request){
		UserEntity entity = new UserEntity(request);
		obj.addUser(entity);
	}
	
	public List<UserEntity> getUser(){
		return obj.listUsers();
	}
	
	public UserEntity findUserById(Long id){
		return obj.findById(id);
	}
	
	public void deleteUser(Long id){
		obj.deleteUser(id);
	}
	
	public void updateUser(Long id, UserRequest entity){
		UserEntity user = new UserEntity(entity);
		user.setId(id);
		obj.updateUser(id, user);
	}
}
