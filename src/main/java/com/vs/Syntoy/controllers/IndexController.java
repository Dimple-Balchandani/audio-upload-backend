package com.vs.Syntoy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vs.Syntoy.utilities.Constants;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping(value = "index")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class IndexController {
	
	@ApiOperation(value = Constants.MAIN_DESCRIPTION)
	
	@RequestMapping(value = "/")
	public String hello() {
		return "index";
	}
}
