package com.nvv.instame.repository;

import com.nvv.instame.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserApp,Long> {
    Optional<UserApp> findUserAppByNickName(String nickname);
    Optional<UserApp> findUserAppByEmail(String email);
    Optional<UserApp> findUserAppById(Long id);
}

