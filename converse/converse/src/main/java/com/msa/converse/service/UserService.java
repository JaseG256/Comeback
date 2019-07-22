package com.msa.converse.service;

import com.msa.converse.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends CrudService<User> {

    List<User> listAll();

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
