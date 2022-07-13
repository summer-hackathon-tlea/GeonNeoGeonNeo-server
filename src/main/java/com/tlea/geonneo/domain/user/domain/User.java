package com.tlea.geonneo.domain.user.domain;

import com.tlea.geonneo.domain.notification.domain.Notification;
import com.tlea.geonneo.domain.with.domain.With;
import com.tlea.geonneo.domain.with.domain.Wither;
import com.tlea.geonneo.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_tbl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String dongho;

    @Column(length = 60, nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<With> withs = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Wither> withers = new ArrayList<>();

    @Builder
    public User(String dongho, String password) {
        this.dongho = dongho;
        this.password = password;
    }
}
