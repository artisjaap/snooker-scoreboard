package be.qnh.gertronic.snooker.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RedirectOnResourceNotFoundException {

    @ExceptionHandler(value = Throwable.class)
    public Object handleStaticResourceNotFound( HttpServletRequest req, RedirectAttributes redirectAttributes) {
        return "";
    }

    private ResponseEntity<String> getApiResourceNotFoundBody(NoHandlerFoundException ex, HttpServletRequest req) {
        return new ResponseEntity<>("Not Found !!", HttpStatus.NOT_FOUND);
    }
}