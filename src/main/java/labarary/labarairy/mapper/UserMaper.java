package labarary.labarairy.mapper;

import labarary.labarairy.domin.User;
import labarary.labarairy.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring",uses = {})
public interface UserMaper {
    User ToEntity(UserDto userDto);
    UserDto ToDto(User user);


}
