package com.aminenurgynk.mapper;

import com.aminenurgynk.dto.request.RegisterRequestDto;
import com.aminenurgynk.dto.request.UserProfileSaveRequestDto;
import com.aminenurgynk.repository.entity.Auth;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-13T13:12:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
@Component
public class IAuthMapperImpl implements IAuthMapper {

    @Override
    public Auth toAuth(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Auth.AuthBuilder auth = Auth.builder();

        auth.username( dto.getUsername() );
        auth.password( dto.getPassword() );
        auth.email( dto.getEmail() );

        return auth.build();
    }

    @Override
    public UserProfileSaveRequestDto fromAuth(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        UserProfileSaveRequestDto.UserProfileSaveRequestDtoBuilder userProfileSaveRequestDto = UserProfileSaveRequestDto.builder();

        userProfileSaveRequestDto.authid( auth.getId() );
        userProfileSaveRequestDto.username( auth.getUsername() );
        userProfileSaveRequestDto.email( auth.getEmail() );

        return userProfileSaveRequestDto.build();
    }
}
