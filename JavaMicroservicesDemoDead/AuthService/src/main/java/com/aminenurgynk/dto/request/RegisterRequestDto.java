package com.aminenurgynk.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDto {

    @NotBlank(message = "Kullanici adi bos gecilemez. ")
    private String username;
    //@Email
    private String email;
    //TODO password Regex yap
    private String password;
    private String repassword;
}
