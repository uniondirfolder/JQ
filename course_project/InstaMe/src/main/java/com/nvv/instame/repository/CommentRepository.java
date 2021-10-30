package com.nvv.instame.repository;

import com.nvv.instame.entity.Comment;
import com.nvv.instame.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);
    Comment findByIdAndUserId(Long commentId, Long userId);
}
