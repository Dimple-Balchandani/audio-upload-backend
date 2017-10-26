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

import com.vs.Syntoy.dbentities.NotesEntity;
import com.vs.Syntoy.model.NotesRequest;
import com.vs.Syntoy.services.NotesService;
import com.vs.Syntoy.utilities.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping(Constants.NOTES_APIS)
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class NotesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotesController.class.getName());

	@Autowired
	private NotesService noteService;

	@ApiOperation(value = Constants.GET_NOTES_DESC)
	@RequestMapping(value = Constants.GET_API, method = RequestMethod.GET, produces = "application/json")
	public List<NotesEntity> getNotes(@ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to get note.");
		return noteService.getNotes();
	}

	@ApiOperation(value = Constants.GET_NOTES_BY_ID_DESC)
	@RequestMapping(value = Constants.GET_BY_ID_API, method = RequestMethod.GET, produces = "application/json")
	public NotesEntity getNotesById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to get a note by id.");
		return noteService.findNoteById(id);
	}

	@ApiOperation(value = Constants.ADD_NOTES_DESC)
	@RequestMapping(value = Constants.ADD_API, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void addNotes(@ApiParam("notes") @RequestBody NotesRequest request, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to add a note.");
		noteService.addNote(request);
	}

	@ApiOperation(value = Constants.DELETE_NOTES_DESC)
	@RequestMapping(value = Constants.DELETE_API, method = RequestMethod.DELETE, produces = "application/json")
	public void deleteNotesById(@ApiParam("id") @PathVariable("id") long id, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken) {
		LOGGER.debug("Received request to delete a note by id.");
		noteService.deleteNote(id);
	}
	
	@ApiOperation(value = Constants.UPDATE_NOTES_DESC)
	@RequestMapping(value=Constants.UPDATE_API, method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateNotes(@ApiParam("id") @PathVariable("id") long inputid, @ApiParam("notes") @RequestBody NotesRequest entity, @ApiParam(Constants.AUTH_DESC) @RequestHeader(Constants.AUTHORIZATION) String authToken){
		LOGGER.debug("Received request to update a note");
		noteService.updateNote(inputid,entity);
	}

}