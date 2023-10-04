package com.aminenurgynk.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagingRequestDto {

    private Integer pageSize; //Bir sayfadaki listelenecek kayit sayisi
    private Integer currentPage; //Sayfa numarasi
    private String sortParameter; //Hangi alana gore siralanacak
    private String direction; //ASC, DESC

}
