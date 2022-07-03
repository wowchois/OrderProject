package com.chois.payorder.user.dto;

import com.chois.payorder.user.entity.User;
import lombok.Getter;

@Getter
public class UserDto {
    private long id;
    private int points;

    public UserDto(long id, int points){
        this.id = id;
        this.points = points;
    }

    public User toEntity(){
        return new User(id,points);
    }
}
