package com.aminenurgynk.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDto {


    @NotBlank(message = "Kullanici adi bos gecilemez")
    @Size(min = 2, max = 50)
    private String username;
    private String password;
}
