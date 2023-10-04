package com.aminenurgynk.mapper;


import com.aminenurgynk.dto.request.RegisterRequestDto;
import com.aminenurgynk.dto.request.UserProfileSaveRequestDto;
import com.aminenurgynk.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {

    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    Auth toAuth(final RegisterRequestDto dto);

    @Mapping(target = "authid", source = "id")
    UserProfileSaveRequestDto fromAuth(final Auth auth);

}
