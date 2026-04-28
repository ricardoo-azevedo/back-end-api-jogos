package com.backend.apiJogos.exceptionHandler.formatter;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RestErrorMensagem {

  private int status;

  private String mensagem;

}
