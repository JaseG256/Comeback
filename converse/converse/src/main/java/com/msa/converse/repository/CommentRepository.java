package com.msa.converse.repository;

import com.msa.converse.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findBySentTo(@Param("sentTo") String sentTo);

    List<Comment> findByTextContains(@Param("text") String text);
}
