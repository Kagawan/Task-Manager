package hexlet.code.mappers;

import hexlet.code.dto.users.UserCreateDTO;
import hexlet.code.dto.users.UserDTO;
import hexlet.code.dto.users.UserUpdateDTO;
import hexlet.code.model.User;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T11:19:43+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.4 (Ubuntu)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    @Override
    public User map(UserCreateDTO dto) {
        encryptPassword( dto );

        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setPasswordDigest( dto.getPassword() );
        user.setFirstName( dto.getFirstName() );
        user.setLastName( dto.getLastName() );
        user.setEmail( dto.getEmail() );

        return user;
    }

    @Override
    public UserDTO map(User model) {
        if ( model == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( model.getId() );
        userDTO.setFirstName( model.getFirstName() );
        userDTO.setLastName( model.getLastName() );
        userDTO.setEmail( model.getEmail() );
        if ( model.getCreatedAt() != null ) {
            userDTO.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( model.getCreatedAt() ) );
        }

        return userDTO;
    }

    @Override
    public void update(UserUpdateDTO dto, User model) {
        if ( dto == null ) {
            return;
        }

        if ( jsonNullableMapper.isPresent( dto.getFirstName() ) ) {
            model.setFirstName( jsonNullableMapper.unwrap( dto.getFirstName() ) );
        }
        if ( jsonNullableMapper.isPresent( dto.getLastName() ) ) {
            model.setLastName( jsonNullableMapper.unwrap( dto.getLastName() ) );
        }
        if ( jsonNullableMapper.isPresent( dto.getEmail() ) ) {
            model.setEmail( jsonNullableMapper.unwrap( dto.getEmail() ) );
        }
        if ( jsonNullableMapper.isPresent( dto.getPasswordDigest() ) ) {
            model.setPasswordDigest( jsonNullableMapper.unwrap( dto.getPasswordDigest() ) );
        }
    }
}
