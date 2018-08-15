package com.mipa.admin.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mipa.core.exception.ObjectNotFoundException;

@ControllerAdvice
public class RootControllerAdvice {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ModelAndView handleObjectNotFoundExceotion() {
		ModelAndView view = new ModelAndView("object-not-found");
		view.setStatus(HttpStatus.ACCEPTED);
		return view;
	}

}