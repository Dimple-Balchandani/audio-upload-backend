package com.vs.Syntoy.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vs.Syntoy.dbentities.UserEntity;
import com.vs.Syntoy.model.UserRequest;
import com.vs.Syntoy.services.UserService;
import com.vs.Syntoy.utilities.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping(Constants.USER_APIS)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = Constants.GET_USER_DESC)
	@RequestMapping(value = Constants.GET_API, method = RequestMethod.GET, produces = "application/json")
	public List<UserEntity> getUser(@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to get user.");
		return userService.getUser();
	}
	
	@ApiOperation(value = Constants.GET_USER_BY_ID_DESC)
	@RequestMapping(value = Constants.GET_BY_ID_API, method = RequestMethod.GET, produces = "application/json")
	public UserEntity getUserById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to get a user by id.");		
		return userService.findUserById(id);
	}
	
	@ApiOperation(value = Constants.ADD_USER_DESC)
	@RequestMapping(value = Constants.ADD_API, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void addUser(@ApiParam("user") @RequestBody UserRequest request, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to add a user.");
		userService.addUser(request);
	}
	
	@ApiOperation(value = Constants.DELETE_USER_DESC)
	@RequestMapping(value = Constants.DELETE_API, method = RequestMethod.DELETE, produces = "application/json")
	public void deleteUserById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to delete a user by id.");
		userService.deleteUser(id);
	}
	
	@ApiOperation(value = Constants.UPDATE_USER_DESC)
	@RequestMapping(value=Constants.UPDATE_API, method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateUser(@ApiParam("id") @PathVariable("id") long inputid, @ApiParam("user") @RequestBody UserRequest entity, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to update an user");
		userService.updateUser(inputid,entity);
	}


}
