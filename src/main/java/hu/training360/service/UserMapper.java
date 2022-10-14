package hu.training360.service;

import hu.training360.dto.CreateUserCommand;
import hu.training360.dto.UserDto;
import hu.training360.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    default User toEntity(CreateUserCommand command){
        var user = new User();
        user.setUserEmail(command.getEmail());
        return user;
    }

    UserDto toDto(User user);
}
