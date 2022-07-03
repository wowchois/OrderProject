package com.chois.payorder.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    private Long id;

    @Column(nullable = false)
    private int points;

    @Builder
    public User(long id, int points){
        this.id = id;
        this.points = points;
    }
}
