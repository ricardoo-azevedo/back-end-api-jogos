package com.backend.apiJogos.services.impls;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.backend.apiJogos.dtos.UserDto;
import com.backend.apiJogos.exceptionHandler.exceptions.UserJaCadastradoException;
import com.backend.apiJogos.models.User;
import com.backend.apiJogos.repositorys.UserRepository;
import com.backend.apiJogos.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{
  private final UserRepository userRepository;

 public UserServiceImpl(UserRepository userRepository){
    this.userRepository = userRepository;
 }
  @Override
  public UserDto criarUsuario(UserDto userDto){

    if(userRepository.existsByNome(userDto.getNome())){
      throw new UserJaCadastradoException();
    }

    User user = new User(userDto.getNome());
    userRepository.save(user);

    return new UserDto(user.getId(), user.getNome());
  }
  @Override
  public List<UserDto> listarUsuarios(){
    return userRepository.findAll()
       .stream()
       .map(user -> new UserDto(user.getId(), user.getNome()))
       .collect(Collectors.toList());
}
 @Override
 public UserDto buscarPorId(UUID id){
    User user = userRepository.findById(id)
          .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    
     return new UserDto(user.getId(), user.getNome());
 } 
 @Override
 public void deletarUsuario(UUID id){
     userRepository.deleteById(id);
 }
}
