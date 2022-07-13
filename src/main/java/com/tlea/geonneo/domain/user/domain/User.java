package com.tlea.geonneo.domain.user.domain;

import com.tlea.geonneo.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dongho;

    @Column(length = 60, nullable = false)
    private String password;

    @Builder
    public User(String dongho, String password) {
        this.dongho = dongho;
        this.password = password;
    }
}
