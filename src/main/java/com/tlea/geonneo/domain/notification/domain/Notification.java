package com.tlea.geonneo.domain.notification.domain;

import com.tlea.geonneo.domain.user.domain.User;
import com.tlea.geonneo.global.entity.BaseTimeEntity;
import com.tlea.geonneo.global.utils.BooleanToYNConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "notification_tbl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Notification extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;

    @Column(nullable = false)
    private String sendDongho;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(length = 1, nullable = false)
    private Boolean isRead;

    @Builder
    public Notification(String sendDongho, String content, User user) {
        this.sendDongho = sendDongho;
        this.content = content;
        this.user = user;
        this.isRead = false;
    }

    public void read() {
        this.isRead = true;
    }
}
