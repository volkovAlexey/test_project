package ua.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.exceptions.DataNotFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    public ErrorInfo handleItemNotFound(HttpServletRequest req, Exception ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo general(HttpServletRequest req, Exception ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }
}
