package com.aminenurgynk.service;

import com.aminenurgynk.dto.request.LoginRequestDto;
import com.aminenurgynk.dto.request.RegisterRequestDto;
import com.aminenurgynk.exception.AuthServiceException;
import com.aminenurgynk.exception.ErrorType;
import com.aminenurgynk.manager.IUserProfileManager;
import com.aminenurgynk.mapper.IAuthMapper;
import com.aminenurgynk.rabbitmq.model.SaveAuthModel;
import com.aminenurgynk.rabbitmq.producer.CreateUserProducer;
import com.aminenurgynk.repository.IAuthRepository;
import com.aminenurgynk.repository.entity.Auth;
import com.aminenurgynk.utility.JwtTokenManager;
import com.aminenurgynk.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository repository;
    private final JwtTokenManager jwtTokenManager;

    private final IUserProfileManager userProfileManager;

    private final CreateUserProducer createUserProducer;

    public AuthService(IAuthRepository repository, JwtTokenManager jwtTokenManager, IUserProfileManager userProfileManager, CreateUserProducer createUserProducer) {
        super(repository);
        this.repository = repository;
        this.jwtTokenManager = jwtTokenManager;
        this.userProfileManager = userProfileManager;
        this.createUserProducer = createUserProducer;
    }

    public String login(LoginRequestDto dto) {
        Optional<Auth> auth = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (auth.isEmpty()) throw new AuthServiceException(ErrorType.LOGIN_USERNAME_OR_PASSWORD_NOT_EXISTS);
        //return auth.get().getId().toString();
        return jwtTokenManager.createToken(auth.get().getId()).get();
    }

    public Auth register(RegisterRequestDto dto) {
        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);
        auth.setCreateAt(System.currentTimeMillis());
        auth.setState(true);
        save(auth);
        //userProfileManager.save(IAuthMapper.INSTANCE.fromAuth(auth));
        createUserProducer.convertAndSend(SaveAuthModel.builder()
                .authid(auth.getId())
                .username(auth.getUsername())
                .email(auth.getEmail())
                .build());
        return auth;
    }

/*  Tokensiz
   public List<Auth> findAll(){
        return repository.findAll();
    }*/


    //Tokenli
    public List<Auth> findAll(String token){
        Optional<Long> id = null;
        try{
            id = jwtTokenManager.getIdFromToken(token);
        }catch (Exception e){
            throw new AuthServiceException(ErrorType.INVALID_TOKEN);
        }
        //FIXME
        if (findById(id.get()).isEmpty()) throw new AuthServiceException(ErrorType.INVALID_TOKEN);
        return repository.findAll();
    }


}
