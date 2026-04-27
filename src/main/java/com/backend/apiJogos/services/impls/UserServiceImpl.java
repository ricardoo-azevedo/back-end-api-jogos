package com.backend.apijogos.services.impls;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.backend.apijogos.dtos.UserDto;
import com.backend.apijogos.models.User;
import com.backend.apijogos.repositories.UserRepository;
import com.backend.apijogos.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{
  private final UserRepository userRepository;

 public UserServiceImpl(UserRepository userRepository){
    this.userRepository = userRepository;
 }
  @Override
  public UserDto criarUsuario(UserDto userDto){
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