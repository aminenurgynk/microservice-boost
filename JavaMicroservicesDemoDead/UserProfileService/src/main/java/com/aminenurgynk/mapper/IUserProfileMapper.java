package com.aminenurgynk.mapper;


import com.aminenurgynk.dto.request.UserProfileSaveRequestDto;
import com.aminenurgynk.rabbitmq.model.SaveAuthModel;
import com.aminenurgynk.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {

    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);

    UserProfile toUserProfile(final UserProfileSaveRequestDto dto);

    UserProfile toUserProfile(final SaveAuthModel model);
}
