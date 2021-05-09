package com.yoon.restapi1.dto;

import com.yoon.restapi1.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String phone;
    private String address;

    public User toUser(){
        User user = User.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .address(address)
                .build();

        return user;
    }
}
