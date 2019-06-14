package com.msa.converse.service;

import com.msa.converse.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService extends CrudService<Comment> {

    List<Comment> listAll();

    Optional<Comment> getById(Long id);

    List<Comment> findBySentTo(String sentTo);

    List<Comment> findByTextContains(String text);
}
