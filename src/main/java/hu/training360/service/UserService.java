package hu.training360.service;

import hu.training360.dto.CreateUserCommand;
import hu.training360.dto.UserDto;
import hu.training360.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    private UserMapper userMapper;

    private TodoMapper todoMapper;

    public UserDto createUser(CreateUserCommand command){
        var user = userMapper.toEntity(command);
        userRepository.save(user);
        var userDto = userMapper.toDto(user);
        userDto.setTodoDtoList(todoMapper.toDto(user.getTodoList()));
        return userDto;
    }
}
