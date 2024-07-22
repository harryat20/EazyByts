package com.harry.tradingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.harry.tradingapp.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.Data;

import java.security.PrivilegedAction;

@Entity
@Table(name = "\"user\"")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Embedded
//    @JsonIgnore
    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();

    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;


}
