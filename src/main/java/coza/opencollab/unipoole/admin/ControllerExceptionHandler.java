package coza.opencollab.unipoole.admin;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * This is a ControllerAdvice for exception handling.
 * 
 * @author OpenCollab
 * @since 1.0.0
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    /**
     * Handles all types of exceptions.
     * 
     * @param e The exception to handle
     * @return The model and view
     */
    @ExceptionHandler
    public ModelAndView handle(Exception e, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("exception-handler");    
        modelAndView.addObject("exceptionRequest", request.getRequestURL().toString());
        modelAndView.addObject("exceptionMessage", e.getLocalizedMessage());
        modelAndView.addObject("exceptionType", e.getClass().getSimpleName());
        if(e.getCause() != null){
            modelAndView.addObject("exceptionCauseMessage", e.getCause().getLocalizedMessage());
            modelAndView.addObject("exceptionCauseType", e.getCause().getClass().getSimpleName());
        }
        return modelAndView;
    }
}
