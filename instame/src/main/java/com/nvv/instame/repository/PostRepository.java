package com.nvv.instame.repository;

import com.nvv.instame.entity.Post;
import com.nvv.instame.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserAppOrderByCreatedDate(UserApp userApp);
    List<Post> findAllByOrderByCreatedDateDesc();
    Optional<Post> findPostByIdAndUserApp(Long id, UserApp userApp);
}


