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

import com.vs.Syntoy.dbentities.QuestionEntity;
import com.vs.Syntoy.model.QuestionRequest;
import com.vs.Syntoy.model.ResponseModel;
import com.vs.Syntoy.services.QuestionService;
import com.vs.Syntoy.utilities.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(Constants.QUESTION_APIS)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class QuestionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class.getName());

	@Autowired
	private QuestionService quesService;
	
	@ApiOperation(value = Constants.GET_QUESTION_DESC)
	@RequestMapping(value = Constants.GET_API, method = RequestMethod.GET, produces = "application/json")
	public List<QuestionEntity> getQuestion(@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to get question.");
		return quesService.getQuestion();
	}
	
	@ApiOperation(value = Constants.GET_QUESTION_BY_ID_DESC)
	@RequestMapping(value = Constants.GET_BY_ID_API, method = RequestMethod.GET, produces = "application/json")
	public QuestionEntity getQuestionById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to get a question by id.");		
		return quesService.findQuestionById(id);
	}
	
	@ApiOperation(value = Constants.ADD_QUESTION_DESC)
	@RequestMapping(value = Constants.ADD_API, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseModel addQuestion(@ApiParam("question") @RequestBody QuestionRequest request, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to add a question.");
		
		Long questionId = quesService.addQuestion(request);
		ResponseModel responseModel = new ResponseModel(200, ""+questionId);
		return responseModel;
	}
	
	@ApiOperation(value = Constants.DELETE_QUESTION_DESC)
	@RequestMapping(value = Constants.DELETE_API, method = RequestMethod.DELETE,produces = "application/json")
	public void deleteQuestionById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to delete a question by id.");
		quesService.deleteQuestion(id);
	}
	
	@ApiOperation(value = Constants.UPDATE_QUESTION_DESC)
	@RequestMapping(value=Constants.UPDATE_API, method=RequestMethod.PUT,consumes = "application/json", produces = "application/json")
	public void updateQuestion(@ApiParam("id") @PathVariable("id") long inputid, @ApiParam("question") @RequestBody QuestionRequest entity, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to update a question");
		quesService.updateQuestion(inputid,entity);
	}
	
}
