package com.backend.apiJogos.exceptionHandler.exceptions;

public class UserJaCadastradoException extends RuntimeException {

  public UserJaCadastradoException() {
    super("Este nome ja esta em uso!!!");
  }

  public UserJaCadastradoException(String mensagem) {
    super(mensagem);

  }

}
