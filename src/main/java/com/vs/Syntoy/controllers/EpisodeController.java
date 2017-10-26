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
import com.vs.Syntoy.dbentities.EpisodeEntity;
import com.vs.Syntoy.model.EpisodeRequest;
import com.vs.Syntoy.model.ResponseModel;
import com.vs.Syntoy.services.EpisodeService;
import com.vs.Syntoy.utilities.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(Constants.EPISODE_APIS)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class EpisodeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EpisodeController.class.getName());
	
	@Autowired
	private EpisodeService episodeService;
	
	@ApiOperation(value = Constants.GET_EPISODE_DESC)
	@RequestMapping(value = Constants.GET_API, method = RequestMethod.GET, produces = "application/json")
	public List<EpisodeEntity> getEpisode(@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to get episode.");
		return episodeService.getEpisode();
	}

	@ApiOperation(value = Constants.GET_EPISODE_BY_ID_DESC)
	@RequestMapping(value = Constants.GET_BY_ID_API, method = RequestMethod.GET, produces = "application/json")
	public EpisodeEntity getEpisodeById(@ApiParam("id")@PathVariable("id") long id,@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to get a episode by id.");	
		return episodeService.findEpisodeById(id);
	}
	
	@ApiOperation(value = Constants.ADD_EPISODE_DESC)
	@RequestMapping(value = Constants.ADD_API, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseModel addEpisode(@ApiParam("episode") @RequestBody EpisodeRequest request, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to add a episode.");
		if(episodeService.addEpisode(request)){
			ResponseModel responseModel = new ResponseModel(200, "success");
			return responseModel;
		} else{
			ResponseModel responseModel = new ResponseModel(404, "failure");
			return responseModel;
		}
	}
	
	@ApiOperation(value = Constants.DELETE_EPISODE_DESC)
	@RequestMapping(value = Constants.DELETE_API, method = RequestMethod.DELETE, produces = "application/json")
	public void deleteEpisodeById(@ApiParam("id") @PathVariable("id") long id,@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to delete a episode by id.");
		episodeService.deleteEpisode(id);
	}
	
	
	@ApiOperation(value = Constants.UPDATE_EPISODE_DESC)
	@RequestMapping(value=Constants.UPDATE_API, method=RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public void updateEpisode(@ApiParam("id") @PathVariable("id") long inputid, @ApiParam("episode") @RequestBody EpisodeRequest entity,@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to update an episode");
		episodeService.updateEpisode(inputid,entity);
	}
}
