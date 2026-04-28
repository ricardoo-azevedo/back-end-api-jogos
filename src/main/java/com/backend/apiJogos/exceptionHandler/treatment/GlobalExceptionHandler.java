package com.backend.apiJogos.exceptionHandler.treatment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.backend.apiJogos.exceptionHandler.exceptions.UserJaCadastradoException;
import com.backend.apiJogos.exceptionHandler.formatter.RestErrorMensagem;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private ResponseEntity<RestErrorMensagem> criarResposta(HttpStatus status, String mensagem) {
    return ResponseEntity.status(status).body(new RestErrorMensagem(status.value(), mensagem));
  }

  @ExceptionHandler(UserJaCadastradoException.class)
  ResponseEntity<RestErrorMensagem> UserJaCadastradoExcepition(UserJaCadastradoException ex) {
    return criarResposta(HttpStatus.CONFLICT, ex.getMessage());
  }

}
