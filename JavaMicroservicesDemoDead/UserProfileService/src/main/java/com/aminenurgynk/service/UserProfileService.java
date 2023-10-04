package com.aminenurgynk.service;

import com.aminenurgynk.manager.IElasticServiceManager;
import com.aminenurgynk.mapper.IUserProfileMapper;
import com.aminenurgynk.rabbitmq.model.SaveAuthModel;
import com.aminenurgynk.repository.IUserProfileRepository;
import com.aminenurgynk.repository.entity.UserProfile;
import com.aminenurgynk.dto.request.UserProfileSaveRequestDto;
import com.aminenurgynk.utility.ServiceManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class UserProfileService extends ServiceManager<UserProfile, Long> {

    private final IUserProfileRepository repository;
    private final IElasticServiceManager elasticServiceManager;

    public UserProfileService(IUserProfileRepository repository, IElasticServiceManager elasticServiceManager) {
        super(repository);
        this.repository = repository;
        this.elasticServiceManager = elasticServiceManager;
    }


    public Boolean doSave(UserProfileSaveRequestDto dto) {

        save(IUserProfileMapper.INSTANCE.toUserProfile(dto));
        return true;
    }


    @Cacheable(value = "getUpperCase")
    public String getUpperCase(String firstName){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return firstName.toUpperCase();
    }

    @CacheEvict(value = "getUpperCase", allEntries = true)
    public void clearCache(){
        System.out.println(" getUpperCase icin cache degerleri silindi.");
    }

    public void saveRabbit(SaveAuthModel model) {
        UserProfile userProfile = IUserProfileMapper.INSTANCE.toUserProfile(model);
        save(userProfile);
        elasticServiceManager.addUser(userProfile);
    }



}
