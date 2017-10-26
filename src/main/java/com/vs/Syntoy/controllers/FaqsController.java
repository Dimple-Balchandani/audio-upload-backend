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
import com.vs.Syntoy.dbentities.FAQsEntity;
import com.vs.Syntoy.model.FAQsRequest;
import com.vs.Syntoy.services.FAQsService;
import com.vs.Syntoy.utilities.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping(Constants.FAQS_APIS)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class FaqsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FaqsController.class.getName());
	
	@Autowired
	private FAQsService FAQsService;
	
	@ApiOperation(value = Constants.GET_FAQs_DESC)
	@RequestMapping(value = Constants.GET_API, method = RequestMethod.GET, produces = "application/json")
	public List<FAQsEntity> getFAQs(@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to get FAQs.");
		return FAQsService.getFAQ();
	}
	
	@ApiOperation(value = Constants.GET_FAQs_BY_ID_DESC)
	@RequestMapping(value = Constants.GET_BY_ID_API, method = RequestMethod.GET, produces = "application/json")
	public FAQsEntity getFAQsById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to get a FAQ by id.");		
		return FAQsService.findFAQById(id);
	}
	
	@ApiOperation(value = Constants.ADD_FAQs_DESC)
	@RequestMapping(value = Constants.ADD_API, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void addFAQs(@ApiParam("FAQ") @RequestBody FAQsRequest request, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to add a FAQ.");
		FAQsService.addFAQ(request);
	}
	
	@ApiOperation(value = Constants.DELETE_FAQs_DESC)
	@RequestMapping(value = Constants.DELETE_API, method = RequestMethod.DELETE, produces = "application/json")
	public void deleteFAQsById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to delete a FAQ by id.");
		FAQsService.deleteFAQ(id);
	}
	
	@ApiOperation(value = Constants.UPDATE_FAQs_DESC)
	@RequestMapping(value=Constants.UPDATE_API, method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateFAQs(@ApiParam("id") @PathVariable("id") long inputid, @ApiParam("FAQ") @RequestBody FAQsRequest entity, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to update an FAQ");
		FAQsService.updateFAQ(inputid,entity);
	}


}
