package com.vs.Syntoy.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vs.Syntoy.authentication.AccountCredentials;
import com.vs.Syntoy.dbentities.AdminEntity;
import com.vs.Syntoy.model.AdminRequest;
import com.vs.Syntoy.model.ResponseModel;
import com.vs.Syntoy.services.AdminService;
import com.vs.Syntoy.utilities.Constants;


@RestController
@RequestMapping(Constants.ADMIN_APIS)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class AdminController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class.getName());
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = Constants.GET_API, method = RequestMethod.GET)
	public List<AdminEntity> getAdmin(){
		LOGGER.debug("Received request to get admin.");
		return adminService.getAdmin();
	}
	
	@RequestMapping(value = Constants.GET_BY_ID_API, method = RequestMethod.GET)
	public AdminEntity getAdminById(@PathVariable("id") long id){
		LOGGER.debug("Received request to get a admin by id.");		
		return adminService.findAdminById(id);
	}
	
//	@RequestMapping(value = Constants.ADD_API, method = RequestMethod.POST)
//	public void addAdmin(@RequestBody AdminRequest request){
//		LOGGER.debug("Received request to add a admin.");
//		adminService.addAdmin(request);
//	}
	
//	@RequestMapping(value = Constants.DELETE_API, method = RequestMethod.DELETE)
//	public void deleteAdminById(@RequestParam("id") long id){
//		LOGGER.debug("Received request to delete a admin by id.");
//		adminService.deleteAdmin(id);
//	}
	
//	@RequestMapping(value=Constants.UPDATE_API, method=RequestMethod.PUT)
//	public void updateAdmin(@PathVariable("id") long inputid, @RequestBody AdminEntity entity){
//		LOGGER.debug("Received request to update an admin");
//		adminService.updateAdmin(inputid,entity);
//	}
	
	@RequestMapping(value = Constants.LOGIN_API, method = RequestMethod.POST)
	public ResponseModel loginAdmin(@RequestBody AccountCredentials request){
		LOGGER.debug("Received request to login");
		ResponseModel responseModel = new ResponseModel(200, "success");
		System.out.println(responseModel.getMessage() + " " + responseModel.getStatusCode());
		return responseModel;
	//		return new ResponseModel(HttpStatus.ACCEPTED.value(), "Category updated");	
	}

}
