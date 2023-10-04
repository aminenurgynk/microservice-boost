package com.aminenurgynk.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    MUSTERI_BULUNAMADI(1003,"Aradığınız müşteri sistemde kayıtlı değil", NOT_FOUND),
    URUN_EKLEME_HATASI(2001,"Ürün ekleme başarısız oldu", INTERNAL_SERVER_ERROR),
    INVALID_PARAMETER(3001,"Geçersiz parametre girişi yaptınız", BAD_REQUEST),

    REGISTER_PASSWORD_MISMACTH(4001,"Girilen parolalar eşleşmedi.", BAD_REQUEST),
    REGISTER_USERNAME_EXISTS(4002,"Geçersiz parametre girişi yaptınız", BAD_REQUEST),

    LOGIN_USERNAME_OR_PASSWORD_NOT_EXISTS(5001,"Girilen kullanıcı adı veya parola hatalı.", BAD_REQUEST),

    INVALID_TOKEN(6001,"Girilen token gecersiz.", BAD_REQUEST);


    private int code;
    private String message;
    private HttpStatus status;
}
