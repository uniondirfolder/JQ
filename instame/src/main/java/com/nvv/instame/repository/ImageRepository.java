package com.nvv.instame.repository;

import com.nvv.instame.entity.ImageApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageApp, Long> {
    Optional<ImageApp> findByUserId(Long userId);
    Optional<ImageApp> findByPostId(Long postId);
}
