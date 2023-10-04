package com.aminenurgynk.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "tbl_user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long authid;
    private String username;
    private String email;
    private String password;

    private String ad;
    private String address;
    private String phone;
    private String avatar;

    private Long createAt;
    private boolean state;
}
