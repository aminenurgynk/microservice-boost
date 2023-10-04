package com.aminenurgynk.mapper;

import com.aminenurgynk.repository.entity.UserProfile;
import com.aminenurgynk.dto.request.UserProfileSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {

    IUserProfileMapper INSTANCE= Mappers.getMapper(IUserProfileMapper.class);

    @Mapping(target = "userProfileId",  source = "id")
    UserProfile toUserProfile(final UserProfileSaveRequestDto dto);

}
