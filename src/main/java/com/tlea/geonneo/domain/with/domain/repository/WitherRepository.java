package com.tlea.geonneo.domain.with.domain.repository;

import com.tlea.geonneo.domain.user.domain.User;
import com.tlea.geonneo.domain.with.domain.With;
import com.tlea.geonneo.domain.with.domain.Wither;
import com.tlea.geonneo.domain.with.domain.type.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WitherRepository extends JpaRepository<Wither, Long> {

    boolean existsByWithAndUser(With with, User user);
    boolean existsByWithAndUserAndAuthority(With with, User user, Authority authority);
}
