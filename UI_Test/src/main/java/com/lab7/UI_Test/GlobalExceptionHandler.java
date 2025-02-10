package com.lab7.UI_Test;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResoruceNotFoundException.class)
    public String handleResourceNotFoundException(ResoruceNotFoundException ex, Model model)
    {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model)
    {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}
