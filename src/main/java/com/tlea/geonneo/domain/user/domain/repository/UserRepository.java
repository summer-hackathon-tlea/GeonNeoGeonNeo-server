package com.tlea.geonneo.domain.user.domain.repository;

import com.tlea.geonneo.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByDongho(String dongho);
}
