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
import com.vs.Syntoy.dbentities.SnippetEntity;
import com.vs.Syntoy.model.SnippetRequest;
import com.vs.Syntoy.services.SnippetService;
import com.vs.Syntoy.utilities.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(Constants.SNIPPET_APIS)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class SnippetController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SnippetController.class.getName());

	@Autowired
	private SnippetService snippetService;

	@ApiOperation(value = Constants.GET_SNIPPET_DESC)
	@RequestMapping(value = Constants.GET_API, method = RequestMethod.GET, produces = "application/json")
	public List<SnippetEntity> getSnippet(@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to get snippet.");
		return snippetService.getSnippet();
	}

	@ApiOperation(value = Constants.GET_SNIPPET_DESC)
	@RequestMapping(value = Constants.GET_BY_ID_API, method = RequestMethod.GET, produces = "application/json")
	public SnippetEntity getSnippetById(@ApiParam("id") @PathVariable("id") long id,@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to get a snippet by id.");
		return snippetService.findSnippetById(id);
	}

	@ApiOperation(value = Constants.GET_SNIPPET_DESC)
	@RequestMapping(value = Constants.ADD_API, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void addSnippet(@ApiParam("snippet") @RequestBody SnippetRequest request,@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to add a snippet.");
		snippetService.addSnippet(request);
	}

	@ApiOperation(value = Constants.GET_SNIPPET_DESC)
	@RequestMapping(value = Constants.DELETE_API, method = RequestMethod.DELETE, produces = "application/json")
	public void deleteSnippetById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to delete a snippet by id.");
		snippetService.deleteSnippet(id);
	}
	
	@ApiOperation(value = Constants.GET_SNIPPET_DESC)
	@RequestMapping(value=Constants.UPDATE_API, method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateSnippet(@ApiParam("id") @PathVariable("id") long inputid, @ApiParam("snippet") @RequestBody SnippetRequest entity, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to update a snippet");
		snippetService.updateSnippet(inputid,entity);
	}
	
	

}
