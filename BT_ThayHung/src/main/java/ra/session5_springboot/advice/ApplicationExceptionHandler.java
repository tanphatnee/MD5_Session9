package ra.session5_springboot.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ra.session5_springboot.exception.UserException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // cho pheps can thiep cao qua trinh tiep nhan request neu xay ra exception
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> invalidRequest(MethodArgumentNotValidException ex){
       Map<String,String> err = new HashMap<>();
       ex.getBindingResult().getFieldErrors().forEach(c->{
           err.put(c.getField(),c.getDefaultMessage());
       });
       return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserException.class)
    public String existed(UserException e){
        return e.getMessage();
    }
}
