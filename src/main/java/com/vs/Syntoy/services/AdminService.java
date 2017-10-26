package com.vs.Syntoy.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.Syntoy.dao.AdminDao;
import com.vs.Syntoy.dbentities.AdminEntity;
import com.vs.Syntoy.model.AdminRequest;

@Transactional
@Service
public class AdminService {

	
	@Autowired
	private AdminDao adminDao;
	
	public void addAdmin(AdminRequest admin){
		AdminEntity obj = new AdminEntity(admin);
		adminDao.addAdmin(obj);
	}
	
	public List<AdminEntity> getAdmin(){
		return adminDao.listAdmins();
	}
	
	public AdminEntity findAdminById(Long id){
		return adminDao.findById(id);
	}
	
	public void deleteAdmin(Long id){
		adminDao.deleteAdmin(id);
	}
	
	public void updateAdmin(Long id, AdminEntity entity){
		adminDao.updateAdmin(id, entity);
	}
}
