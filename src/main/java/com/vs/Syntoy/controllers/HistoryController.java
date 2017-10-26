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

import com.vs.Syntoy.dbentities.HistoryEntity;
import com.vs.Syntoy.model.HistoryRequest;
import com.vs.Syntoy.services.HistoryService;
import com.vs.Syntoy.utilities.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping(Constants.HISTORY_APIS)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class HistoryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HistoryController.class.getName());

	@Autowired
	private HistoryService historyService;

	@ApiOperation(value = Constants.GET_HISTORY_DESC)
	@RequestMapping(value = Constants.GET_API, method = RequestMethod.GET, produces = "application/json")
	public List<HistoryEntity> getHistory(@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to get history.");
		return historyService.getHistory();
	}

	@ApiOperation(value = Constants.GET_HISTORY_BY_ID_DESC)
	@RequestMapping(value = Constants.GET_BY_ID_API, method = RequestMethod.GET, produces = "application/json")
	public HistoryEntity getHistoryById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to get a history by id.");
		return historyService.findHistoryById(id);
	}
	
	@ApiOperation(value = Constants.ADD_HISTORY_DESC)
	@RequestMapping(value = Constants.ADD_API, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void addHistory(@ApiParam("history") @RequestBody HistoryRequest request, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to add a history.");
		historyService.addHistory(request);
	}

	@ApiOperation(value = Constants.DELETE_HISTORY_DESC)
	@RequestMapping(value = Constants.DELETE_API, method = RequestMethod.DELETE, produces = "application/json")
	public void deleteHistoryById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to delete a history by id.");
		historyService.deleteHistory(id);
	}
	
	@ApiOperation(value = Constants.UPDATE_HISTORY_DESC)
	@RequestMapping(value=Constants.UPDATE_API, method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateHistory(@ApiParam("id") @PathVariable("id") long inputid, @ApiParam("history") @RequestBody HistoryRequest entity, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to update a history");
		//historyService.updateHistory(inputid,entity);
	}

}