package com.amruta.mykarsol.projectmykarsol.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice

public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "errorPage";  // Create an errorPage.jsp to display the error message
    }

}
