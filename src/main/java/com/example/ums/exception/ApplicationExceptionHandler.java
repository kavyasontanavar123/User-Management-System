package com.example.ums.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice// It act as an exit point for exception
public class ApplicationExceptionHandler {
	
	@ExceptionHandler
	public String handlUserNotFoundById(UserNotFoundByIdException ex,Model model) {
		model.addAttribute("errorMessage",ex.getMessage());
		model.addAttribute("redirectTo",ex.getRedirectTo());
		
		return "error.jsp";
		
	}

}
