package com.tlea.geonneo.domain.with.domain;

import com.tlea.geonneo.domain.user.domain.User;
import com.tlea.geonneo.domain.with.domain.type.Authority;
import com.tlea.geonneo.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "wither_tbl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Wither extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wither_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "with_id")
    private With with;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Wither(User user, With with, Authority authority) {
        this.user = user;
        this.with = with;
        this.authority = authority;
    }
}