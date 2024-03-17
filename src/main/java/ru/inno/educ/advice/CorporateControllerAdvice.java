package ru.inno.educ.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.inno.educ.exception.AlreadyExistException;
import ru.inno.educ.exception.NoDataFoundException;
import ru.inno.educ.model.ErrorResponse;

import java.util.Objects;

@ControllerAdvice
@Slf4j
public class CorporateControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException exception){
        var response = new ErrorResponse();

        StringBuilder sb = new StringBuilder("Имя обязательного параметра");
        for(
                ObjectError error : exception.getBindingResult().getAllErrors()
        ){
            for(Object dmsr : Objects.requireNonNull(error.getArguments())){
                if (dmsr instanceof DefaultMessageSourceResolvable){
                    sb.append(" <")
                            .append(((DefaultMessageSourceResolvable) dmsr).getDefaultMessage())
                            .append("> ");
                }
            }
            sb.append(error.getDefaultMessage())
                    .append("; ");
        }

        response.setErrorMessage(sb.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistsException(AlreadyExistException exception){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(exception.getMessage()));

    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoDataFoundException(NoDataFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(exception.getMessage()));

    }
}
