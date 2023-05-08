package com.travelgo.domain;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String nickName;
    private String mailAddress;
    private String password;

}
