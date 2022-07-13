package com.tlea.geonneo.domain.with.domain;

import com.tlea.geonneo.domain.user.domain.User;
import com.tlea.geonneo.domain.with.domain.type.Status;
import com.tlea.geonneo.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "with_tbl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class With extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "with_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int maxNumberOfPeople;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public With(String title, String content, int maxNumberOfPeople, User user) {
        this.title = title;
        this.content = content;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.status = Status.READY;
        this.user = user;
    }
}
