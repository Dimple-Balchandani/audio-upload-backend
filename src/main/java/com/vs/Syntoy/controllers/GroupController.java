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

import com.vs.Syntoy.dbentities.GroupEntity;
import com.vs.Syntoy.model.GroupRequest;
import com.vs.Syntoy.model.ResponseModel;
import com.vs.Syntoy.services.GroupService;
import com.vs.Syntoy.utilities.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(Constants.GROUP_APIS)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class GroupController {
	private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class.getName());

	@Autowired
	private GroupService grpService;
	
	@ApiOperation(value = Constants.GET_GROUP_DESC)
	@RequestMapping(value = Constants.GET_API, method = RequestMethod.GET, produces = "application/json")
	public List<GroupEntity> getGroup(@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to get group.");
		return grpService.getGroup();
	}
	
	@ApiOperation(value = Constants.GET_GROUP_BY_ID_DESC)
	@RequestMapping(value = Constants.GET_BY_ID_API, method = RequestMethod.GET, produces = "application/json")
	public GroupEntity getGroupById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to get a group by id.");		
		return grpService.findGroupById(id);
	}
	
	@ApiOperation(value = Constants.ADD_GROUP_DESC)
	@RequestMapping(value = Constants.ADD_API, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseModel addGroup(@ApiParam("group") @RequestBody GroupRequest request, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to add a group.");
		Long groupId = grpService.addGroup(request);
		ResponseModel responseModel = new ResponseModel(200, ""+groupId);
		return responseModel;
	}
	
	@ApiOperation(value = Constants.DELETE_GROUP_DESC)
	@RequestMapping(value = Constants.DELETE_API, method = RequestMethod.DELETE, produces = "application/json")
	public void deleteGroupById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to delete a group by id.");
		grpService.deleteGroup(id);
	}
	
	@ApiOperation(value = Constants.UPDATE_GROUP_DESC)
	@RequestMapping(value=Constants.UPDATE_API, method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateGroup(@ApiParam("id") @PathVariable("id") long inputid, @ApiParam("group") @RequestBody GroupRequest entity, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to update an group");
		grpService.updateGroup(inputid,entity);
	}
	
}
